package com.nhlstenden.uservalidation.user;

import java.time.LocalDate;

public class UserAccount
{
	private String name;
	private String password;
	private String email;
	private LocalDate dateOfBirth;

	public UserAccount(String name, String password, String email, LocalDate dateOfBirth) throws Exception
	{
		setName(name);
		setPassword(password);
		setEmail(email);
		setDateOfBirth(dateOfBirth);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name) throws Exception
	{
		if (name == null || name.isEmpty())
		{
			throw new IllegalArgumentException("The name cannot be NULL or empty.");
		}
		this.name = name;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password) throws Exception
	{
		if (password == null || password.isEmpty())
		{
			throw new IllegalArgumentException("The password cannot be NULL or empty.");
		}
		this.password = password;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email) throws Exception
	{
		if (email == null || email.isEmpty())
		{
			throw new IllegalArgumentException("The email cannot be NULL or empty.");
		}
		this.email = email;
	}

	public LocalDate getDateOfBirth()
	{
		return this.dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) throws Exception
	{
		if (dateOfBirth == null)
		{
			throw new IllegalArgumentException("The date of birth cannot be NULL.");
		}
		this.dateOfBirth = dateOfBirth;
	}
}