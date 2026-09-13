package tests;

import com.nhlstenden.uservalidation.user.UserAccount;
import com.nhlstenden.uservalidation.validation.UserValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidatorTest
{
	private UserAccount account() throws Exception
	{
		return new UserAccount("nate", "P@ssword1", "nate@example.com", LocalDate.of(2000, 1, 1));
	}

	@Test
	public void validateReturnsTrueWhenNoRulesConfigured() throws Exception
	{
		UserValidator validator = new UserValidator();

		assertTrue(validator.validate(account()));
	}

	@Test
	public void validateReturnsTrueWhenAllConfiguredRulesPass() throws Exception
	{
		UserValidator validator = new UserValidator();
		validator.addRule(account -> true);
		validator.addRule(account -> true);

		assertTrue(validator.validate(account()));
	}

	@Test
	public void validateReturnsFalseWhenOneConfiguredRuleFails() throws Exception
	{
		UserValidator validator = new UserValidator();
		validator.addRule(account -> true);
		validator.addRule(account -> false);

		assertFalse(validator.validate(account()));
	}

	@Test
	public void addRuleThrowsWhenRuleIsNull()
	{
		UserValidator validator = new UserValidator();

		assertThrows(IllegalArgumentException.class, () -> validator.addRule(null));
	}
}