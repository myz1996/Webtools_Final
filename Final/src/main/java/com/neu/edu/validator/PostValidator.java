package com.neu.edu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Post;


public class PostValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//This Validator validates *just* User instances
		return Post.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//basic validations
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "empty.content", "content is Required");
		
		
		//add additional custom validations below
	}
}
