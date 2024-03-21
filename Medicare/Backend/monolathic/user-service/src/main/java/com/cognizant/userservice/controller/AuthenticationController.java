package com.cognizant.userservice.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.userservice.model.Users;
import com.cognizant.userservice.repository.UsersRepository;
import com.cognizant.userservice.service.UserService;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin("http://localhost:4201")
@RestController
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired 
	UsersRepository userRepository;
    @Autowired 
    UserService userService;
     
	@GetMapping("/authentication")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Start of auth function");
		HashMap<String, String> map = new HashMap<String, String>();
		String user = getUser(authHeader);
		System.out.println(user);
		String JWT = generateJwt((getUser(authHeader)));
		//String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
        String[] username =user.split(":");
        Users users=userRepository.findByUsername(username[0]);
        int userId=users.getId();
        String userID = Integer.toString(userId);
        System.err.println( users.getRoleList());
        String role=users.getRoleList().toString();
        System.err.println("dfnhjcv"+role);

       // System.out.println("dfnhjcv"+role);
        String[] roleType = role.split(",");
        System.out.println(",,,,,,,,,,,,,,,"+roleType[1]);
        String[] role1=roleType[1].split("=");
        System.out.println("................."+role1[1]);
        String[] role2= role1[1].split("]");

		int id = userService.findByUsername(user).getId();
		String Id =Integer.toString(id);
		 System.err.println(role);
		LOGGER.debug("JWT:{}", JWT);
		map.put("token", JWT);
		map.put("role", role2[0]);
		map.put("id", Id);
		map.put("name",user);
		//map.put("id", "" + userRepository.findByUsername(user).getId());
		
		LOGGER.info("END OF AUTH FUNCTION");
		return map;
	}

	private String getUser(String authHeader) {
		String encodedCredentials = authHeader.split(" ", 2)[1];
		String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		String user = decoded.substring(0, decoded.indexOf(':'));
		return user;
	}

	@SuppressWarnings("unused")
	private String getPassword(String authHeader) {
		String encodedCredentials = authHeader.split(" ", 2)[1];
		String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		String pwd = decoded.substring(decoded.indexOf(':') + 1);
		return pwd;
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return token;
	}
}