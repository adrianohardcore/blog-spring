package br.com.adrianohardcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MediatorController {
	
	@RequestMapping
	public String getHomePage() {
		//return "redirect:/users";
		//return "home";
		return "index/index";  
	}
	
	@RequestMapping(value="/user")
	public String getUserPage() {
		return "user/user";
	}
	
	@RequestMapping(value="/admin")
	public String getAdminPage() {
		return "user/admin";
	}
}