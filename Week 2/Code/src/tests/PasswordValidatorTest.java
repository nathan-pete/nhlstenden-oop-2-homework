package tests;

import com.nhlstenden.uservalidation.user.UserAccount;
import com.nhlstenden.uservalidation.validation.PasswordValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest
{
	private UserAccount accountWithPassword(String password) throws Exception
	{
		return new UserAccount("nate", password, "nate@example.com", LocalDate.of(2000, 1, 1));
	}

	@Test
	public void validateReturnsFalseWhenSpacesNotAllowedAndPasswordContainsSpace() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(false, false, false, false, false);

		assertFalse(validator.validate(accountWithPassword("pass word")));
	}

	@Test
	public void validateReturnsTrueWhenSpacesAllowedAndPasswordContainsSpace() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, false, false, false, false);

		assertTrue(validator.validate(accountWithPassword("pass word")));
	}

	@Test
	public void validateReturnsFalseWhenSpecialCharRequiredButMissing() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, true, false, false, false);

		assertFalse(validator.validate(accountWithPassword("password")));
	}

	@Test
	public void validateReturnsTrueWhenSpecialCharRequiredAndPresent() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, true, false, false, false);

		assertTrue(validator.validate(accountWithPassword("pass@word")));
	}

	@Test
	public void validateReturnsFalseWhenNumberRequiredButMissing() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, false, true, false, false);

		assertFalse(validator.validate(accountWithPassword("password")));
	}

	@Test
	public void validateReturnsTrueWhenNumberRequiredAndPresent() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, false, true, false, false);

		assertTrue(validator.validate(accountWithPassword("password1")));
	}

	@Test
	public void validateReturnsFalseWhenLowercaseRequiredButMissing() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, false, false, true, false);

		assertFalse(validator.validate(accountWithPassword("PASSWORD")));
	}

	@Test
	public void validateReturnsTrueWhenLowercaseRequiredAndPresent() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, false, false, true, false);

		assertTrue(validator.validate(accountWithPassword("PASSWORd")));
	}

	@Test
	public void validateReturnsFalseWhenUppercaseRequiredButMissing() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, false, false, false, true);

		assertFalse(validator.validate(accountWithPassword("password")));
	}

	@Test
	public void validateReturnsTrueWhenUppercaseRequiredAndPresent() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(true, false, false, false, true);

		assertTrue(validator.validate(accountWithPassword("passworD")));
	}

	@Test
	public void validateReturnsTrueWhenAllRequirementsSatisfied() throws Exception
	{
		PasswordValidator validator = new PasswordValidator(false, true, true, true, true);

		assertTrue(validator.validate(accountWithPassword("Pass@word1")));
	}
}