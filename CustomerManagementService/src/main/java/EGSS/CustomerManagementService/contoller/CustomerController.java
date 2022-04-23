package EGSS.CustomerManagementService.contoller;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EGSS.CustomerManagementService.modal.CustomerModal;
import EGSS.CustomerManagementService.modal.UserModal;
import EGSS.CustomerManagementService.utils.CustomerDBConnection;
import EGSS.CustomerManagementService.constants.CustomerConstants;

public class CustomerController {
	
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
				  preparedStatement.setString(CustomerConstants.INDEX_TREE,customer.getNIC());
				  preparedStatement.setString(CustomerConstants.INDEX_FOUR,customer.getEmail());
				  preparedStatement.setString(CustomerConstants.INDEX_FIVE,customer.getStreet());
				  preparedStatement.setString(CustomerConstants.INDEX_SIX,customer.getState());
				  preparedStatement.setString(CustomerConstants.INDEX_SEVEN,customer.getPostalCode());
				  preparedStatement.setBoolean(CustomerConstants.INDEX_EIGHT,customer.isStatus());
				  preparedStatement.setInt(CustomerConstants.INDEX_NINE,customer.getCreatedBy());
				  preparedStatement.setDate(CustomerConstants.INDEX_TEN,customer.getCreatedDate());
				  preparedStatement.setInt(CustomerConstants.INDEX_ELEVEN,customer.getModifiedBy());
				  preparedStatement.setDate(CustomerConstants.INDEX_TWELEVE,customer.getModifiedDate());
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
			  String email = rs.getString("email");
			  String role = rs.getString("role");
			  
			  customers = new CustomerModal();
		  }
		  
		return customers;
		 
	 }
	 
	 public static CustomerModal insertAuthData(CustomerModal customer) throws ClassNotFoundException, SQLException {
		 
		 String query =CustomerConstants.INSERTAUTHDATA;
		  Connection connection = CustomerDBConnection.getConnection();
		  PreparedStatement preparedStatement = connection.prepareStatement(query);
		  String password = generateRandomPassword(8);
		  boolean result = isExistingCustomerId(customer.getId());
		  if(result == true) {
			  
			  
		  }else {
			  preparedStatement.setInt(CustomerConstants.INDEX_ONE, customer.getId());
			  preparedStatement.setString(CustomerConstants.INDEX_TWO, customer.getRole());
			  preparedStatement.setString(CustomerConstants.INDEX_TREE, password);
			  boolean successfullyAdded = preparedStatement.execute();
			  if(!successfullyAdded) {
				  return customer;
			  }
			  else {
				  return null;
			  }
		  }
		  
		return null;
		
	 }
		
	// view customer
		
		public static List<CustomerModal> viewListOfCustomers() throws SQLException{
			List <CustomerModal> customers = new ArrayList<> ();
			
			 String query =CustomerConstants.VIEWCUSTOMER;
			  Connection connection = null;
			try {
				connection = CustomerDBConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  PreparedStatement preparedStatement = connection.prepareStatement(query);
			  ResultSet rs = preparedStatement.executeQuery();
			  
			  while(rs.next()) {
			
				  String firstName = rs.getString("firstName");
				  String lastName = rs.getString("lastName");
				  String NIC = rs.getString("NIC");
				  String email = rs.getString("email");
				  String Street = rs.getString("Street");
				  String state = rs.getString("state");
				  String postalCode = rs.getString("postalCode");
				  Boolean status = rs.getBoolean("status");
				 
				  customers.add(new CustomerModal(firstName,lastName,NIC,email,Street,state,postalCode,status));
					
			  }
			  
			
			return null;
			
			
		}
		
		// get one customer
		   public CustomerModal selectCustomer( int id) {
			   CustomerModal customer = null;
		    	  
		    	  
		    		     // calling the DBconnection 
			   String query =CustomerConstants.GETONECUSTOMER;
				  Connection connection = null;
				try {
					connection = CustomerDBConnection.getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace()
				}
				  PreparedStatement preparedStatement = connection.prepareStatement(query);
		    		      ResultSet rs = preparedStatement.executeQuery();
		    		    
		    		    while(rs.next()) {
		    		    	
		    		    	String firstName = rs.getString("firstname");
		    		    	String lastName = rs.getString("lastname");
		    		    	String NIC = rs.getString("position");
		    		    	String email = rs.getString("salary");
		    		    	String Street = rs.getString("Street");
		    		    	String state = rs.getString("state");
		    		    	String postalCode = rs.getString("postalCode");
		    		    	Boolean status = rs.getBoolean("status");
		    		    	
		    		    	
		    		    	
		    		    	
		    		    	
		    		    	customer = new CustomerModal(id,firstName, lastName,NIC,email,Street,state,postalCode,status);
		    		    }
		    	  
		    			  
				return customer;
		    	 
		    	     
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
				  preparedStatement.setString(3, customer.getNIC());
				  preparedStatement.setString(4,customer.getEmail());
				  preparedStatement.setString(5,customer.getStreet());
				  preparedStatement.setString(6,customer.getState());
				  preparedStatement.setString(7,customer.getPostalCode());
				  preparedStatement.setBoolean(8,customer.isStatus());
		            
				  preparedStatement.setInt(5, customer.getId());

		             rowUpdated = preparedStatement.executeUpdate() > 0;//return number of rows updated
		        
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
