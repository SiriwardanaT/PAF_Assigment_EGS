package EGSS.ComplaintManagementSystem.controller;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EGSS.ComplaintManagementSystem.dao.ComplaintService;
import EGSS.ComplaintManagementSystem.modal.Complaint;




@Path("customer")

public class ComplaintController {
	
	    
	@POST
    @Produces(MediaType.APPLICATION_JSON)
        public String AddNewComplaint(Complaint complaint) throws ClassNotFoundException, SQLException {
        	if(complaint != null) {
        		return ComplaintService.AddComplaint(complaint);
        	}
        	else {
        		return "Something went wrong !";
        	}
        	
        }

	@Path("{Id}")
    @GET
    public String SearchConsumption(@PathParam("Id") String acc) throws ClassNotFoundException, SQLException {
    	
    	return ComplaintService.SearchComplaintById(Id);
    }
	
}
