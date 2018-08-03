package jax;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import customerService.Service;

@Path("/services")
@Produces(MediaType.APPLICATION_JSON)
public class OnlineServices {
	
	private Service service = new Service();
	private Gson gson = new Gson();

	private void addCustomers() {
		service.addCustomer("Tom", "Jones", 1234);
		service.addCustomer("Tim", "Winter", 2345);
		service.addCustomer("Nim", "Sign", 758);
		service.addCustomer("Bob", "Jon", 2345);
		service.addCustomer("Jam", "Town", 456);
		service.addCustomer("Nq", "Rook", 667);
	}

	@GET
	@Path("/customers")
	public String customer() {
		addCustomers();
		return service.mapToJSON();
	}
	
	@GET
	@Path("/customer/{id}")
	public String getCustomer(@PathParam("id") int id) {
		addCustomers();
		return gson.toJson(service.getCustomer(id).toString());
	}
	
	@GET
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/customer")
//	@Path("/customer/{acno}/{fname}/{sname}")
	public String addCustomer(@PathParam("acno") int acno, @PathParam("fname") String fname,
			@PathParam("sname") String sname) {
		addCustomers();
		service.addCustomer(fname, sname, acno);
		return service.mapToJSON();
	}
	
	
}
