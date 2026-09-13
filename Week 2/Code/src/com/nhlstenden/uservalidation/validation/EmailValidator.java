package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.UserAccount;

import java.util.regex.Pattern;

public class EmailValidator implements ValidationRule
{
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	// REGEX check for any character in the English alphabet, number or special characters, @, 
	// the domain name from any character in the English alphabet, 
	// and an extension or 2 or more characters (excluding the .)

	@Override
	public boolean validate(UserAccount account)
	{
		return EMAIL_PATTERN.matcher(account.getEmail()).matches();
	}
}	