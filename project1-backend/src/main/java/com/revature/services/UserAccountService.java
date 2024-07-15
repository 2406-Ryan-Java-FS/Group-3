package com.revature.services;

import com.revature.model.AnyResponse;
import com.revature.model.User;
import com.revature.repositories.UserRepo;
import com.revature.util.Help;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Year;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

/*
    Functionality for user accounts creation and login
    May or may not use UserService, can't decide right now
 */
@Service
public class UserAccountService {

    private static final Logger logger= LoggerFactory.getLogger(UserAccountService.class);

    @Autowired UserRepo userRepo;

    public User register(User newUserToCreate){
        if(userRepo.count()>50)
            throw new RuntimeException("Reached user account limit. Can not create another.");
        if(StringUtils.isEmpty(newUserToCreate.getName()))
            throw new RuntimeException("Please provide a name for this new user");
        if(StringUtils.isEmpty(newUserToCreate.getPassword()))
            throw new RuntimeException("Please provide a password for this new user");

        newUserToCreate.setRole("UNDERLING");
        User userInDatabase=userRepo.save(newUserToCreate);

        return userInDatabase.userWithoutSensitiveInfo();
    }

    public User login(String username,String password)
    {
        //need to use feistel cipher for password comparison, but we'll live with this for now
        List<User> usersFound=userRepo.findByNameAndPassword(username,password);

        if(usersFound.size()==0)
            throw new RuntimeException("Could not find a user for that username and password combination");
        if(usersFound.size()>1)
            throw new RuntimeException("There are too many users with that username and password combination somehow");

        User loggedInUser=usersFound.get(0);

        Calendar cal=Calendar.getInstance();
        loggedInUser.setTokenIssuedOn(new Date(cal.getTimeInMillis()));
        cal.add(Calendar.DAY_OF_YEAR,10);
        loggedInUser.setTokenExpiresOn(new Date(cal.getTimeInMillis()));

        loggedInUser.setTokenId(        Double.toString(Math.random()*Long.MAX_VALUE));
        loggedInUser.setTokenPassword(  Double.toString(Math.random()*Long.MAX_VALUE));

        userRepo.save(loggedInUser);

        return loggedInUser.userWithoutSensitiveInfo();
    }

    public AnyResponse myPrivateInfo(User loggedInUser){
        AnyResponse r=new AnyResponse();
        r.setSecretInformation(loggedInUser.getSecretInformation());
        return r;
    }
}
