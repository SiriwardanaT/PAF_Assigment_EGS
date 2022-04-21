package EGSS.CunsumptionManagementSystem.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EGSS.CunsumptionManagementSystem.modal.Consumption;


@Path("admin")
public class ConsumptionController {
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Consumption Management system";
    }
    
    //post:
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String AddNewConsupmtion(Consumption consumption) {
    	  System.out.println(consumption.getId());
    	  return consumption.getId();
    }
    
   
}
