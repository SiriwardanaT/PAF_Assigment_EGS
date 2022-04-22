package EGSS.CunsumptionManagementSystem.controller;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EGSS.CunsumptionManagementSystem.dao.ConsumptionService;
import EGSS.CunsumptionManagementSystem.modal.Consumption;


@Path("admin")
public class ConsumptionController {
	
	//GET:http://localhost:8081/ConsumptionManagementService/api/admin
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Consumption Management system";
    }
    
    
    //POST:http://localhost:8081/ConsumptionManagementService/api/admin
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String AddNewConsupmtion(Consumption consumption) throws ClassNotFoundException, SQLException {
    	if(consumption != null) {
    		return ConsumptionService.AddConsmptionRecord(consumption);
    	}
    	else {
    		return "Something went wrong !";
    	}
    	
    }
    
    
    
   
}
