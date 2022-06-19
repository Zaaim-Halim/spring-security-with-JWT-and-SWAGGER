package com.example.CollegeManagementSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CollegeManagementSystem.entities.User;
import com.example.CollegeManagementSystem.reposittories.UserRepository;


@Transactional(readOnly=true)
@Service("customUserDetailsService")
public class MyCustomUserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("could not find user with : " + username);

		} else {
			
			//return user;
			return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getAuthorities());
			
		}
	}

}
