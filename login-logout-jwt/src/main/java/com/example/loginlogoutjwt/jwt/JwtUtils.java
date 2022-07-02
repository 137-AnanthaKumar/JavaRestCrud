package com.example.loginlogoutjwt.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.loginlogoutjwt.entity.User;
import com.example.loginlogoutjwt.exception.AccessDeniedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtils {
	 private static long expiryDuration = 60 * 60;
	 private static String secret = "This_is_secret";
	 
	 
	 
	  public String generateJwt(User user){
     long milliTime = System.currentTimeMillis();
     long expiryTime = milliTime + expiryDuration * 1000;

	        Date issuedAt = new Date();
	         Date expiryAt = new Date(expiryTime);
	        String s=String.valueOf(user.getId()); 
	        // claims
	        Claims claims = Jwts.claims()
	        		
	        		.setIssuer(s)
	                .setIssuedAt(issuedAt)
	                .setExpiration(expiryAt);

	        // optional claims
	        claims.put("type", user.getUserType());
	        claims.put("name", user.getName());
	        claims.put("emailId", user.getEmail());

	        
	        
	        // generate jwt using claims
	        return Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, secret)
	                .compact();
	        
	       
	    }
	  
	  public Claims verify(String authorization) throws Exception {
		  
		  try {
			 Claims clims= Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
			 System.out.println("name"+clims.get("name"));
                 return clims;
		  }
		  catch (Exception e) {
			  throw new AccessDeniedException("Access Denied");
		  }
	  }
}
