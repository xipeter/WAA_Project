package mum.edu.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class AddressValidator implements ConstraintValidator<Address, String> {

	@Override
	public void initialize(Address arg0) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("validator " + value);

		return value == null ? true : false;
	}

}
