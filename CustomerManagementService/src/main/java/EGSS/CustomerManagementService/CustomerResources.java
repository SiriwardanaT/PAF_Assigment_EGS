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
	@Path("/login")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
	public Response Login(CustomerModal customer) throws ClassNotFoundException, SQLException, InvalidKeyException, NoSuchAlgorithmException {
		return Response.status(Status.CREATED).entity(LoginController.loginUser(customer.getEmail(), customer.getPassword())).build();
	}
	
    // Post method to add customer to DB
	
    @POST
    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllCustomers() throws ClassNotFoundException, SQLException{
    
//    	
    	if(CustomerController.viewListOfCustomers().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Products founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.viewListOfCustomers()).build();
    	}
    	
	}
    
    
//    //get auth
    @Path("Auth/getAuth")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAuthDetails() throws ClassNotFoundException, SQLException{
    
//    	
    	if(CustomerController.getAuthData().isEmpty()) {
//    		System.out.println()
    		return Response.status(Status.NOT_FOUND).entity("No Products founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.getAuthData()).build();
    	}
    	
	}
    
    //insert auth
    @Path("Auth/insertAuth")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertAuth(CustomerModal customer) throws ClassNotFoundException, SQLException {
   	 System.out.println(customer);
   	 CustomerModal insertCustomerauth = CustomerController.insertAuthData(customer);
   	 if(insertCustomerauth != null) {
   		 return Response.status(Status.CREATED).entity(insertCustomerauth).build();
   	 }
   	 else {
   		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
   	 }
   	 
   }
    
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response DeleteCustomer(@PathParam("id") int id) throws SQLException{
    	try {
			if(CustomerController.deleteCustomer(id)) {
				return Response.status(Status.OK).entity(id).build();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    
    	
	}
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getOneCustomer(@PathParam("id")int id) throws ClassNotFoundException, SQLException{
        
    	
    	  
    	 
    	if(CustomerController.selectCustomer(id) != null) {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.selectCustomer(id)).build();
    	}
    	
    	return Response.status(Status.OK).entity(id).build();
    	
	}
    
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response UpdateProduct(@PathParam("id") int id, CustomerModal customerModal) throws SQLException{
    	customerModal.setId(id);
    	if(CustomerController.updateCustomer(customerModal)) {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.updateCustomer(customerModal)).build();
    	}
    	
    	return Response.status(Status.OK).entity(id).build();
    
    	
	}
    
    
}
