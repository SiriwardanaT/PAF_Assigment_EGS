package EGSS.CustomerManagementService;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;




import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import EGSS.CustomerManagementService.contoller.CustomerController;
import EGSS.CustomerManagementService.contoller.LoginController;
import EGSS.CustomerManagementService.modal.CustomerModal;



@Path("customer")
public class CustomerResources {
	
	// Login API
	@Path("/login")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
	public Response Login(CustomerModal customer) throws ClassNotFoundException, SQLException, InvalidKeyException, NoSuchAlgorithmException {
		String result = LoginController.loginUser(customer.getEmail(), customer.getPassword());
		if(result != null) {
			return Response.status(Status.CREATED).entity(LoginController.loginUser(customer.getEmail(), customer.getPassword())).build();
		}else {
			 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
    
	// Customer Inserting API
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response addCus(CustomerModal customer) throws ClassNotFoundException, SQLException {
   	 System.out.println(customer);
   	 String addCustomerToDB = CustomerController.addCustomer(customer);
   	 if(addCustomerToDB != null) {
   		 return Response.status(Status.CREATED).entity(addCustomerToDB).build();
   	 }
   	 else {
   		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
   	 }
   	 
   }
    
    
    
    // Retriving list of customers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllCustomers() throws ClassNotFoundException, SQLException{
    
  	
    	if(CustomerController.viewListOfCustomers().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Customers founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.viewListOfCustomers()).build();
    	}
    	
	}
    
    
     // Get Id for authorization
    @Path("Auth/getAuth")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAuthDetails() throws ClassNotFoundException, SQLException{
    
 	  if(CustomerController.getAuthData().isEmpty()) {
   		
    		return Response.status(Status.NOT_FOUND).entity("No id founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.getAuthData()).build();
    	}
    	
	}
    
    // Generate Random Password
    @Path("Auth/insertAuth")
    @POST
    @Produces({MediaType.APPLICATION_JSON})

    public Response insertAuth(CustomerModal customer) throws ClassNotFoundException, SQLException {
   	 System.out.println(customer);
   	 String insertCustomerauth = CustomerController.insertAuthData(customer);
   	 if(insertCustomerauth != null) {
   		 return Response.status(Status.CREATED).entity(insertCustomerauth).build();
   	 }
   	 else {
   		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
   	 }
   	 
   }
    
    
    // Delete Customer Record
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response DeleteCustomer(@PathParam("id") int id) throws SQLException{
    	try {
    		
			
//				return Response.status(Status.OK).entity(id).build();
				return Response.status(Status.ACCEPTED).entity(CustomerController.deleteCustomer(id)).build();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    
    	
	}
    
    
    // Get One Customer API
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getOneCustomer(@PathParam("id")int id) throws ClassNotFoundException, SQLException{
        
    	if(CustomerController.selectCustomer(id) != null) {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.selectCustomer(id)).build();
    	}
    	
    	return Response.status(Status.OK).entity(id).build();
    	
	}
    
    
    // Update Customer API
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response UpdateCus(@PathParam("id") int id, CustomerModal customerModal) throws SQLException{
    	customerModal.setId(id);
    	if(CustomerController.updateCustomer(customerModal) != null) {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.updateCustomer(customerModal)).build();
    	}
    	
    	return Response.status(Status.OK).entity(id).build();
    
    	
	}
    
    
}
