package com.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	//Mapping of register form or displaying a html page
	//because html to html page is not display directly i need controller for mapping 
	@GetMapping("/map-register")
	
	//this method return register form on client side
	public String registerMapping()
	{
		return "register";
	}
	
	
	//Mapping of Login html page
	@GetMapping("/map-login")
	
	//this method return login form on client side
	public String loginMapping()
	{
		return "login";
	}
	
	
	//Mapping of adding song html page
	@GetMapping("/map-songs")
	
	//this method is return addsongs form on client side
	public String songsMapping()
	{
		return "addsongs";
	}
	
	
	@GetMapping("/makepayment")
	public String makePayment()	
	{
		return "makePayment";
	}
	
}
