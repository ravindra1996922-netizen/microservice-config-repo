package com.authservice.microservice.serviceIMPL;

import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.impl.nio.MessageState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.authservice.microservice.constant.AppConstant;
import com.authservice.microservice.entity.User;
import com.authservice.microservice.exception.AuthServiceException;
import com.authservice.microservice.props.AppProperties;
import com.authservice.microservice.repository.UserRepository;
import com.authservice.microservice.service.UserService;
import com.authservice.microservice.utils.FileUtils;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AppProperties properties;
	
    private Map<String, String> messages;
    
    @PostConstruct
    public void init() {
        this.messages = properties.getMessages();
    }

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public User addUser(User user, MultipartFile multipartFile) throws Exception {

		if (userRepository.existsByEmail(user.getEmail())) {

			throw new AuthServiceException(
					messages.get(AppConstant.USER_REG_ERR)+" : "+ user.getEmail(),
					messages.get(AppConstant.USER_REG_ERR_CODE),HttpStatus.CONFLICT);
		}

		String fileName = FileUtils.saveFile(
				multipartFile.getOriginalFilename(),
				multipartFile);

		user.setUserpic(fileName);

		String pwd = user.getPwd();

		user.setPwd(passwordEncoder.encode(pwd));

		return userRepository.save(user);
	}

@Override
public User login(User user) {

    try {

        Authentication authenticate =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getEmail(),
                                user.getPwd()));

        return userRepository.findByEmail(
                user.getEmail());

    } catch (Exception e) {

        throw new AuthServiceException(
                messages.get(AppConstant.LOGIN_ERR),
                messages.get(AppConstant.LOGIN_ERR_CODE) ,
                HttpStatus.UNAUTHORIZED);
    }
}

	@Override
	public User getUserById(Integer userId) {

		return userRepository.findById(userId)
				.orElseThrow(() -> new AuthServiceException(
						 messages.get(AppConstant.USER_NOT_FOUND),
						 messages.get(AppConstant.USER_NOT_FOUND_ERR_CODE),HttpStatus.NOT_FOUND));
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User deleteUserById(Integer userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new AuthServiceException(
						 messages.get(AppConstant.USER_NOT_FOUND),
						 messages.get(AppConstant.USER_NOT_FOUND_ERR_CODE),HttpStatus.NOT_FOUND));
		
		userRepository.deleteById(userId);

		return user;
	}
}