package EGSS.CunsumptionManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import EGSS.CunsumptionManagementSystem.modal.Consumption;
import EGSS.CunsumptionManagementSystem.modal.ResponseResult;
import EGSS.CunsumptionManagementSystem.utils.Constant;
import EGSS.CunsumptionManagementSystem.utils.DbConnection;

public class ConsumptionService {
    public Connection con;
	ConsumptionService() throws ClassNotFoundException, SQLException{
		Connection con = DbConnection.getDbConnection();
		//get all consumption records
	}
	
	public static ResponseResult getAllConsumptions() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		PreparedStatement preparedStatement = con.prepareStatement("select * from consumption");
		
		ResultSet rs =  preparedStatement.executeQuery();
		String output = "<h1>Consumption Monitoring</h1>";
		output += "<table border='1'>";
        output += "<tr>\r\n"
        		+ "    <th>ConsumptionID</th>\r\n"
        		+ "    <th>Units</th>\r\n"
        		+ "    <th>Reading Date</th>\r\n"
        		+ "    <th>unitPrice</th>\r\n"
        		+ "    <th>Last Reading</th>\r\n"
        		+ "    <th>Currunt Reading</th>\r\n"
        		+ "    <th>Account No</th>\r\n"
        		+ "    <th>Admin Approvement</th>\r\n"
        		+ "  </tr>";
		while(rs.next()) {
			output += "<tr>";
			output += "<th>"+rs.getString(1) +"</th>";
			output += "<th>"+rs.getString(2) +"</th>";
			output += "<th>"+rs.getString(3) +"</th>";
			output += "<th style='color:red'>"+rs.getString(4) +"</th>";
			output += "<th>"+rs.getString(5) +"</th>";
			output += "<th>"+rs.getString(6) +"</th>";
			output += "<th>"+rs.getString(7) +"</th>";
			if(rs.getString(8).equals("0")) {
				output += "<th style='color:red'>Not Aprroved</th>";
			}
			else {
				output += "<th style='color:green'>Aprroved</th>";
			}
			output += "</tr>";
		}
		output += "</table>";
		ResponseResult responseResult = new ResponseResult(output,200);
		return responseResult;
	}
	
	
	//Add Consumption record
	public static ResponseResult AddConsmptionRecord(Consumption consumption) throws ClassNotFoundException, SQLException {
		String output = "";
		Connection con = DbConnection.getDbConnection();
		if(con == null) {
			ResponseResult responseResult = new ResponseResult(Constant.ConnectionERR,500);
			return responseResult;
		}
		else {
			int lastReading = getLastReading(consumption.getMacc());
			if(lastReading < consumption.getCurruntReading()) {
				PreparedStatement preparedStatement =  con.prepareStatement("insert into consumption (units,date,unitPrice,lsReading,cuReading,Macc,status,createBy,createDate,modifiedBy,modifiedDate)  values(?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setDouble(1,calulateUnits(consumption.getMacc(),consumption.getCurruntReading()));
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
					output  = "Record Added Successfully for the ACC:" + consumption.getMacc();
					ResponseResult responseResult = new ResponseResult(output,201);
					return responseResult;
					 
				}
				else {
					output  = "Invalid Record Insertion";
					ResponseResult responseResult = new ResponseResult(output,500);
					return responseResult;
				}
			}
			else {
				output  = "Currunt reading Cannot be less that last reading ";
				ResponseResult responseResult = new ResponseResult(output,500);
				return responseResult;
			}
		
			
		}
		
	}
	
	public static String SearchConsumptionByAcc(String Acc) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		PreparedStatement preparedStatement =  con.prepareStatement("select * from consumption where Macc like ?");
		preparedStatement.setString(1, Acc);
		ResultSet rs =  preparedStatement.executeQuery();
		String output = "<h3>Consumption Monitoring In " + Acc + "</h3>";
		output += "<table border='1'>";
		output += "<tr>\r\n"
	        		+ "    <th>ConsumptionID</th>\r\n"
	        		+ "    <th>Units</th>\r\n"
	        		+ "    <th>Reading Date</th>\r\n"
	        		+ "    <th>unitPrice</th>\r\n"
	        		+ "    <th>Last Reading</th>\r\n"
	        		+ "    <th>Currunt Reading</th>\r\n"
	        		+ "    <th>Account No</th>\r\n"
	        		+ "    <th>Admin Approvement</th>\r\n"
	        		+ "  </tr>";
		while(rs.next()) {
			output += "<tr>";
			output += "<th>"+rs.getString(1) +"</th>";
			output += "<th>"+rs.getString(2) +"</th>";
			output += "<th>"+rs.getString(3) +"</th>";
			output += "<th style='color:red'>"+rs.getString(4) +"</th>";
			output += "<th style='color:green'>"+rs.getString(5) +"</th>";
			output += "<th>"+rs.getString(6) +"</th>";
			output += "<th>"+rs.getString(7) +"</th>";
			output += "<th>"+rs.getString(8) +"</th>";
			output += "</tr>";
		}
		output += "</table>";
		return output;
	}
	
	public static String deleteConsumptionRecord(String Acc,String date) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		if(con == null) {
			return Constant.ConnectionERR;
		}
		else {
			PreparedStatement preparedStatement =  con.prepareStatement("delete from consumption where Macc = ? and date = ?");
			preparedStatement.setString(1, Acc);
			preparedStatement.setString(2, date);
			int res = preparedStatement.executeUpdate();
			System.out.println(res);
			String output = "";
			if(res == 1) {
				
				return output = "Deleted Successfully";
			}
			else {
				return output = "Not Deleted";
			}
		}
	}
	
	public static String updateConsumption(Consumption consumption, int id) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getDbConnection();
		String output = "";
		if(con == null) {
			return Constant.ConnectionERR;
		}
		else {
			PreparedStatement preparedStatement =  con.prepareStatement("update consumption set status = ? , unitPrice = ?  where id = ? ");
			preparedStatement.setInt(1, consumption.getStatus());
			preparedStatement.setDouble(2, consumption.getUnitPrice());
			preparedStatement.setInt(3,id);
			
			int res = preparedStatement.executeUpdate();
			
			if(res == 1) {
				return output = "updated Successfully";
			}
			else {
				return output = "Error:occoured";
			}
			
		}
	}
	
	
	// helper methods
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
	
	public static double calulateUnits(String Macc,int currentReading) throws ClassNotFoundException, SQLException {
			int last = getLastReading(Macc);
			double units = currentReading -  last;
		    return units;
	}
	
	
	public static void main(String [] args) throws ClassNotFoundException, SQLException {

	}
}
