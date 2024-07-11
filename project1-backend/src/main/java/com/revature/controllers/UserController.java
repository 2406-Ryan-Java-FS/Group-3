package com.revature.controllers;

import com.revature.Project1Application;
import com.revature.model.User;
import com.revature.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping
    public String home(){
        return "<h1>project1 backend is running</h1>";
    }

    @GetMapping("findAll")
    public List<User> findAll(){

        return userService.findAll();
    }
}
