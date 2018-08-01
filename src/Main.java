import CustomerService.Service;

public class Main {

	public static void main(String[] args) {
		App app = new App();
		System.out.println(app.printHello());

		Service service = new Service();
		service.addCustomer("Bib", "Wood", 123324);
		service.addCustomer("Nim", "Gray", 56465);
		service.addCustomer("Tim", "Sill", 12544);
		service.addCustomer("Jim", "Woon", 15623);
		service.addCustomer("Nim", "Noon", 13544);
		service.addCustomer("Sim", "Kin", 124354);

		System.out.println(service.getCustomer(1).toString());
		System.out.println(service.getCustomer(3).toString());
		System.out.println(service.getCustomer(5).toString());

		System.out.println(service.mapToJSON());
	}

}
