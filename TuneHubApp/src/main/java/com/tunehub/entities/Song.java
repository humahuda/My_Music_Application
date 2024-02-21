package com.tunehub.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String songName;
	String songArtist;
	String songGenre;
	String link;
	
	@ManyToMany
	List<PlayList> playList;

	
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Song(int id, String songName, String songArtist, String songGenre, String link, List<PlayList> playList) {
		super();
		this.id = id;
		this.songName = songName;
		this.songArtist = songArtist;
		this.songGenre = songGenre;
		this.link = link;
		this.playList = playList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSongName() {
		return songName;
	}


	public void setSongName(String songName) {
		this.songName = songName;
	}


	public String getSongArtist() {
		return songArtist;
	}


	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}


	public String getSongGenre() {
		return songGenre;
	}


	public void setSongGenre(String songGenre) {
		this.songGenre = songGenre;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public List<PlayList> getPlayList() {
		return playList;
	}


	public void setPlayList(List<PlayList> playList) {
		this.playList = playList;
	}


	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", songArtist=" + songArtist + ", songGenre=" + songGenre
				+ ", link=" + link ;//+ ", playList=" + playList + "]";
	}


	
}
