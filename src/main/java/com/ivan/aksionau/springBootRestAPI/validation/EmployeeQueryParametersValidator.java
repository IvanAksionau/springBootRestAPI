package com.ivan.aksionau.springBootRestAPI.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeQueryParametersValidator implements ConstraintValidator<AllowedKey, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Additional value validation if needed
        // For example, you can check if the value is an integer or has a specific format
        // return isValidValue(value);
        return true; // Return true for now since we're only validating the key
    }
}
