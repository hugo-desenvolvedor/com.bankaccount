package com.bankaccount.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ METHOD, FIELD, TYPE })
@Constraint(validatedBy = ClientEmailUniqueConstraintValidator.class)
public @interface ClientEmailUnique {
	String message() default "Email unique default message";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}