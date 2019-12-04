package tn.esprit.Rest.resources;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;

public class main {

	public static void main(String[] args) {
		 Base64.Encoder encoder = Base64.getEncoder();  

		 String normalString = "user" + ":" + "password";  

		 String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));  

		 System.out.println ("The encoded string is: " + encodedString);  

		 Decoder decoder = Base64.getDecoder();  

		 byte[] unencodedStringArray = decoder.decode(encodedString);  

		 String unencodedString = new String (unencodedStringArray);  

		 System.out.println ("The unencoded string is: " + unencodedString);  

	}

}
