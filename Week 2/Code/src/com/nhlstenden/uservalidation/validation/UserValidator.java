package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class UserValidator
{
	private final List<ValidationRule> rules;

	public UserValidator()
	{
		this.rules = new ArrayList<ValidationRule>();
	}

	public void addRule(ValidationRule rule) throws Exception
	{
		if (rule == null)
		{
			throw new IllegalArgumentException("The rule cannot be NULL.");
		}
		this.rules.add(rule);
	}

	public boolean validate(UserAccount account)
	{
		for (ValidationRule rule : this.rules)
		{
			if (!rule.validate(account))
			{
				return false;
			}
		}
		return true;
	}
}