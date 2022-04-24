package EGSS.CustomerManagementService.contoller;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import EGSS.CustomerManagementService.modal.CustomerModal;
import EGSS.CustomerManagementService.utils.CustomerDBConnection;
import EGSS.CustomerManagementService.constants.CustomerConstants;

public class CustomerController {
	
	  private final static String baseURL = "https://api.mailgun.net/v2/";
	  private static String mailgunAPIKey;
	
	//add customer
	
		public static CustomerModal addCustomer(CustomerModal customer) throws SQLException, ClassNotFoundException {
			  String query =CustomerConstants.ADDTOCUSTOMER;
			  Connection connection = CustomerDBConnection.getConnection();
			  PreparedStatement preparedStatement = connection.prepareStatement(query);
			  
			 
			  
			  boolean result = isExistingEmail(customer.getEmail());
			  if(result == true) {
				  
			  }else {
				  preparedStatement.setInt(CustomerConstants.INDEX_ONE, customer.getId());
				  preparedStatement.setString(CustomerConstants.INDEX_TWO, customer.getFirstName());
				  preparedStatement.setString(CustomerConstants.INDEX_TREE, customer.getLastName());
				  preparedStatement.setString(CustomerConstants.INDEX_FOUR,customer.getNic());
				  preparedStatement.setString(CustomerConstants.INDEX_FIVE,customer.getEmail());
				  preparedStatement.setString(CustomerConstants.INDEX_SIX,customer.getStreet());
				  preparedStatement.setString(CustomerConstants.INDEX_SEVEN,customer.getState());
				  preparedStatement.setString(CustomerConstants.INDEX_EIGHT,customer.getPostalCode());
				  preparedStatement.setBoolean(CustomerConstants.INDEX_NINE,customer.isStatus());
				  preparedStatement.setInt(CustomerConstants.INDEX_TEN,customer.getCreateBy());
				  preparedStatement.setDate(CustomerConstants.INDEX_ELEVEN,customer.getCreateDate());
				  preparedStatement.setInt(CustomerConstants.INDEX_TWELEVE,customer.getModifiedBy());
				  preparedStatement.setDate(CustomerConstants.INDEX_THIRTEEN,customer.getModifiedDate());
				  preparedStatement.setString(CustomerConstants.INDEX_FOURTEEN,customer.getRole());
			  }
			 
			 
				
				
			
			  boolean successfullyAdded = preparedStatement.execute();
			  if(!successfullyAdded) {
				
				  return customer;
				 
				  
			  }
			  else {
				  return null;
			  }
		}
		
		
		
	//add auth
	 public static CustomerModal getAuthData() throws ClassNotFoundException, SQLException {
		 
		 CustomerModal customers = new CustomerModal();
		 
		 String query =CustomerConstants.GETAUTHDETAILS;
		  Connection connection = CustomerDBConnection.getConnection();
		  PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		  ResultSet rs = preparedStatement.executeQuery();
		  while(rs.next()) {
			  int id = rs.getInt("id");
			 
			  
//			  CustomerModal customers = new CustomerModal();
		  }
		  insertAuthData(customers);
		  
		return customers;
		 
	 }
	 
	 public static CustomerModal insertAuthData(CustomerModal customer) throws ClassNotFoundException, SQLException {
		 
		 String query =CustomerConstants.INSERTAUTHDATA;
		  Connection connection = CustomerDBConnection.getConnection();
		  PreparedStatement preparedStatement = connection.prepareStatement(query);
		  String password = generateRandomPassword(8);
//		  boolean result = isExistingCustomerId(customer.getId());
//		  if(result == true) {
//			  
			  
//		  }else {
			  preparedStatement.setInt(CustomerConstants.INDEX_ONE, customer.getUid());
			  preparedStatement.setString(CustomerConstants.INDEX_TWO, password);
			  preparedStatement.setInt(CustomerConstants.INDEX_TREE, customer.getId());
			  boolean successfullyAdded = preparedStatement.execute();
			  if(!successfullyAdded) {
				

				
//				  createPrivateClient();
				
				  return customer;
			  }
			  else {
				  return null;
			  }
//		  }
		
	 }
	 
//	 public static <T> WebTarget createPrivateClient() {
//	      final Client client = ClientBuilder.newClient();
//	      client.register(HttpAuthenticationFeature.basic("api",mailgunAPIKey));
//	      return client.target(baseURL);
//	  }
//
//	  protected void fireMailGun(final MultivaluedMap<String, String> postData) {
//	      this.createPrivateClient().path("YOUR_DOMAIN/messages")
//	                                .request()
//	                                .post(Entity.form(postData));
//	  }
		
	// view customer
		
		public static String viewListOfCustomers() throws SQLException{
			List <CustomerModal> customers = new ArrayList<> ();
			
			 String query =CustomerConstants.VIEWCUSTOMER;
			  Connection connection = null;
			try {
				connection = CustomerDBConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  PreparedStatement preparedStatement = connection.prepareStatement(query);
			  System.out.println(connection.prepareStatement(query));
			  ResultSet rs = preparedStatement.executeQuery();
			  String output = "<h1>Customer Details</h1>";
			  output += "<table border='1'>";
		        output += "<tr>\r\n"
		        		+ "    <th>First Name</th>\r\n"
		        		+ "    <th>Last Name</th>\r\n"
		        		+ "    <th>NIC</th>\r\n"
		        		+ "    <th>Street</th>\r\n"
		        		+ "    <th>State</th>\r\n"
		        		+ "    <th>Postal Code</th>\r\n"
		        		+ "    <th>Status</th>\r\n"
		        		+ "  </tr>";
			  
			  while(rs.next()) {
				  output += "<tr>";
				  output += "<td>"+ rs.getString(1)+"</td>";
				  output += "<td>"+ rs.getString(2)+"</td>";
				  output += "<td>"+ rs.getString(3)+"</td>";
				  output += "<td>"+ rs.getString(4)+"</td>";
				  output += "<td>"+ rs.getString(5)+"</td>";
				  output += "<td>"+ rs.getString(6)+"</td>";
				  output += "<td>"+ rs.getString(7)+"</td>";
				  output += "<td>"+ rs.getBoolean(8)+"</td>";
				  output += "</tr>";
				 
//				  customers.add(new CustomerModal(firstName,lastName,nic,email,street,state,postalCode,status));
//				  System.out.println( customers.add(new CustomerModal(firstName,lastName,nic,email,street,state,postalCode,status)))
			  }
			  
			  output += "</table>";
			return output;
			
			
		}
		
		// get one customer
		   public String selectCustomer( int id) throws SQLException {
			   CustomerModal customer = null;
		    	  
		    	  
		    		     // calling the DBconnection 
			   String query =CustomerConstants.GETONECUSTOMER;
				  Connection connection = null;
				try {
					connection = CustomerDBConnection.getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				  PreparedStatement preparedStatement = connection.prepareStatement(query);
		    		      ResultSet rs = preparedStatement.executeQuery();
		    		      String output = "<h1>Customer Details</h1>";
		    			  output += "<table border='1'>";
		    		        output += "<tr>\r\n"
		    		        		+ "    <th>First Name</th>\r\n"
		    		        		+ "    <th>Last Name</th>\r\n"
		    		        		+ "    <th>NIC</th>\r\n"
		    		        		+ "    <th>Street</th>\r\n"
		    		        		+ "    <th>State</th>\r\n"
		    		        		+ "    <th>Postal Code</th>\r\n"
		    		        		+ "    <th>Status</th>\r\n"
		    		        		+ "  </tr>";
		    		    while(rs.next()) {
		    		    	
		    		    	output += "<tr>";
		  				  output += "<td>"+ rs.getString(1)+"</td>";
		  				  output += "<td>"+ rs.getString(2)+"</td>";
		  				  output += "<td>"+ rs.getString(3)+"</td>";
		  				  output += "<td>"+ rs.getString(4)+"</td>";
		  				  output += "<td>"+ rs.getString(5)+"</td>";
		  				  output += "<td>"+ rs.getString(6)+"</td>";
		  				  output += "<td>"+ rs.getString(7)+"</td>";
		  				  output += "<td>"+ rs.getBoolean(8)+"</td>";
		  				  output += "</tr>";
		    		    	
		    		    	
		    		    	
//		    		    	customer = new CustomerModal(id,firstName, lastName,NIC,email,Street,state,postalCode,status);
		    		    }
		    	  
		    		    output += "</table>";	  
				return output;
		    	 
		    	     
		     }
		   
		   
		   
		   // update customer
		   public static  boolean updateCustomer(CustomerModal customer) throws SQLException {
		         boolean rowUpdated = false;
		         
		        	 
		         
		         String query =CustomerConstants.UPDATECUSTOMER;
				  Connection connection = null;
				try {
					connection = CustomerDBConnection.getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				  PreparedStatement preparedStatement = connection.prepareStatement(query);
		        	
				  preparedStatement.setString(1, customer.getFirstName());
				  preparedStatement.setString(2,customer.getLastName());
				  preparedStatement.setString(3, customer.getNic());
				  preparedStatement.setString(4,customer.getEmail());
				  preparedStatement.setString(5,customer.getStreet());
				  preparedStatement.setString(6,customer.getState());
				  preparedStatement.setString(7,customer.getPostalCode());
				  preparedStatement.setBoolean(8,customer.isStatus());
		            
				  preparedStatement.setInt(9, customer.getId());

		             rowUpdated = preparedStatement.executeUpdate() > 0;//return number of rows updated
		             System.out.println(rowUpdated);
		         return rowUpdated;
		     }
		   
		   
		   //Delete customer
		   
		   public static boolean deleteCustomer(int id) throws SQLException {
		         boolean rowDeleted = false;
		        
		        	 
		         String query =CustomerConstants.DELETECUSTOMER;
				  Connection connection = null;
				try {
					connection = CustomerDBConnection.getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				  PreparedStatement preparedStatement = connection.prepareStatement(query);
		        	
				  preparedStatement.setInt(1,id);
					//use to update the query
		             rowDeleted = preparedStatement.executeUpdate() > 0;//return number of rows deleted
		              System.out.println(rowDeleted);
		         return rowDeleted;
		     }
		   
		   private static boolean isExistingEmail(String email) {
			   List <CustomerModal> customers = new ArrayList<> ();
				
		        // Iterates all the customer
		        for (CustomerModal customer: customers) {
		            // Checks if the customer email is equal to the email parameter
		            if (customer.email.equals(email)) {
		                return true;
		            }
		        }
		        return false;
		    }
		   
		   private static boolean isExistingCustomerId(int id) {
			   List <CustomerModal> customers = new ArrayList<> ();
				
		        // Iterates all the customer
		        for (CustomerModal customer: customers) {
		            // Checks if the customer email is equal to the email parameter
		            if (customer.id == id) {
		                return true;
		            }
		        }
		        return false;
		    }
		   
		   public static String generateRandomPassword(int len)
		    {
		        // ASCII range – alphanumeric (0-9, a-z, A-Z)
		        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 
		        SecureRandom random = new SecureRandom();
		        StringBuilder sb = new StringBuilder();
		 
		        // each iteration of the loop randomly chooses a character from the given
		        // ASCII range and appends it to the `StringBuilder` instance
		 
		        for (int i = 0; i < len; i++)
		        {
		            int randomIndex = random.nextInt(chars.length());
		            sb.append(chars.charAt(randomIndex));
		        }
		 
		        return sb.toString();
		    }
		   
		   
		   
		 

	private static void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}
		
		
		

}
