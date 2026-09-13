package com.nhlstenden.uservalidation.user;

import java.util.ArrayList;
import java.util.List;

public class UserAccountStorage
{
	private final List<UserAccount> accounts; //final as the object "accounts" doesn't change

	public UserAccountStorage()
	{
		this.accounts = new ArrayList<UserAccount>();
	}

	public void save(UserAccount account) throws Exception
	{
		if (account == null)
		{
			throw new IllegalArgumentException("The account cannot be NULL.");
		}
		this.accounts.add(account);
	}

	public boolean existsByName(String name)
	{
		for (UserAccount account : this.accounts)
		{
			if (account.getName().equals(name))
			{
				return true;
			}
		}
		return false;
	}
}