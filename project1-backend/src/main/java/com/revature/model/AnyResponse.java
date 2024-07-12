package com.revature.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/*
    can be filled with anything and responded back to the browser.
    May be general purpose and handy for development util a concrete class is known
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnyResponse
{
    private String secretInformation;

    public String getSecretInformation() {
        return secretInformation;
    }

    public void setSecretInformation(String secretInformation) {
        this.secretInformation = secretInformation;
    }
}
