package mum.edu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mum.edu.domain.Rider;
import mum.edu.domain.Username;

@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Rider.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userCredentials.password", "required.password", "");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userCredentials.verifyPassword", "required.verifyPassword", "");
		
		Rider rider = (Rider) target;
		if (!(rider.getUserCredentials().getPassword().equals(rider.getUserCredentials().getVerifyPassword()))) {
			errors.rejectValue("userCredentials.password", "notmatch.password");
		}
	}
	

}
