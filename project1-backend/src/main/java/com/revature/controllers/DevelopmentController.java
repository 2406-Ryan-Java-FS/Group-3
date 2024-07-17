package com.revature.controllers;

import com.revature.model.AnyResponse;
import com.revature.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Used to manage database tables during development and testing.
    This controller must not compile into final production build.
    Using spring profiles to enable/disable it for now.
 */
@Profile({"h2","rsc"})
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

    @DeleteMapping("/all")
    public AnyResponse clear()
    {
        categoryRepo.deleteAll();
        orderItemRepo.deleteAll();
        orderRepo.deleteAll();
        producRepo.deleteAll();
        userRepo.deleteAll();
        return new AnyResponse("Cleared all database tables");
    }
}
