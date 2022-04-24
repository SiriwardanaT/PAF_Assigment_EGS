package EGSS.CustomerManagementService.contoller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import EGSS.CustomerManagementService.constants.CustomerConstants;
import EGSS.CustomerManagementService.modal.CustomerModal;
//import EGSS.CustomerManagementService.modal.UserModal;
import EGSS.CustomerManagementService.utils.CustomerDBConnection;



public class LoginController {
	
	public static CustomerModal loginUser(String email,String password) throws ClassNotFoundException, SQLException {
		
		CustomerModal customersLogin = null;
		 String query =CustomerConstants.LOGUSER;
		  Connection connection = CustomerDBConnection.getConnection();
		  PreparedStatement preparedStatement = connection.prepareStatement(query);
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while(rs.next()) {
			  
			  email = rs.getString("email");
			  password = rs.getString("password");
			  String role = rs.getString("role");
			  int id = rs.getInt("id");
			  
			  customersLogin = new CustomerModal(id,role);
		  }
		
		  if(email.equals(email) && password.equals(password)) {
			   
			  return customersLogin;
		  }
		  
		 
		  
		return null;
		
		   
		
		     
	}

}
