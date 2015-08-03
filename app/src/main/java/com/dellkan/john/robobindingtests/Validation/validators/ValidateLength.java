package com.dellkan.john.robobindingtests.Validation.validators;

import com.dellkan.john.robobindingtests.Validation.ComparisonTypes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateLength {
    ComparisonTypes comparison() default ComparisonTypes.LENGTH_EXACTLY;
    double min();
    double max() default 0;
    int error() default 0;
}
