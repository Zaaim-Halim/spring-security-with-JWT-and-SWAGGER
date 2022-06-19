package com.example.CollegeManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;
@ApiIgnore
@Controller
public class UserController {
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

}
