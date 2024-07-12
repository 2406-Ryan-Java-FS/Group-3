package com.revature.controllers;

import com.revature.Project1Application;
import com.revature.model.AnyResponse;
import com.revature.model.User;
import com.revature.services.UserAccountService;
import com.revature.services.UserService;
import org.hibernate.mapping.Any;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired UserService userService;
    @Autowired UserAccountService userAccountService;

//    @GetMapping
//    public String home(){
//        return "<h1>project1 backend is running</h1>";
//    }

    @PostMapping("register")
    public User register(@RequestBody User newUserToCreate) {
        return userAccountService.register(newUserToCreate);
    }

    @PostMapping("login")
    public User login(@RequestHeader("username") String username,
                      @RequestHeader("password") String password)
    {
        return userAccountService.login(username,password);
    }

    @GetMapping("my-private-info")
    public AnyResponse myPrivateInfo(@ModelAttribute("loggedInUser") User loggedInUser){
        return userAccountService.myPrivateInfo(loggedInUser);
    }
}
