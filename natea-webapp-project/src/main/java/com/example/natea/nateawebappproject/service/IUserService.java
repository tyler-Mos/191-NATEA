package com.example.natea.nateawebappproject.service;

import com.example.natea.nateawebappproject.controller.UserDto;
import com.example.natea.nateawebappproject.error.UserAlreadyExistException;
import com.example.natea.nateawebappproject.model.User;

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

}
