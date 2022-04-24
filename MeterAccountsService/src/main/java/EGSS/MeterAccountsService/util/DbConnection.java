package EGSS.MeterAccountsService.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		Class.forName(Constant.DRIVER);
		// add local user name password to connect database
		Connection con = DriverManager.getConnection(Constant.URL, Constant.HOST, Constant.PASSWORD);
		return con;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getDbConnection());
	}

}
