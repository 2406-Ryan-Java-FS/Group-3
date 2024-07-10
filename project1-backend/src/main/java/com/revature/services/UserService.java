package com.revature.services;

import com.revature.model.User;
import com.revature.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;

    public List<User> findAll(){
        return userRepo.findAll();
    }
}
