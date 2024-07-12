package com.revature.advice;

import com.revature.model.User;
import com.revature.repositories.UserRepo;

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

@Profile("rsc")
@ControllerAdvice
public class LoginAdvice {

    private static final Logger logger= LoggerFactory.getLogger(LoginAdvice.class);

    @Autowired
    UserRepo accountRepo;

    /*
        Finds the logged in account given a sessionToken
        passes the logged in account to the RestController
     */
    @ModelAttribute("sessionAccount")
    public User checkForLogin(HttpServletRequest everyRequest) throws InterruptedException {
        logger.info("");
        logger.info("------"+everyRequest.getRequestURI()+"------");
        //Thread.sleep(500);
        if(everyRequest.getRequestURI().equals("/login"))return null;//ignore this endpoint

        if(StringUtils.isEmpty(everyRequest.getHeader("tokenId")))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"session tokenId required");

        String tokenId=everyRequest.getHeader("tokenId");
        logger.info("tokenId = " + tokenId);

        List<User> matchingAccounts=accountRepo.findByTokenId(tokenId);

        if(matchingAccounts.size()==0)throw new ResponseStatusException(
            HttpStatus.UNAUTHORIZED,"No Valid session for account within database");
        if(matchingAccounts.size()>1)throw new ResponseStatusException(
            HttpStatus.UNAUTHORIZED,"More than one session somehow within the database");

        return matchingAccounts.get(0);
    }
}
