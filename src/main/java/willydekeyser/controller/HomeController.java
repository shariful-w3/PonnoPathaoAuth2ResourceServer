package willydekeyser.controller;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		
		 // Get the current authentication object from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the authentication is a JWT token
        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            
            // Get the JWT token and its claims
            String tokenValue = jwt.getTokenValue();
            //String username = jwt.getClaim("sub"); // Or any other claim
            //String email = jwt.getClaim("aud"); // Or any other claim
            //String issuerer = jwt.getClaim("iss"); // Or any other claim

            System.out.println("Token Value: " + tokenValue + "\nUsername: " + "" + "\nEmail: " + "" + "\nIssuerer: " + "");
        }
        
		LocalDateTime time = LocalDateTime.now();
		return "Welcome Home! - " + time;
	}
	
	@GetMapping("/testResource")
	public String testResource() {
		
		 // Get the current authentication object from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the authentication is a JWT token
        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            
            // Get the JWT token and its claims
            String tokenValue = jwt.getTokenValue();
            //String username = jwt.getClaim("sub"); // Or any other claim
            //String email = jwt.getClaim("aud"); // Or any other claim
            //String issuerer = jwt.getClaim("iss"); // Or any other claim

            String resp = "Token ValueToken ValueToken ValueToken ValueToken Value: " + tokenValue + "\nUsername: " + "" + "\nEmail: " + "" + "\nIssuerer: " + "";
    		return "Welcome From Resource! - " + resp;

        }
        
		LocalDateTime time = LocalDateTime.now();
		return "Welcome From Resource! - " + time;

	}

}
