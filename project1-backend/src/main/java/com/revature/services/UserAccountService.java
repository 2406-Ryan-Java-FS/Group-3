package com.revature.services;

import com.revature.model.AnyResponse;
import com.revature.model.User;
import com.revature.repositories.UserRepo;
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
        return new User();
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
