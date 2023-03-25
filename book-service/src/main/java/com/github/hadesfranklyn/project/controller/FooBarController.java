package com.github.hadesfranklyn.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
@RequestMapping("book-service")
public class FooBarController {

	private Logger logger =LoggerFactory.getLogger(FooBarController.class);
	
	@GetMapping("/foo-bar")
	@Bulkhead(name = "default")
	public String fooBar() {
		logger.info("Request to foo-bar is received!");
		return "Foo-Bar!!!";
	}
	public String fallbackMethod(Exception ex) {
		return "fallbackMethod foo-bar!!!";
	}
}