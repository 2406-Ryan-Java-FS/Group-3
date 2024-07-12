package com.revature.model;

/*
    Used to show an error message back to the browser
    de-serializes as json which is better than just a String response
 */
public class ExceptionResponse {

    public String errorMessage;

    public ExceptionResponse(String errorMessage) {
        this.errorMessage=errorMessage;
    }

    public ExceptionResponse(Exception ex){
        this.errorMessage=ex.getMessage();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
