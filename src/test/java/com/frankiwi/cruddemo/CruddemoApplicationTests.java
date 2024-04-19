package com.frankiwi.cruddemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.DEVLooping.cruddemo.service.UserService;

@SpringBootTest
class CruddemoApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	

}
