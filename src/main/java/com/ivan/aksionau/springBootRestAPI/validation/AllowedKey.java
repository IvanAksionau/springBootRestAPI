package com.ivan.aksionau.springBootRestAPI.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^(name|email)$", message = "Invalid query parameter key")
public @interface AllowedKey {
    String message() default "Invalid query parameter key, only 'name' and 'email' are allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
