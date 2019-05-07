package com.neu.edu.validator;

import org.springframework.validation.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.neu.edu.pojo.Comment;


public class CommentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//This Validator validates *just*  instances
		return Comment.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//basic validations
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "empty.content", "content is Required");

		
		//add additional custom validations below
	}
}
