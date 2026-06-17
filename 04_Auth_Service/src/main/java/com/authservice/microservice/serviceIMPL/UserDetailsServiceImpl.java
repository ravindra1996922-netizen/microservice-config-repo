package com.authservice.microservice.serviceIMPL;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authservice.microservice.entity.User;
import com.authservice.microservice.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email)
	        throws UsernameNotFoundException {

	    User user = userRepository.findByEmail(email);

	    if(user == null) {
	        throw new UsernameNotFoundException(
	            "User not found with email : " + email
	        );
	    }

	    return new org.springframework.security.core.userdetails.User(
	            user.getEmail(),
	            user.getPwd(),
	            Collections.emptyList()
	    );
	}

}
