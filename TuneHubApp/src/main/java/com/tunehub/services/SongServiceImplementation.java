
package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tunehub.entities.Song;
import com.tunehub.repositories.SongRepository;


@Service
public class SongServiceImplementation implements SongService{

	@Autowired
	SongRepository repo;
	@Override
	public String addSongs(Song song) {
		
		repo.save(song);
		return "song is created and saved";
	}
	
public boolean songExists(String songName) {
		
		if(repo.findBysongName(songName) == null)
		{
			return false;
			
		}
		
		else
		{
			return true;
		}
				
	}
	

@Override
public List<Song> getAllSongs() {

	List<Song> songList = repo.findAll();
	return songList;
}

@Override
public void updateSong(Song song) {
	repo.save(song);
}





}
