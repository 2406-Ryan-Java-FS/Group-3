package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.UserRepo;

@Service
public class LoginService {

    private static final Logger logger= LoggerFactory.getLogger(LoginService.class);

    @Autowired UserRepo userRepo;
    
    public
}
