package EGSS.MeterAccountsService.controller;

import java.io.IOException;
import java.util.Base64;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthFilter implements ContainerRequestFilter {
	public static String getJobRole(String token) {
		String[] sArr = token.toString().split("\\.");
		String payload = sArr[1];

		String decodedString = new String(Base64.getUrlDecoder().decode(payload));
		return decodedString.split("/")[0];
	}
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("done");
		try {
			String token = requestContext.getHeaders().getFirst("AUTH");
			if(token != null) {
				if(! getJobRole(token).contains("Admin")) {
					requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity("Unauthorized User Role").build());
				}
			}
			else {
				requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity("Unauthorized User Role").build());
			}
		}
		catch (Exception e) {
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity("Unauthorized User Role").build());
		}
		
		
	}

}
