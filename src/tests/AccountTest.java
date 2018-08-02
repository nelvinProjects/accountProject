package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import customerService.Account;

class AccountTest {

	private Account account;
	private String message = "Not Match";

	@BeforeEach
	public void setup() {
		account = new Account("Tom", "Towns", 12345);
	}

	@Test
	void testSetGetFirstName() {
		assertEquals("Tom", account.getFirstName(), message);
		account.setFirstName("Tim");
		assertEquals("Tim", account.getFirstName(), message);
	}

	@Test
	void testSetGetLastName() {
		assertEquals("Towns", account.getLastName(), message);
		account.setLastName("Wood");
		assertEquals("Wood", account.getLastName(), message);
	}

	@Test
	void testGetSetAccountNumber() {
		assertEquals(12345, account.getAccountNumber(), message);
		account.setAccountNumber(987);
		assertEquals(987, account.getAccountNumber(), message);
	}

	@Test
	void testToString() {
		assertEquals("Account No. 12345 First Name: Tom Last Name: Towns", account.toString(), message);
	}

}
