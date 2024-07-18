package com.revature.services;

import com.revature.controllers.UserController;
import com.revature.model.User;
import com.revature.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger= LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepo userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public User getUserById(int id){
        return userRepo.findById(id).orElseGet(User::new);
    }
}
