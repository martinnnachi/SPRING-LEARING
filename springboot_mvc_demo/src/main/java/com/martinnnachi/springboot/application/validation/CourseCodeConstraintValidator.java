package com.martinnnachi.springboot.application.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {

        if (theCode != null) {
            return theCode.startsWith( coursePrefix );

        } else {
            return true;
        }
    }
}
