package com.revature.advice;

import com.revature.repositories.UserRepo;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class LoginAdvice {

    private static final Logger logger= LoggerFactory.getLogger(LoginAdvice.class);

    @Autowired
    UserRepo accountRepo;

    /*
        Finds the logged in account given a sessionToken
        passes the logged in account to the RestController
     */
//    @ModelAttribute("sessionAccount")
//    public Account checkForLogin(HttpServletRequest everyRequest) throws InterruptedException {
//        logger.info("");
//        logger.info("------"+everyRequest.getRequestURI()+"------");
//        //Thread.sleep(500);
//        if(everyRequest.getRequestURI().equals("/login"))return null;//ignore this endpoint
//
//        if(Help.isGone(everyRequest.getHeader("sessionToken")))throw new ExceptionUnauthorized("session token required");
//
//        int sessionToken=Integer.parseInt(everyRequest.getHeader("sessionToken"));
//        logger.info("sessionToken = " + sessionToken);
//
//        List<Account> matchingAccounts=accountRepo.findBySessionToken(sessionToken);
//
//        if(matchingAccounts.size()==0)throw new ExceptionUnauthorized("No Valid session for account within database");
//        if(matchingAccounts.size()>1)throw new ExceptionUnauthorized("More than one session somehow within the database");
//
//        return matchingAccounts.get(0);
//    }
}
