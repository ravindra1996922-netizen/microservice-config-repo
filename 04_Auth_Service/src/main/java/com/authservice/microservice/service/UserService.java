package com.authservice.microservice.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import com.authservice.microservice.entity.User;

public interface UserService {

	public User addUser(User user, MultipartFile multipartFile) throws Exception;

	public User login(User user);

	public User getUserById(Integer userId);

	public List<User> getAllUser();

	public User deleteUserById(Integer userId);

}
