package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CustomerService.Account;

class AccountTest {

	private Account account;

	@BeforeEach
	public void setup() {
		account = new Account("Tom", "Towns", 12345);
	}

	@Test
	void testSetGetFirstName() {
		assertEquals("Tom", account.getFirstName(), "Not match");
		account.setFirstName("Tim");
		assertEquals("Tim", account.getFirstName(), "Not match");
	}

	@Test
	void testSetGetLastName() {
		assertEquals("Towns", account.getLastName(), "Not match");
		account.setLastName("Wood");
		assertEquals("Wood", account.getLastName(), "Not match");
	}

	@Test
	void testGetSetAccountNumber() {
		assertEquals(12345, account.getAccountNumber(), "Not match");
		account.setAccountNumber(987);
		assertEquals(987, account.getAccountNumber(), "Not match");
	}

	@Test
	void testToString() {
		assertEquals("Account No. 12345 First Name: Tom Last Name: Towns", 
				account.toString(), "Not match");
	}

}
