package com.revature.advice;

import com.revature.model.User;
import com.revature.repositories.UserRepo;

import com.revature.util.Help;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Profile({"h2","rsc"})
@ControllerAdvice
public class LoginAdvice {

    private static final Logger logger= LoggerFactory.getLogger(LoginAdvice.class);

    @Autowired
    UserRepo userRepo;

    /*
        Finds the logged in account given a sessionToken
        passes the logged in account to the RestController
     */
    @ModelAttribute("loggedInUser")
    public User checkForLogin(HttpServletRequest everyRequest) throws InterruptedException {
        logger.info("");
        logger.info("------"+everyRequest.getRequestURI()+"------");
        //Thread.sleep(500);
        if(everyRequest.getRequestURI().equals("/users/login"))     return null;//ignore this endpoint
        if(everyRequest.getRequestURI().equals("/users/register"))  return null;//and this one
        if(everyRequest.getRequestURI().contains("/development"))   return null;

        if(StringUtils.isEmpty(everyRequest.getHeader("tokenId")))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"session tokenId required");

        if(StringUtils.isEmpty(everyRequest.getHeader("tokenPassword")))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"session tokenPassword required");

        String tokenId=everyRequest.getHeader("tokenId");
        String tokenPassword=everyRequest.getHeader("tokenPassword");
        logger.info("tokenId = " + tokenId);

        logger.info("userRepo.findAll()="+ Help.json(userRepo.findAll(),true,true));

        List<User> matchingAccounts= userRepo.findByTokenIdAndTokenPassword(tokenId,tokenPassword);

        if(matchingAccounts.size()==0)throw new ResponseStatusException(
            HttpStatus.UNAUTHORIZED,"No Valid session for account within database");
        if(matchingAccounts.size()>1)throw new ResponseStatusException(
            HttpStatus.UNAUTHORIZED,"More than one session somehow within the database");

        User loggedInUser=matchingAccounts.get(0);
        logger.info("loggedInUser="+ Help.json(loggedInUser,false,true));
        return loggedInUser;
    }
}
