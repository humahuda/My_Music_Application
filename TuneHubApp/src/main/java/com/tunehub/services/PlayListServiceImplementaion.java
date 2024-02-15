package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.PlayList;
import com.tunehub.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementaion implements PlayListService {

	@Autowired
	PlayListRepository playrepo;

	@Override
	public void addPlayList(PlayList playlist) {
		playrepo.save(playlist);
		
	}

	@Override
	public List<PlayList> getAllSongs() {
		return playrepo.findAll();
	}
	
	

}
