package com.example.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
import com.example.models.User;

public class UserValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//Inside of the validate method, we do the actual logic to validate the object
		//We can make sure the client passed all the important information into the user object
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "user object must contain a first name field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty", "user object must contain a last name field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "user object must contain an email field");
		
		//We can also do other checks, such as if the id is negative, or if the password is not long enough
		
		User u = (User) target;
		
		if(u.getId() < 0) {
			errors.rejectValue("id", "invalid.userId", "users cannot have a negative id");
		}
		
		if(u.getPassword().length() < 8) {
			errors.rejectValue("password", "invalid.password", "users passwords must be at least 8 characters");
		}
		
	}

}
