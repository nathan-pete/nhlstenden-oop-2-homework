package tests;

import com.nhlstenden.uservalidation.user.UserAccount;
import com.nhlstenden.uservalidation.validation.EmailValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest
{
	private final EmailValidator validator = new EmailValidator();

	private UserAccount accountWithEmail(String email) throws Exception
	{
		return new UserAccount("nate", "P@ssword1", email, LocalDate.of(2000, 1, 1));
	}

	@Test
	public void validateReturnsTrueForStandardEmail() throws Exception
	{
		assertTrue(validator.validate(accountWithEmail("nate@example.com")));
	}

	@Test
	public void validateReturnsTrueForLocalPartWithDotAndPlus() throws Exception
	{
		assertTrue(validator.validate(accountWithEmail("nate.doe+school@example.com")));
	}

	@Test
	public void validateReturnsTrueForDomainContainingDigits() throws Exception
	{
		assertTrue(validator.validate(accountWithEmail("nate@office365.com")));
	}

	@Test
	public void validateReturnsFalseWhenAtSymbolMissing() throws Exception
	{
		assertFalse(validator.validate(accountWithEmail("nate.example.com")));
	}

	@Test
	public void validateReturnsFalseWhenDomainDotMissing() throws Exception
	{
		assertFalse(validator.validate(accountWithEmail("nate@examplecom")));
	}

	@Test
	public void validateReturnsFalseWhenLocalPartMissing() throws Exception
	{
		assertFalse(validator.validate(accountWithEmail("@example.com")));
	}

	@Test
	public void validateReturnsFalseWhenTldIsOneLetter() throws Exception
	{
		assertFalse(validator.validate(accountWithEmail("nate@example.c")));
	}

	@Test
	public void validateReturnsFalseWhenEmailContainsSpace() throws Exception
	{
		assertFalse(validator.validate(accountWithEmail("nate doe@example.com")));
	}
}