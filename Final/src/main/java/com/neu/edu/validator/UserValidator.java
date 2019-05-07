package com.neu.edu.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//This Validator validates *just* User instances
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//basic validations
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty.username", "Username is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Password is Required");
		
		//add additional custom validations below
	}
}
