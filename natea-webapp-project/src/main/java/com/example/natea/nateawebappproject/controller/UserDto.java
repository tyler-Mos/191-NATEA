package com.example.natea.nateawebappproject.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.natea.nateawebappproject.validation.IsMatchingPassword;
import com.example.natea.nateawebappproject.validation.ValidEmail;

@IsMatchingPassword
public class UserDto {

    @NotNull
    @NotEmpty
    private String firstName;
    
    @NotNull
    @NotEmpty
    private String lastName;
     
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;
    
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;
     
    // standard getters and setters
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMatchingPassword() {
        return this.matchingPassword;
    }
    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}