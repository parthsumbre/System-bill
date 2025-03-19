package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Pojo.Product;
import com.app.Pojo.User;
import com.app.dto.CommonApiResponse;
import com.app.dto.RegisterUserRequestDto;
import com.app.dto.UserLoginRequest;
import com.app.dto.UserLoginResponse;
import com.app.resource.UserResource;
import com.app.service.ProductService;
import com.app.service.UserService;
import com.app.utils.JwtUtils;
//import com.cdac.dto.CommonApiResponse;
//import com.cdac.dto.RegisterUserRequestDto;
//import com.cdac.dto.UserLoginRequest;
//import com.cdac.dto.UserLoginResponse;
//import com.cdac.dto.UserResponseDto;
//import com.cdac.dto.UserStatusUpdateRequestDto;
//import com.cdac.resource.UserResource;
//import com.cdac.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/user")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserResource userResource;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtils jwtUtils;
//	@Autowired
//	private EmailService senderService;

	// RegisterUserRequestDto, we will set only email, password & role from UI
	@PostMapping("/admin/register")
	@Operation(summary = "Api to register Admin")
	public ResponseEntity<CommonApiResponse> registerAdmin(@RequestBody RegisterUserRequestDto request) {
		return userResource.registerAdmin(request);
	}

	// for customer and restaurant register
	@PostMapping("register")
	@Operation(summary = "Api to register customer or restaurant user")
	public ResponseEntity<CommonApiResponse> registerUser(@RequestBody RegisterUserRequestDto request) {
		String emailid=request.getEmailId();
		System.out.println(emailid);
//		senderService.sendEmail(emailid, "Successfull register", "Congratulations for registering Successfully at Foodies application");
		return this.userResource.registerUser(request);
	}
	
	@PostMapping("login")
	@Operation(summary =  "Api to login any User")
	public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
		return userResource.login(userLoginRequest);
	}
	
	@GetMapping("products")
	@Operation(summary = "API to fetch products of the logged-in user")
	public ResponseEntity<CommonApiResponse> getProducts(@RequestHeader("Authorization") String token) {
	    // Remove "Bearer " prefix from the token
	    String jwt = token.substring(7);
	    
	    // Extract email (username) from JWT
	    String email = jwtUtils.extractUsername(jwt);

	    // Find user by email
	    User user = userService.getUserByEmailid(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // Fetch products for the user
	    return productService.getProducts(user.getUserId());
	}
	
	@PostMapping("addProduct")
	@Operation(summary = "API to add a product for the logged-in user")
	public ResponseEntity<CommonApiResponse> addProduct(
	        @RequestHeader("Authorization") String token,
	        @RequestBody Product product) {

	    // Extract JWT Token (remove "Bearer " prefix)
	    String jwt = token.substring(7);

	    // Get email from JWT
	    String email = jwtUtils.extractUsername(jwt);

	    // Find the user
	    User user = userService.getUserByEmailid(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // Add product for the user
	    return productService.addProduct(user, product);
	}


	
	

}
