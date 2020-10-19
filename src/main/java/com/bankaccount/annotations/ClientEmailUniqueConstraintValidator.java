package com.bankaccount.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bankaccount.services.client.IfClientEmailExistsService;

public class ClientEmailUniqueConstraintValidator implements ConstraintValidator<ClientEmailUnique, String> {

//	@Autowired
	private IfClientEmailExistsService ifClientEmailExists;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		try {
			Boolean response = ifClientEmailExists.execute(value);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
