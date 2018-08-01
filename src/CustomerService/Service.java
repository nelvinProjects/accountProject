package CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;

public class Service {
	private HashMap<Integer, Account> customers = new HashMap<>();

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
		return gson.toJson(customers);
	}

	public List<Account> findAccount(String fname) {
		List<Account> values = new ArrayList<>();
		for (Map.Entry<Integer, Account> each : customers.entrySet()) {
			if (each.getValue().getFirstName().equalsIgnoreCase(fname)) {
				values.add(each.getValue());
			}
		}
		return values;
	}
	
	public int findAccountNo(String fname) {
		return findAccount(fname).size();	
	}
}
