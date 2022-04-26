package EGSS.MeterAccountsService.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import EGSS.MeterAccountsService.modal.MeterAccount;
import EGSS.MeterAccountsService.util.DbConnection;

public class AccountService {
	 
	public static String AddNewAccount(MeterAccount meterAccount) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
	    String output = "";
		PreparedStatement preparedStatement = con.prepareStatement("insert into accounts (Macc,install_address,install_date,Uid) values(?,?,?,?)");
		preparedStatement.setString(1, meterAccount.getAccNo());
		preparedStatement.setString(2, meterAccount.getInstall_address());
		preparedStatement.setString(3, meterAccount.getInstall_date());
		preparedStatement.setInt(4, meterAccount.getUserId());
		
		boolean res = preparedStatement.execute();
		if(!res) {
			return output  = "Record Added Successfully for the ACC:" + meterAccount.getAccNo();
		}
		else {
			return output  = "Invalid Record Insertion";
		}
		
	}
	public static String DisplayAllMeterAccounts() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		PreparedStatement preparedStatement = con.prepareStatement("select * from accounts");
		ResultSet rs =  preparedStatement.executeQuery();
		
		String output = "<h3>Meter Accounts Monitoring</h3>";
		output += "<table border='1'>";
		output += "<tr>\r\n"
	        		+ "    <th>Account No</th>\r\n"
	        		+ "    <th>Installation Address</th>\r\n"
	        		+ "    <th>Installation Date</th>\r\n"
	        		+ "    <th>UserName</th>\r\n"
	        		+ "  </tr>";
		while(rs.next()) {
			output += "<tr>";
			output += "<th style='color:green'>"+rs.getString(1) +"</th>";
			output += "<th>"+rs.getString(2) +"</th>";
			output += "<th>"+rs.getString(3) +"</th>";
			output += "<th >"+InterCommunication.getCustomer(Integer.parseInt(rs.getString(4))).getLastName()+"</th>";
			output += "<th >"+InterCommunication.getCustomer(Integer.parseInt(rs.getString(4))).getNic()+"</th>";
			output += "</tr>";
		}
		output += "</table>";
		return output;
		
	}
	
}
