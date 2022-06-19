package com.example.CollegeManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.CollegeManagementSystem.entities.User;
import com.example.CollegeManagementSystem.reposittories.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		creatUserIfNotFound("admin@test.com", "test123");

		alreadySetup = true;
	}

	@Transactional
	void creatUserIfNotFound(String userName, String password) {
		if (userRepository.findByUsername(userName) == null) {
			User user = new User();
			user.setPassword(passwordEncoder.encode(password));
			user.setUsername(userName);
			userRepository.save(user);
		}

	}

}