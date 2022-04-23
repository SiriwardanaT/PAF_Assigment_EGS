package EGSS.ComplaintManagementSystem.controller;

import java.io.ObjectInputFilter.Status;
import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import EGSS.ComplaintManagementSystem.dao.ComplaintService;
import EGSS.ComplaintManagementSystem.modal.Complaint;





@Path("complaint")
public class ComplaintController {
	
 	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getComplaint() {
		return "Hello";
	}

//	@POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public String AddNewConsupmtion(Complaint complaint) throws ClassNotFoundException, SQLException {
//    	if(complaint != null) {
//    		return ComplaintService.AddComplaint(complaint);
//    	}
//    	else {
//    		return "Something went wrong !";
//    	}
//    	
//    }
	
 	
    @GET
    public String SearchComplaint(@PathParam("Id") String Id) throws ClassNotFoundException, SQLException {
    	
    	return ComplaintService.SearchComplaint(Id);
    }
    
    
    @DELETE
    public String DeleteRecord(@PathParam("Id") String Id) throws ClassNotFoundException, SQLException {
    	   return ComplaintService.DeleteComplaint(Id);
    }
    
    
    @PUT
    public int updateRecord(Complaint complaint, @PathParam("Id") int Id) {
    	  System.out.println(complaint.getId());
    	  return Id;
    }

}
