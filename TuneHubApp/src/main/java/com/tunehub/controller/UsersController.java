package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entities.PlayList;
import com.tunehub.entities.Song;
import com.tunehub.entities.Users;
import com.tunehub.services.PlayListService;
import com.tunehub.services.SongService;
import com.tunehub.services.UsersService;
import com.tunehub.services.UsersServiceImplementation;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	//connecting service class 
	@Autowired
	UsersService userv;
	
	@Autowired
	SongService songserv;
	
	@Autowired
	UsersServiceImplementation userservi;
	
	@Autowired
	PlayListService playservice;

	//this mapping is for add users
	@PostMapping("/register")
	
	//when user click register button the internal process happen
	//in this method i call addUser method of service 
	public String addUser(@ModelAttribute Users user)
	{
		boolean userStatus = userv.emailExists(user.getEmail());
		if(userStatus == false)
		{
		  //calling addUser method 
		  userv.addUser(user);
		  return "registersuccess";
		}
		
		else
		{
			return "registerfail";
		}
		
	}
	
	
	
	//This mapping is for login if password matches with existing password you successfully login otherwise no
	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password ,HttpSession session )
	{
		if(userservi.userExist(email))
		{
			return "loginfail";
		}
		else
		{
		
		
		//if user input password match with existing password you successfully login and user have two option
		if(userv.validateUser(email, password) == true)
		{
			session.setAttribute("email", email);
			//1.if your role match with admin u land admin home page
			if(userv.getRole(email).equals("admin"))
			{
			return "adminhome";
			}
			
			//2.if your role match with customer u land customer page
			else
			{
				return "customerhome";
			}
		}
		
		// if your password is not match with existing password you login again
		else
		{
			return "loginfail";
		}
		}
	}
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session, Model model) {
		
			String email = (String) session.getAttribute("email");
			
			Users user = userv.getUser(email);
			
			boolean userStatus = user.isPremium();
			if(userStatus == true) {
				List<Song> songList = songserv.getAllSongs();
				model.addAttribute("songList", songList);
				return "viewsongs";
			}
			else {
				return "makepayment";
			}
	}
	

	
	

	
}
