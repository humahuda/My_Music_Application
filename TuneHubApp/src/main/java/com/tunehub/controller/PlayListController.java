package com.tunehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entities.PlayList;
import com.tunehub.entities.Song;
import com.tunehub.entities.Users;
import com.tunehub.services.PlayListService;
import com.tunehub.services.SongService;
import com.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PlayListController {
	
	//connecting of PlayListService class
	@Autowired
	PlayListService playService;
	
	//connecting of SongService class
	@Autowired
	SongService songS;
	
	@Autowired
	UsersService userS;

	//mapping of createplaylist from
@GetMapping("/createplaylist")
public String createPlayList(Model model)
{
	//fetch the data from database using song service and store in the variable as a list
	List<Song> songList =  songS.getAllSongs();
	
	//adding the songs in the model 
	model.addAttribute("songList", songList);
	
	//this method return create playlist form
	return "createplaylist";
}

//mapping of addplaylist
@PostMapping("/addplaylist")
public String addPlayList(@ModelAttribute PlayList playlist) {
	//adding playlist
	playService.addPlayList(playlist);
	
	//update song table
	
	List<Song> songsList= playlist.getSong();
	for(Song song : songsList) {
		song.getPlayList().add(playlist);
		songS.updateSong(song);
	}
	
	return "playlistsuccess";
}


@GetMapping("/viewPlaylist")
public String viewPlaylists(Model model) {
	List<PlayList> plist= playService.getAllSongs();
//	System.out.println(plist);
	model.addAttribute("plist", plist);
	return "viewPlaylist";
}

@GetMapping("/viewcusplaylist")
public String viewCusPlaylist(HttpSession session, Model model) {
	
		String email = (String) session.getAttribute("email");
		
		Users user = userS.getUser(email);
		
		boolean userStatus = user.isPremium();
		if(userStatus == true) {
			List<PlayList> plist= playService.getAllSongs();

			model.addAttribute("plist", plist);
			return "viewPlaylist";
		}
		else {
			return "makepayment";
		}
}
}

