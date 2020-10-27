package com.maia.bank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiOn {
	
	
	@GetMapping("/on")
	public String testApi() {
		return "Api On!";
	}

}
