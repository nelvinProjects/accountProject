package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CustomerService.Service;

public class ServiceTest {
	private Service service;

	@BeforeEach
	public void setup() {
		service = new Service();
	}

	@Test
	public void addGetCustomerTest() {
		service.addCustomer("Tester", "Jon", 524);
		service.addCustomer("Test", "Life", 9874);
		assertEquals("Tester", service.getCustomer(1).getFirstName(), "Not Match");
		assertEquals("Life", service.getCustomer(2).getLastName(), "Not Match");
		assertEquals(524, service.getCustomer(1).getAccountNumber(), "Not Match");

	}

	@Test
	public void returnHaspMapTest() {
		assertEquals(0, service.returnMap().size(), "Size not match");
		service.addCustomer("Tester", "Jon", 524);
		assertEquals(1, service.returnMap().size(), "Size not match");
		service.addCustomer("Test", "Life", 9874);
		assertEquals(2, service.returnMap().size(), "Size not match");
	}

	@Test
	public void removeCustomerTest() {
		service.addCustomer("Tester", "Jon", 524);
		service.addCustomer("Test", "Life", 9874);
		assertEquals("Test", service.getCustomer(2).getFirstName());
		service.removeAccount(2);
		assertEquals(null, service.getCustomer(2));
	}

}
