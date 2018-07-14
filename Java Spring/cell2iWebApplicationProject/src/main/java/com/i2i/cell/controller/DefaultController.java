package com.i2i.cell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping("/")
	public String home1() {
		return "/invoice";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/changePassword")
	public String changePassword() {
		return "/changePassword";
	}
	
	@GetMapping("/home")
	public String home() {
		return "/home";
	}

	@GetMapping("/message")
	public String message() {
		return "/message";
	}

	@GetMapping("/gifts")
	public String gifts() {
		return "/gifts";
	}
	
	@GetMapping("/invoice")
	public String invoive() {
		return "/invoice";
	}
	
	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

}
