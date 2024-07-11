package com.revature.model;

import java.sql.Date;
//import javax.persistence.*;
import jakarta.persistence.*;


@Entity
@Table(name="users",schema="project1")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;
    private String password;
    private String role;

    private Date tokenIssuedOn;
    private Date tokenExpiresOn;
    private String tokenId;         //used for lookup
    private String tokenPassword;   //used for validation

    public User() {}

    public User(Integer userId, String name, String password, String role, Date tokenIssuedOn, Date tokenExpiresOn, String tokenId, String tokenPassword) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.role = role;
        this.tokenIssuedOn = tokenIssuedOn;
        this.tokenExpiresOn = tokenExpiresOn;
        this.tokenId = tokenId;
        this.tokenPassword = tokenPassword;
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
