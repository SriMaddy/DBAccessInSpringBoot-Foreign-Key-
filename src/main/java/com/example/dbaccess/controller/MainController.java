package com.example.dbaccess.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getWelcomeString() {
		return "Hello Spring Boot. This server is running on localhost:8080";
	}
}
