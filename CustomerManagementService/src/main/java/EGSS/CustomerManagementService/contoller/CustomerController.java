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
	
	  
	
	     //add customer details to system
	
		public static String addCustomer(CustomerModal customer) throws SQLException, ClassNotFoundException {
			  String result = "";
			  String query =CustomerConstants.ADDTOCUSTOMER;
			  Connection connection = CustomerDBConnection.getConnection();
			  PreparedStatement preparedStatement = connection.prepareStatement(query);
			  
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
				  preparedStatement.setString(CustomerConstants.INDEX_ELEVEN,customer.getCreateDate());
				  preparedStatement.setInt(CustomerConstants.INDEX_TWELEVE,customer.getModifiedBy());
				  preparedStatement.setString(CustomerConstants.INDEX_THIRTEEN,customer.getModifiedDate());
				  preparedStatement.setString(CustomerConstants.INDEX_FOURTEEN,customer.getRole());
			
			 
				
				   boolean successfullyAdded = preparedStatement.execute();
			       if(!successfullyAdded) {
				
				        return result = "Successfully added to the system";
				   }
			       else {
				       return result = " Error occur while inserting data";
			  }
		}
		
		
		
	     // Get id for authentication
		
	      public static CustomerModal getAuthData() throws ClassNotFoundException, SQLException {
		 
		        CustomerModal customers = new CustomerModal();
		        String query =CustomerConstants.GETAUTHDETAILS;
		        Connection connection = CustomerDBConnection.getConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		        ResultSet rs = preparedStatement.executeQuery();
		        while(rs.next()) {
			        int id = rs.getInt("id");
			       customers = new CustomerModal(id);
		         } 

		       return customers;
		 
	        }
	      
	      
	      // Generate Password 
	      
	       public static String insertAuthData(CustomerModal customer) throws ClassNotFoundException, SQLException {
		         
	    	     String result = "";
		         String query =CustomerConstants.INSERTAUTHDATA;
		         Connection connection = CustomerDBConnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(query);
		         
		         //generate random password
		         String password = generateRandomPassword(8);
	
			     preparedStatement.setInt(CustomerConstants.INDEX_ONE, customer.getUid());
			     preparedStatement.setString(CustomerConstants.INDEX_TWO, password);
			     preparedStatement.setInt(CustomerConstants.INDEX_TREE, customer.getId());
			     boolean successfullyAdded = preparedStatement.execute();
			      if(!successfullyAdded) {
				
				     return result = "Password generate Successfully";
			       }
			     else {
				    return result =" Error occur while generating password";
			     }
          }
	 

		
	      // View all customers
		
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
		        		+ "    <th>Email</th>\r\n"
		        		+ "    <th>Street</th>\r\n"
		        		+ "    <th>State</th>\r\n"
		        		+ "    <th>Postal Code</th>\r\n"
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
				      output += "</tr>";
		
			  }
			  
			  output += "</table>";
			  return output;
			}
		  
		  
		
		    // Get One Customer Details
		  public static CustomerModal selectCustomer( int id) throws SQLException {
			    CustomerModal customer = null;
		    	String query =CustomerConstants.GETONECUSTOMER;
				Connection connection = null;
				try {
					connection = CustomerDBConnection.getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,id);
		        ResultSet rs = preparedStatement.executeQuery();
		    		    
		         while(rs.next()) {
		    		    	
		    		  String firstName =  rs.getString("firstName");
		  	          String lastName = rs.getString("lastName");
		  			  String nic = rs.getString("nic");
		  			  String email = rs.getString("email");
		  			  String street = rs.getString("street");
		  			  String state = rs.getString("state");
		  			  String postalCode = rs.getString("postalCode");
		  			  int uid = rs.getInt("id");
		  				 
		    		  customer = new CustomerModal(id,firstName,lastName,nic,email,street,state,postalCode);
		    	  }
		    	  
		    	 return customer;
		    	 
		     }
		   
		   
		   
		   // Update Customer 
		  
		   public static  String updateCustomer(CustomerModal customer) throws SQLException {
			     String result ="";
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
				  preparedStatement.setString(8, customer.getRole());
		            
				  preparedStatement.setInt(9, customer.getId());

		             rowUpdated = preparedStatement.executeUpdate() > 0;//return number of rows updated
		             
		             if(rowUpdated) {
		            	 return result= "Update process success!";
		             }else {
		            	 return result =" Update error occur!";
		             }
		         
		     }
		   
		   
		   //Delete customer
		   
		   public static String deleteCustomer(int id) throws SQLException {
			     String result = "";
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
		          
		          if(rowDeleted == true) {
		        	  return result = " Row deleted Successfully";
		          }else {
		        	  return result = " Error occur while deleting customer";
		          }
		              
		         
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
		CustomerModal customer = new CustomerModal();
		customer.setStatus(true);
		customer.setCreateBy(1);
		customer.setCreatedDate("2021-9-10");
		customer.setModifiedDate("2021-6-5");
		customer.setModifiedBy(1);
		
	}
		
		
		

}
