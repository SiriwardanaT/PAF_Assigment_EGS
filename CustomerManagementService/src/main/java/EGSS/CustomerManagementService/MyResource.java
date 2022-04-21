package EGSS.CustomerManagementService;

import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import EGSS.CustomerManagementService.contoller.CustomerController;
import EGSS.CustomerManagementService.modal.CustomerModal;


@Path("customer")
public class MyResource {

 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCus(CustomerModal customer) throws ClassNotFoundException, SQLException {
   	 System.out.println(customer);
   	 CustomerModal addCustomerToDB = CustomerController.addCustomer(customer);
   	 if(addCustomerToDB != null) {
   		 return Response.status(Status.CREATED).entity(addCustomerToDB).build();
   	 }
   	 else {
   		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
   	 }
   	 
   }
}
