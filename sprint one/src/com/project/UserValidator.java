package com.project;

/**
 * this class is only responsible for validation
 **/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

	public boolean validate(User user) {
		
		return isValidUser(user);
	}
	
	private boolean isValidUser(User user) {
		
		if (!isPresent(user.getName())) {
			return false;
		}
		
		user.setName(user.getName().trim());
		if (!isValidAlphaNumeric(user.getName())) {
			System.out.println("Enter valid name, please");
			return false;
		}
		
		if (user.getEmail() == null || user.getEmail().trim().length() ==0) {
			System.out.println("Enter valid Email,please");
			return false;
		}
		
		user.setEmail(user.getEmail().trim());
		if (!isValidEmail(user.getEmail())) {
			System.out.println("Enter valid Email, please");
			return false;
		}
		
		return true;
	}
	
	private boolean isPresent(String name) {
		return name!=null && name.trim().length() >=3;
	}
	
	private boolean isValidAlphaNumeric(String name) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher matcher = pattern.matcher(name);
		return !matcher.find();
	}
	
	private boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile("^[A-Za-z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z0-9]{2,})$");
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}
	
}
