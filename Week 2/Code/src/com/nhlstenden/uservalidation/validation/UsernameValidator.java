package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.UserAccount;
import com.nhlstenden.uservalidation.user.UserAccountStorage;

public class UsernameValidator implements ValidationRule
{
	private final UserAccountStorage storage;

	public UsernameValidator(UserAccountStorage storage)
	{
		this.storage = storage;
	}

	@Override
	public boolean validate(UserAccount account)
	{
		return !this.storage.existsByName(account.getName());
	}
}