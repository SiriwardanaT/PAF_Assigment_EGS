package EGSS.CustomerManagementService.contoller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import EGSS.CustomerManagementService.modal.CustomerModal;
import EGSS.CustomerManagementService.utils.CustomerDBConnection;
import EGSS.CustomerManagementService.constants.CustomerConstants;

public class CustomerController {
	
	
	
		public static CustomerModal addCustomer(CustomerModal customer) throws SQLException, ClassNotFoundException {
			  String query =CustomerConstants.ADDTOCUSTOMER;
			  Connection connection = CustomerDBConnection.getConnection();
			  PreparedStatement preparedStatement = connection.prepareStatement(query);
			
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
				
				
			
			  boolean successfullyAdded = preparedStatement.execute();
			  if(!successfullyAdded) {
				  return customer;
			  }
			  else {
				  return null;
			  }
		}
		

}
