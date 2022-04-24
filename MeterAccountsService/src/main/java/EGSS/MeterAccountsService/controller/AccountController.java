package EGSS.MeterAccountsService.controller;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EGSS.MeterAccountsService.modal.MeterAccount;
import EGSS.MeterAccountsService.service.AccountService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("Account")
public class AccountController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() throws ClassNotFoundException, SQLException {
        return AccountService.DisplayAllMeterAccounts();
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String AddMeter(MeterAccount meterAccount) throws ClassNotFoundException, SQLException {
    	return AccountService.AddNewAccount(meterAccount);
    }
    
}
