package EGSS.CustomerManagementService.contoller;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class JwtTokenService {
	public static String GenerateSignature(String data) throws NoSuchAlgorithmException, InvalidKeyException {
		 String secret = "This is a secure keyroereroereroere";
		 String data1 = "this is secire mesg";
		 
		 byte [] hash = secret.getBytes();
		 Mac sha  = Mac.getInstance("HmacSHA256");
		 SecretKeySpec keySpec = new SecretKeySpec(hash,"HmacSHA256");
		 sha.init(keySpec);
		 byte[] signaturebyte =  sha.doFinal(data1.getBytes(StandardCharsets.UTF_8));
		 String signature = Base64.getUrlEncoder().withoutPadding().encodeToString(signaturebyte);
		 return signature;
	}
    public static String CreatePayload(String userrole) {
//		  JsonObject object = Json.createObjectBuilder().add("role", "admin").build();
		  return Base64.getUrlEncoder().withoutPadding().encodeToString(userrole.getBytes());
    }
    
    public static String createheader() {
   	 final String Header = "{'alg':'HS256','type':'JWT'}";
   	 return Base64.getUrlEncoder().withoutPadding().encodeToString(Header.getBytes());
   }
    
    public static String getJWTToken(int id , String role) throws InvalidKeyException, NoSuchAlgorithmException {
    	String payload = role +"/"+ id;
    	return createheader() + "." + CreatePayload(payload) +"."+ GenerateSignature("thththt");
    }

//	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
//		System.out.println(getJWTToken(1,"Admin"));
//		String decodedString = new String(Base64.getUrlDecoder().decode("QWRtaW4vMQ"));
//		System.out.println(decodedString.split("/")[0]);
//	}

}
