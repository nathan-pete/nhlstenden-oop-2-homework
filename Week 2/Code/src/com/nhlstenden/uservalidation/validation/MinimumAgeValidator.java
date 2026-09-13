package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.UserAccount;

import java.time.LocalDate;
import java.time.Period;

public class MinimumAgeValidator implements ValidationRule
{
	private final int minimumAge;

	public MinimumAgeValidator(int minimumAge)
	{
		this.minimumAge = minimumAge;
	}

	@Override
	public boolean validate(UserAccount account)
	{
		LocalDate dateOfBirth = account.getDateOfBirth();
		int age = Period.between(dateOfBirth, LocalDate.now()).getYears();

		return age >= this.minimumAge;
	}
}