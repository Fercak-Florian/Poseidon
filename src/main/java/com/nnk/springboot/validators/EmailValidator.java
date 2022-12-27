package com.nnk.springboot.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String>{

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		//return email != null && email.matches("[0-9]+") && (email.length() > 8);
		//return email.matches("flo");
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.]+@[a-z.]+$");
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

}
