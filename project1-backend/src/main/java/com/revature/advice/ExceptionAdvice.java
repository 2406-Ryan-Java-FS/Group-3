package com.revature.advice;

import com.revature.model.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

/*
    Catches exceptions, converts them to our own json response object.
    We want to limit how much error information we reveal to the browser.
 */
@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger logger= LoggerFactory.getLogger(ExceptionAdvice.class);

    //Respond any exception back to the browser with limited information
    @ExceptionHandler()///Exception.class
    public final ResponseEntity<ExceptionResponse> handleAll(Exception ex, WebRequest request)
    {
        if(ex.getClass()==ResponseStatusException.class)
        {
            String reason=((ResponseStatusException) ex).getReason();
            logger.error(reason);
            return new ResponseEntity<>(new ExceptionResponse(reason),HttpStatus.UNAUTHORIZED);

        }else {
            logger.error(ex.toString());
            return new ResponseEntity<>(new ExceptionResponse(ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
