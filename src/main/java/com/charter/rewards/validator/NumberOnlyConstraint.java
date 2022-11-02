package com.charter.rewards.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = NumberOnlyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberOnlyConstraint {
    String message() default "Invalid data, must contain only digit.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
