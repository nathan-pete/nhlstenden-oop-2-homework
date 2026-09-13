package tests;

import com.nhlstenden.uservalidation.user.UserAccount;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserAccountTest
{
	@Test
	public void constructorStoresAllFieldsWhenValid() throws Exception
	{
		LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);
		UserAccount account = new UserAccount("nate", "P@ssword1", "nate@example.com", dateOfBirth);

		assertEquals("nate", account.getName());
		assertEquals("P@ssword1", account.getPassword());
		assertEquals("nate@example.com", account.getEmail());
		assertEquals(dateOfBirth, account.getDateOfBirth());
	}

	@Test
	public void constructorThrowsWhenNameIsNull()
	{
		assertThrows(IllegalArgumentException.class, () ->
			new UserAccount(null, "P@ssword1", "nate@example.com", LocalDate.of(2000, 1, 1)));
	}

	@Test
	public void constructorThrowsWhenNameIsEmpty()
	{
		assertThrows(IllegalArgumentException.class, () ->
			new UserAccount("", "P@ssword1", "nate@example.com", LocalDate.of(2000, 1, 1)));
	}

	@Test
	public void constructorThrowsWhenPasswordIsNull()
	{
		assertThrows(IllegalArgumentException.class, () ->
			new UserAccount("nate", null, "nate@example.com", LocalDate.of(2000, 1, 1)));
	}

	@Test
	public void constructorThrowsWhenPasswordIsEmpty()
	{
		assertThrows(IllegalArgumentException.class, () ->
			new UserAccount("nate", "", "nate@example.com", LocalDate.of(2000, 1, 1)));
	}

	@Test
	public void constructorThrowsWhenEmailIsNull()
	{
		assertThrows(IllegalArgumentException.class, () ->
			new UserAccount("nate", "P@ssword1", null, LocalDate.of(2000, 1, 1)));
	}

	@Test
	public void constructorThrowsWhenEmailIsEmpty()
	{
		assertThrows(IllegalArgumentException.class, () ->
			new UserAccount("nate", "P@ssword1", "", LocalDate.of(2000, 1, 1)));
	}

	@Test
	public void constructorThrowsWhenDateOfBirthIsNull()
	{
		assertThrows(IllegalArgumentException.class, () ->
			new UserAccount("nate", "P@ssword1", "nate@example.com", null));
	}
}