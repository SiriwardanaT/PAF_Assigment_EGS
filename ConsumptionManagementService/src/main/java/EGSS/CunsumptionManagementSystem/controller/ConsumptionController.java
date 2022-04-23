package EGSS.CunsumptionManagementSystem.controller;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EGSS.CunsumptionManagementSystem.dao.ConsumptionService;
import EGSS.CunsumptionManagementSystem.modal.Consumption;


@Path("admin")
public class ConsumptionController {
	
	//GET:http://localhost:8081/ConsumptionManagementService/api/admin
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() throws ClassNotFoundException, SQLException {
        return ConsumptionService.getAllConsumptions();
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
    
    @Path("account/{Acc}")
    @GET
    public String SearchConsumption(@PathParam("Acc") String acc) throws ClassNotFoundException, SQLException {
    	
    	return ConsumptionService.SearchConsumptionByAcc(acc);
    }
    
    @Path("account/{Acc}/date/{Date}")
    @DELETE
    public String DeleteRecord(@PathParam("Acc") String acc, @PathParam("Date") String date) throws ClassNotFoundException, SQLException {
    	   return ConsumptionService.deleteConsumptionRecord(acc, date);
    }
    
    
    
   
}
