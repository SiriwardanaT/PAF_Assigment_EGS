package EGSS.ComplaintManagementSystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbConnection {

	public static Connection getdbConnection() throws SQLException, ClassNotFoundException {
		 Class.forName(Constant.DRIVER);
		 
   	 Connection con = DriverManager.getConnection(Constant.URL,Constant.HOST,Constant.PASSWORD);
   	 return con;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getdbConnection());
	}
	
}