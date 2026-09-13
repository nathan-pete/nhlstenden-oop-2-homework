package tests;

import com.nhlstenden.uservalidation.user.UserAccount;
import com.nhlstenden.uservalidation.user.UserAccountStorage;
import com.nhlstenden.uservalidation.validation.UsernameValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsernameValidatorTest
{
	private UserAccount accountWithName(String name) throws Exception
	{
		return new UserAccount(name, "P@ssword1", "nate@example.com", LocalDate.of(2000, 1, 1));
	}

	@Test
	public void validateReturnsTrueWhenNameNotYetInStorage() throws Exception
	{
		UserAccountStorage storage = new UserAccountStorage();
		UsernameValidator validator = new UsernameValidator(storage);

		assertTrue(validator.validate(accountWithName("nate")));
	}

	@Test
	public void validateReturnsFalseWhenNameAlreadyInStorage() throws Exception
	{
		UserAccountStorage storage = new UserAccountStorage();
		storage.save(accountWithName("nate"));
		UsernameValidator validator = new UsernameValidator(storage);

		assertFalse(validator.validate(accountWithName("nate")));
	}

	@Test
	public void validateReturnsTrueWhenStorageHasOtherNamesOnly() throws Exception
	{
		UserAccountStorage storage = new UserAccountStorage();
		storage.save(accountWithName("teagan"));
		UsernameValidator validator = new UsernameValidator(storage);

		assertTrue(validator.validate(accountWithName("nate")));
	}
}