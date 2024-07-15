package com.revature.services;

import com.revature.model.AnyResponse;
import com.revature.model.User;
import com.revature.repositories.UserRepo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        userInDatabase.setPassword("");
        userInDatabase.setSecretInformation("");
        return userInDatabase;
    }

    public User login(String username,String password){
        return new User();
    }

    public AnyResponse myPrivateInfo(User loggedInUser){
        AnyResponse r=new AnyResponse();
        r.setSecretInformation(loggedInUser.getSecretInformation());
        return r;
    }
}
