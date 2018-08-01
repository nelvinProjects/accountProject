package CustomerService;

import java.util.HashMap;

import com.google.gson.Gson;

public class Service {
	private static HashMap<Integer, Account> customers = new HashMap<>();

	public void addCustomer(String firstName, String lastName, int accountNo) {
		int key = customers.size() + 1;
		customers.put(key, new Account(firstName, lastName, accountNo));
	}

	public Account getCustomer(int id) {
		return customers.get(id);
	}

	public HashMap<Integer, Account> returnMap() {
		return customers;
	}

	public void removeAccount(int id) {
		customers.remove(id);
	}

	public String mapToJSON() {
		Gson gson = new Gson();
		String json = gson.toJson(customers);
		return json;
	}
}
