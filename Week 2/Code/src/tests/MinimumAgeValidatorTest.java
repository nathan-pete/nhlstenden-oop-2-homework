package tests;

import com.nhlstenden.uservalidation.user.UserAccount;
import com.nhlstenden.uservalidation.validation.MinimumAgeValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinimumAgeValidatorTest
{
	private UserAccount accountWithDateOfBirth(LocalDate dateOfBirth) throws Exception
	{
		return new UserAccount("nate", "P@ssword1", "nate@example.com", dateOfBirth);
	}

	@Test
	public void validateReturnsTrueWhenExactlyMinimumAge() throws Exception
	{
		MinimumAgeValidator validator = new MinimumAgeValidator(18);
		LocalDate dateOfBirth = LocalDate.now().minusYears(18);

		assertTrue(validator.validate(accountWithDateOfBirth(dateOfBirth)));
	}

	@Test
	public void validateReturnsTrueWhenOlderThanMinimumAge() throws Exception
	{
		MinimumAgeValidator validator = new MinimumAgeValidator(18);
		LocalDate dateOfBirth = LocalDate.now().minusYears(25);

		assertTrue(validator.validate(accountWithDateOfBirth(dateOfBirth)));
	}

	@Test
	public void validateReturnsFalseWhenYoungerThanMinimumAge() throws Exception
	{
		MinimumAgeValidator validator = new MinimumAgeValidator(18);
		LocalDate dateOfBirth = LocalDate.now().minusYears(17);

		assertFalse(validator.validate(accountWithDateOfBirth(dateOfBirth)));
	}

	@Test
	public void validateReturnsFalseWhenOneDayUnderMinimumAge() throws Exception
	{
		MinimumAgeValidator validator = new MinimumAgeValidator(18);
		LocalDate dateOfBirth = LocalDate.now().minusYears(18).plusDays(1);

		assertFalse(validator.validate(accountWithDateOfBirth(dateOfBirth)));
	}
}