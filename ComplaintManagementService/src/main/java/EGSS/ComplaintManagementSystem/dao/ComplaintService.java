package EGSS.ComplaintManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import EGSS.ComplaintManagementSystem.utils.dbConnection;
import EGSS.ComplaintManagementSystem.modal.Complaint;
import EGSS.ComplaintManagementSystem.utils.Constant;



public class ComplaintService {
	
	public Connection con;
	ComplaintService() throws ClassNotFoundException, SQLException{
		Connection con = dbConnection.getdbConnection();
	}

	
	public static String AddComplaint(Complaint complaint)throws ClassNotFoundException, SQLException {
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
			}}
		}		
			
	public static String SearchComplaintById(String Id)throws ClassNotFoundException, SQLException{
		Connection con = dbConnection.getdbConnection();
		PreparedStatement preparedStatement =  con.prepareStatement("select * from Inquery where Id like ?");
		preparedStatement.setString(1, Id);
		ResultSet rs =  preparedStatement.executeQuery();
		String output = "<h3>Complaint" + Id + "</h3>";
		output += "<table border='1'>";
		output += "<tr>\r\n"
	        		+ "    <th>ComplaintID</th>\r\n"
	        		+ "    <th>Subject</th>\r\n"
	        		+ "    <th>Conetent</th>\r\n"
	        		+ "    <th>Status</th>\r\n"
	        		+ "    <th>Created By</th>\r\n"
	        		+ "    <th>Created Date</th>\r\n"
	        		+ "  </tr>";
		while(rs.next()) {
			output += "<tr>";
			output += "<th>"+rs.getString(1) +"</th>";
			output += "<th>"+rs.getString(2) +"</th>";
			output += "<th>"+rs.getString(3) +"</th>";
			output += "<th>"+rs.getString(4) +"</th>";
			output += "<th>"+rs.getString(5) +"</th>";
			output += "<th>"+rs.getString(6) +"</th>";
			output += "</tr>";
	}
	
		output += "</table>";
		return output;
	}
		
	
}