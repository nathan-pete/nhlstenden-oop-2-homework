package tests;

import com.nhlstenden.uservalidation.user.UserAccount;
import com.nhlstenden.uservalidation.user.UserAccountStorage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAccountStorageTest
{
	@Test
	public void existsByNameReturnsTrueAfterSavingAccount() throws Exception
	{
		UserAccountStorage storage = new UserAccountStorage();
		UserAccount account = new UserAccount("nate", "P@ssword1", "nate@example.com", LocalDate.of(2000, 1, 1));

		storage.save(account);

		assertTrue(storage.existsByName("nate"));
	}

	@Test
	public void existsByNameReturnsFalseForUnknownName() throws Exception
	{
		UserAccountStorage storage = new UserAccountStorage();
		UserAccount account = new UserAccount("nate", "P@ssword1", "nate@example.com", LocalDate.of(2000, 1, 1));

		storage.save(account);

		assertFalse(storage.existsByName("teagan"));
	}

	@Test
	public void existsByNameReturnsTrueForEachOfMultipleSavedAccounts() throws Exception
	{
		UserAccountStorage storage = new UserAccountStorage();
		UserAccount first = new UserAccount("nate", "P@ssword1", "nate@example.com", LocalDate.of(2000, 1, 1));
		UserAccount second = new UserAccount("teagan", "P@ssword2", "teagan@example.com", LocalDate.of(2001, 5, 15));

		storage.save(first);
		storage.save(second);

		assertTrue(storage.existsByName("nate"));
		assertTrue(storage.existsByName("teagan"));
	}
}