package com.authservice.microservice.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.authservice.microservice.constant.AppConstant;
import com.authservice.microservice.entity.User;
import com.authservice.microservice.props.AppProperties;
import com.authservice.microservice.responce.ApiResponse;
import com.authservice.microservice.serviceIMPL.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserRestController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private AppProperties properties;
	
	Map<String , String > messages;
	@PostConstruct
	public void init() {
		messages=properties.getMessages();
	}
	
	

	@PostMapping("/register")
	public ResponseEntity<ApiResponse<User>> createUser(
			@RequestParam("user") String userJson,
			@RequestParam("file") MultipartFile file) throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		User user = mapper.readValue(userJson, User.class);

		User addedUser = userService.addUser(user, file);

		ApiResponse<User> response = new ApiResponse<>();

		response.setData(addedUser);
		response.setMessage(messages.get(AppConstant.USER_REG));
		response.setStatus(201);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<User>> login(
			@RequestBody User user) {

		log.info("Login Request : {}", user.getEmail());

		User loginUser = userService.login(user);

		ApiResponse<User> response = new ApiResponse<>();

		response.setData(loginUser);
		response.setMessage(messages.get(AppConstant.LOGIN) );
		response.setStatus(200);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}