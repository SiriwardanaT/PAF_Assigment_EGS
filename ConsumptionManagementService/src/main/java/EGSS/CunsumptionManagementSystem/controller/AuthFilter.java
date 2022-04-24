package EGSS.CunsumptionManagementSystem.controller;

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
		try {
			String token = requestContext.getHeaders().getFirst("AUTH");
			if(token != null) {
				String role = getJobRole(requestContext.getHeaders().getFirst("AUTH"));
				
				if(requestContext.getMethod().contains("POST") ||requestContext.getMethod().contains("GET") || requestContext.getMethod().contains("DELETE")) {
						if(!role.contains("Admin") && role.contains("User") && !role.contains("Mr")){
							 requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity("Unauthorized User Role").build());
						}
				}
				else if( requestContext.getMethod().contains("PUT")) {
					   if(!role.contains("Admin")) {
						   requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity("Unauthorized User Role").build());
					   }
				}
			}
			else {
				 requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity("Unauthorized please login").build());
			}
		}
		catch(Exception e) {
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity("Unauthorized please login").build());
		}
		
	}

}
