package EGSS.CunsumptionManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import EGSS.CunsumptionManagementSystem.modal.Consumption;
import EGSS.CunsumptionManagementSystem.utils.Constant;
import EGSS.CunsumptionManagementSystem.utils.DbConnection;

public class ConsumptionService {
    public Connection con;
	ConsumptionService() throws ClassNotFoundException, SQLException{
		Connection con = DbConnection.getDbConnection();
		//get all consumption records
	}
	
	public static String getAllConsumptions() {
		return null;
	}
	
	
	//Add Consumption record
	public static String AddConsmptionRecord(Consumption consumption) throws ClassNotFoundException, SQLException {
		String output = "";
		Connection con = DbConnection.getDbConnection();
		if(con == null) {
			return Constant.ConnectionERR;
		}
		else {
			int lastReading = getLastReading(consumption.getMacc());
			if(lastReading < consumption.getCurruntReading()) {
				PreparedStatement preparedStatement =  con.prepareStatement("insert into consumption(units,date,unitPrice,lsReading,cuReading,Macc,status,createBy,createDate,modifiedBy,modifiedDate)  values(?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setDouble(1,consumption.getUnits());
				preparedStatement.setString(2, consumption.getDate());
				preparedStatement.setDouble(3, consumption.getUnitPrice());
				preparedStatement.setInt(4,getLastReading(consumption.getMacc()));
				preparedStatement.setInt(5, consumption.getCurruntReading());
				preparedStatement.setString(6,consumption.getMacc());
				preparedStatement.setInt(7, consumption.getStatus());
				preparedStatement.setInt(8, consumption.getCreateBy());
				preparedStatement.setString(9, consumption.getCreateDate());
				preparedStatement.setInt(10, consumption.getModifiedBy());
				preparedStatement.setString(11,consumption.getModifiedDate());
				
				boolean res = preparedStatement.execute();
				
				if(!res) {
					return output  = "Record Added Successfully for the ACC:" + consumption.getMacc();
				}
				else {
					return output  = "Invalid Record Insertion";
				}
			}
			else {
				return output  = "Currunt reading Cannot be less that last reading ";
			}
		
			
		}
		
	}
	
	public static int getLastReading(String Macc) throws ClassNotFoundException, SQLException{
		Connection con = DbConnection.getDbConnection();
		if(con == null) {
			return 0;
		}
		else {
			PreparedStatement preparedStatement =  con.prepareStatement("select cuReading from consumption where Macc = ? order by id desc limit 1");
			preparedStatement.setString(1, Macc);
			int lsReading = 0;
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				lsReading =  rs.getInt(1);
				
			}
		    return lsReading;
		}
		
	}
	
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		Consumption consumption = new Consumption();
		consumption.setUnits(800.99);
		consumption.setUnitPrice(600.00);
		consumption.setStatus(1);
		consumption.setModifiedDate("2021-6-5");
		consumption.setModifiedBy(1);
		consumption.setMacc("AC4000");
		consumption.setDate("2021-6-5");
		consumption.setCurruntReading(234);
		consumption.setCreateDate("2021-5-5");
		consumption.setCreateBy(1);
		String out = AddConsmptionRecord(consumption);
//		System.out.println(getLastReading("AC3000"));
	}
}