package com.charter.rewards.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class NumberOnlyValidator implements ConstraintValidator<NumberOnlyConstraint, String> {

        @Override
        public void initialize(NumberOnlyConstraint numberOnlyConstraint) {
                /**
                 * Just an empty method
                 */
        }

        @Override
        public boolean isValid(String text, ConstraintValidatorContext cxt) {
                return text != null && text.matches("^\\d*$");
        }

}
