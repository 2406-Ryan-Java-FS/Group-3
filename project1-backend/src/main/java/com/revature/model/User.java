package com.revature.model;

import java.sql.Date;
//import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name="users")//,schema="project1")//h2 is not creating this schema
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;
    private String role;
    private String password;
    private String secretInformation;//used to make sure others are denied access

    private Date tokenIssuedOn;
    private Date tokenExpiresOn;
    private String tokenId;         //used for lookup
    private String tokenPassword;   //used for validation


    public String getSecretInformation() {
        return secretInformation;
    }
    public void setSecretInformation(String secretInformation) {
        this.secretInformation = secretInformation;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getTokenIssuedOn() {
        return tokenIssuedOn;
    }
    public void setTokenIssuedOn(Date tokenIssuedOn) {
        this.tokenIssuedOn = tokenIssuedOn;
    }
    public Date getTokenExpiresOn() {
        return tokenExpiresOn;
    }
    public void setTokenExpiresOn(Date tokenExpiresOn) {
        this.tokenExpiresOn = tokenExpiresOn;
    }
    public String getTokenId() {
        return tokenId;
    }
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
    public String getTokenPassword() {
        return tokenPassword;
    }
    public void setTokenPassword(String tokenPassword) {
        this.tokenPassword = tokenPassword;
    }

    
}
