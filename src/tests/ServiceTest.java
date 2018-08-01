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
		service.addCustomer("Tester", "Jon", 524);
		service.addCustomer("Test", "Life", 9874);
		
	}

	@Test
	public void addGetCustomerTest() {
		assertEquals("Tester", service.getCustomer(1).getFirstName(), "Not Match");
		assertEquals("Jon", service.getCustomer(1).getLastName(), "Not Match");
		assertEquals(524, service.getCustomer(1).getAccountNumber(), "Not Match");
	}

	@Test
	public void returnHaspMapTest() {
		assertEquals(3, service.returnMap().size(), "Size not match");
	}

	@Test
	public void removeCustomerTest() {
		assertEquals("Test", service.getCustomer(2).getFirstName());
		service.removeAccount(2);
		assertEquals(null, service.getCustomer(2));
	}
	
	@Test
	public void mapToJSONTest() {
		String expected = "{\"1\":{\"firstName\":\"Tester\",\"lastName\":\"Jon\","
				+ "\"accountNumber\":524},\"2\":{\"firstName\":\"Test\",\"lastName\":"
				+ "\"Life\",\"accountNumber\":9874}}";
		assertEquals(expected, service.mapToJSON(), "JSON Not match");
	}
	
	@Test
	public void findFirstName() {
		service.addCustomer("Test", "Life", 9874);
		assertEquals(2, service.findAccount("Test").size(), "Not equal size");
	}

}
