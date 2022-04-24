package EGSS.MeterAccountsService.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import EGSS.MeterAccountsService.modal.CustomerModal;

public class InterCommunication {
    
	public static CustomerModal getCustomer(int id) {
		Client client = ClientBuilder.newClient();
		CustomerModal customer = client.
		target("http://localhost:8081/CustomerManagementService/webapi/customer/"+id)
		.request(MediaType.APPLICATION_JSON)
		.get(CustomerModal.class);
		
		return customer;
	}
	
	public static void main(String[] args) {
		

	}

}
