package com.example.natea.nateawebappproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.example.natea.nateawebappproject.controller.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<IsMatchingPassword, Object> {

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
    
}