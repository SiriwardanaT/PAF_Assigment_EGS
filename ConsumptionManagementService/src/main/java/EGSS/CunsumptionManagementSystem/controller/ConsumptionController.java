package EGSS.CunsumptionManagementSystem.controller;

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
import javax.ws.rs.core.Response.Status;

import EGSS.CunsumptionManagementSystem.dao.ConsumptionService;
import EGSS.CunsumptionManagementSystem.modal.Consumption;

@Path("consumption")
public class ConsumptionController {

	// GET:http://localhost:8081/ConsumptionManagementService/api/consumption
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getIt() {
		try {
			return Response.status(Status.OK).entity(ConsumptionService.getAllConsumptions()).build();
		} catch (ClassNotFoundException e) {
			return Response.status(Status.NOT_FOUND).entity("Not Found Class").build();

		} catch (SQLException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Database ERR").build();
		}
	}

	// POST:http://localhost:8081/ConsumptionManagementService/api/admin
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response AddNewConsupmtion(Consumption consumption) {
		if (consumption != null) {
			try {
				return Response.status(Status.CREATED).entity(ConsumptionService.AddConsmptionRecord(consumption)).build();
			} catch (ClassNotFoundException e) {
				return Response.status(Status.NOT_FOUND).entity("Not Found Class").build();

			} catch (SQLException e) {
				return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Database ERR or Duplication Error ").build();
			}
		} else {
			return Response.status(Status.NO_CONTENT).entity("No content").build();
		}
	}

	@Path("account/{Acc}")
	@GET
	public Response SearchConsumption(@PathParam("Acc") String acc) throws ClassNotFoundException, SQLException {
		return Response.status(Status.OK).entity(ConsumptionService.SearchConsumptionByAcc(acc)).build();

	}

	@Path("account/{Acc}/date/{Date}")
	@DELETE
	public Response DeleteRecord(@PathParam("Acc") String acc, @PathParam("Date") String date)
			throws ClassNotFoundException, SQLException {
		return Response.status(Status.OK).entity(ConsumptionService.deleteConsumptionRecord(acc, date)).build();
	}

	@Path("account/{id}")
	@PUT
	public Response updateRecord(Consumption consumption, @PathParam("id") int id)
			throws ClassNotFoundException, SQLException {
		return Response.status(Status.OK).entity(ConsumptionService.updateConsumption(consumption, id)).build();
	}

}
