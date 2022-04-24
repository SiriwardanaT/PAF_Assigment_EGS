package EGSS.CustomerManagementService.contoller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import EGSS.CustomerManagementService.constants.CustomerConstants;
import EGSS.CustomerManagementService.modal.CustomerModal;
//import EGSS.CustomerManagementService.modal.UserModal;
import EGSS.CustomerManagementService.utils.CustomerDBConnection;



public class LoginController {
	
	public static String loginUser(String email,String password) throws ClassNotFoundException, SQLException, InvalidKeyException, NoSuchAlgorithmException {
		
		  CustomerModal customersLogin = null;
		  String query =CustomerConstants.LOGUSER;
		  Connection connection = CustomerDBConnection.getConnection();
		  PreparedStatement preparedStatement = connection.prepareStatement(query);
		  preparedStatement.setString(1, email);
		  preparedStatement.setString(2, password);
		  ResultSet rs = preparedStatement.executeQuery();
		  String role = "";
		  int id = 0;
		  while(rs.next()) {
			  
			  email = rs.getString("email");
			  password = rs.getString("password");
			  role = rs.getString("role");
			  id = rs.getInt("id");
			  
			  customersLogin = new CustomerModal(id,role);
		  }
		
		  if(email.equals(email) && password.equals(password)) {
			   
			  return JwtTokenService.getJWTToken(id, role);
		  }
		  
		 
		  
		return null;
		
		   
		
		     
	}

}
