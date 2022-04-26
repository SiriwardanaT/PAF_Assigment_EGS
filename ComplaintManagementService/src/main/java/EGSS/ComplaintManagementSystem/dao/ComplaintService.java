package EGSS.ComplaintManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import EGSS.ComplaintManagementSystem.modal.Complaint;
import EGSS.ComplaintManagementSystem.utils.Constant;
import EGSS.ComplaintManagementSystem.utils.dbConnection;

public class ComplaintService {
	
	public Connection con;
	ComplaintService() throws ClassNotFoundException, SQLException{
		Connection con = dbConnection.getdbConnection();

}
	
	
	public static String AddComplaint(Complaint complaint) throws ClassNotFoundException, SQLException {
		String output = "";
		Connection con = dbConnection.getdbConnection();
		if(con == null) {
			return Constant.ConnectionERR;
		}
		else {
			PreparedStatement preparedStatement =  con.prepareStatement("insert into Inquery (id,subject,content,uid,status,createBy,createDate,modifiedBy,modifiedDate)  values(?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1,complaint.getId());
			preparedStatement.setString(2,complaint.getSubject());
			preparedStatement.setString(3,complaint.getContent());
			preparedStatement.setInt(4,complaint.getUid());
			preparedStatement.setInt(5,complaint.getStatus());
			preparedStatement.setInt(6,complaint.getCreateBy());
			preparedStatement.setString(7,complaint.getCreateDate());
			preparedStatement.setInt(8,complaint.getModifiedBy());
			preparedStatement.setString(9,complaint.getModifiedDate());
			
			
			boolean res = preparedStatement.execute();
			
			if(!res) {
				return output  = "Complaint submitted successfully";
			}
			else {
				return output  = "Unable to submit this complaint";
		
		}
		}
}
	public static String SearchComplaint(String Id) throws ClassNotFoundException, SQLException {
		Connection con = dbConnection.getdbConnection();
		PreparedStatement preparedStatement =  con.prepareStatement("select * from Inquery where id like ?");
		preparedStatement.setString(1, Id);
		ResultSet rs =  preparedStatement.executeQuery();
		String output = "<h3>Complaint " + Id + "</h3>";
		output += "<table border='1'>";
		output += "<tr>\r\n"
	        		+ "    <th>ComplaintID</th>\r\n"
	        		+ "    <th>Subject</th>\r\n"
	        		+ "    <th>Content Date</th>\r\n"
	        		+ "    <th>User ID</th>\r\n"
	        		+ "    <th>Status</th>\r\n"
	        		+ "    <th>Created By</th>\r\n"
	        		+ "    <th>Created Date</th>\r\n"
	        		+ "    <th>Modified By</th>\r\n"
	        		+ "    <th>Modified Date</th>\r\n"
	        		+ "  </tr>";
		while(rs.next()) {
			output += "<tr>";
			output += "<th>"+rs.getString(1) +"</th>";
			output += "<th>"+rs.getString(2) +"</th>";
			output += "<th>"+rs.getString(3) +"</th>";
			output += "<th>"+rs.getString(4) +"</th>";
			output += "<th>"+rs.getString(5) +"</th>";
			output += "<th>"+rs.getString(6) +"</th>";
			output += "<th>"+rs.getString(7) +"</th>";
			output += "<th>"+rs.getString(8) +"</th>";
			output += "<th>"+rs.getString(9) +"</th>";
			output += "</tr>";
		}
		output += "</table>";
		return output;
	}
	
	public static String DeleteComplaint(String Id) throws ClassNotFoundException, SQLException {
		Connection con = dbConnection.getdbConnection();
		if(con == null) {
			return Constant.ConnectionERR;
		}
		else {
			PreparedStatement preparedStatement =  con.prepareStatement("delete from Inquery where id = ? ");
			preparedStatement.setString(1, Id);
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

	public static String updateComplaint(Complaint complaint, String Id) throws ClassNotFoundException, SQLException {
		Connection con = dbConnection.getdbConnection();
		String output = "";
		if(con == null) {
			return Constant.ConnectionERR;
		}
		else {
			PreparedStatement preparedStatement =  con.prepareStatement("update consumption set status = ?    ");
			preparedStatement.setInt(1, complaint.getStatus());
	
			int res = preparedStatement.executeUpdate();
	
			if(res == 1) {
				return output = "updated Successfully";
			}
			else {
				return output = "Error:occoured";
	}
		}
	


}}
