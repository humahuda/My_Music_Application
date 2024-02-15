package com.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entities.Song;
import com.tunehub.entities.Users;

public interface SongRepository extends JpaRepository<Song, Integer>{

	public Song findBysongName(String songName);
}
