package com.bankaccount.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CPFConstraintValidator.class)
public @interface CPF {
	String message() default "CPF is invalid";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
