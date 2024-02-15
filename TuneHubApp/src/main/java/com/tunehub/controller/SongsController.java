package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entities.Song;
import com.tunehub.services.SongService;

@Controller
public class SongsController {
    
	//connecting for service class
	@Autowired
	SongService songS;
	
//this mapping for adding song method 	
@PostMapping("/addsongs")	
public String addSongs(@ModelAttribute Song song)
{
	//this is used to check weather song is already exist in database or not
	boolean songStatus = songS.songExists(song.getSongName());
	
	//if song is not exist return false than u add song and land song added success page
	if(songStatus == false)
	{
	  songS.addSongs(song);
	  return "songaddedsuccess";
	}
	
	//if song is exist return true than u land song added fail page in that u try again 
	else
	{
		return "songaddedfail";
	}

}


//this mapping for displaying all song list
//here i did direct mapping
@GetMapping("/map-viewsongs")	
public String viewSongs(Model model)  //Model is a inbuilt interface in java it displaying List of Data
{
	List<Song> songList = songS.getAllSongs();
	
	/* using model reference call inbuilt addAttribute method it accept 
	1. first parameter is what we have to store in string type
	2. second parameter is how we have to access as variable name */ 
    model.addAttribute("songList", songList);
    
    //returning playlist of song using html page in that i am using Thymleaf
	return "viewsongs";
	

}

@GetMapping("/viewsongs")
public String cusViewSongs(Model model)
{ 
	
	boolean primeStatus = true;
	if(primeStatus == true)
	{
		List<Song> songList = songS.getAllSongs();
		model.addAttribute("songList", songList);
		return "viewsongs";
	}
	else
	{
		return "makepayment";
	}
}


}