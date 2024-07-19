package com.revature.controllers;

import com.revature.model.AnyResponse;
import com.revature.model.User;
import com.revature.repositories.*;
import com.revature.util.Help;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

/*
    Used to manage database tables during development and testing.
    This controller must not compile into final production build.
    Using spring profiles to enable/disable it for now.
 */
//@Profile({"h2","rsc"})
@RestController
@RequestMapping("/development")
public class DevelopmentController
{
    private static final Logger logger= LoggerFactory.getLogger(DevelopmentController.class);

    @Autowired CategoryRepo categoryRepo;
    @Autowired OrderItemRepo orderItemRepo;
    @Autowired OrderRepo orderRepo;
    @Autowired ProductRepo producRepo;
    @Autowired UserRepo userRepo;

    /**
    so qunit can remove a user after it's done.
    trying to demo, so we're using default profile.
    using our own security to so only the logged in user can delete themselves, bonus points!
     */
    @DeleteMapping("/user")
    public AnyResponse clear(@ModelAttribute("loggedInUser") User loggedInUser)
    {
        logger.info("loggedInUser to delete="+ Help.json(loggedInUser,false,true));
        userRepo.delete(loggedInUser);
        return new AnyResponse("Deleted user "+loggedInUser.getName());
    }

//    @DeleteMapping("/all")
//    public AnyResponse clear()
//    {
//        categoryRepo.deleteAll();
//        orderItemRepo.deleteAll();
//        orderRepo.deleteAll();
//        producRepo.deleteAll();
//        userRepo.deleteAll();
//        return new AnyResponse("Cleared all database tables");
//    }
}
