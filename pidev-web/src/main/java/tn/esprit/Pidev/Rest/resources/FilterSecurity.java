package tn.esprit.Rest.resources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class FilterSecurity implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String SECURED_URL_PREFIX = "/Services";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (authHeader != null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);

				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				if (authToken.contains("dXNlcjpwYXNzd29yZA==")) {
					Decoder decoder = Base64.getDecoder();

					byte[] unencodedStringArray = decoder.decode("dXNlcjpwYXNzd29yZA==");

					String decodedString = new String(unencodedStringArray);


					StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");

					String username = tokenizer.nextToken();
					String password = tokenizer.nextToken();
					if ("user".equals(username) && "password".equals(password)) {
						return;
					}
				}
			}
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User cannot access the resource").build();
			requestContext.abortWith(unauthorizedStatus);
		}

	}

}