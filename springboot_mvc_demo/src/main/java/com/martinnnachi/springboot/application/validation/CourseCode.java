package com.martinnnachi.springboot.application.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD} )
@Retention(RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "MRT";

    // define default error message
    public String message() default "Must start with MRT";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}
