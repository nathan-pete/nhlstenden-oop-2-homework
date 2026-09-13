package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.UserAccount;

public class PasswordValidator implements ValidationRule
{
	private final boolean allowSpaces;
	private final boolean requireSpecialChar;
	private final boolean requireNumber;
	private final boolean requireLowercase;
	private final boolean requireUppercase;

	public PasswordValidator(boolean allowSpaces, boolean requireSpecialChar, boolean requireNumber, boolean requireLowercase, boolean requireUppercase)
	{
		this.allowSpaces = allowSpaces;
		this.requireSpecialChar = requireSpecialChar;
		this.requireNumber = requireNumber;
		this.requireLowercase = requireLowercase;
		this.requireUppercase = requireUppercase;
	}

	@Override
	public boolean validate(UserAccount account)
	{
		String password = account.getPassword();

		if (!this.allowSpaces && password.contains(" "))
		{
			return false;
		}

		boolean hasSpecialChar = false;
		boolean hasNumber = false;
		boolean hasLowercase = false;
		boolean hasUppercase = false;

		for (char character : password.toCharArray())
		{
			if (Character.isDigit(character))
			{
				hasNumber = true;
			}
			else if (Character.isLowerCase(character))
			{
				hasLowercase = true;
			}
			else if (Character.isUpperCase(character))
			{
				hasUppercase = true;
			}
			else if (!Character.isLetterOrDigit(character) && character != ' ')
			{
				hasSpecialChar = true;
			}
		}

		if (this.requireSpecialChar && !hasSpecialChar)
		{
			return false;
		}
		if (this.requireNumber && !hasNumber)
		{
			return false;
		}
		if (this.requireLowercase && !hasLowercase)
		{
			return false;
		}
		return !this.requireUppercase || hasUppercase;
	}
}