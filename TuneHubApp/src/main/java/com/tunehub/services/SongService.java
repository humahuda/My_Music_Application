package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.PlayList;
import com.tunehub.entities.Song;

public interface SongService {

	public String addSongs(Song song);
	
	public boolean songExists(String songName);
	
	 public List<Song> getAllSongs();

	public void updateSong(Song song);
	 
}
