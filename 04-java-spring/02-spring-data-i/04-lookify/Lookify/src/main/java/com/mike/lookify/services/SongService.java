package com.mike.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.lookify.models.Song;
import com.mike.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository sRepo;
	
	//getAll
	public List<Song> getAllSongs() {
		return this.sRepo.findAll();
	}
	
	//getOne
	public Song findSong(Long id) {
		return sRepo.findById(id).orElse(null);
	}
	
	//top ten by rating
	public List<Song> topTenByRating() {
		return sRepo.findTop10ByOrderByRatingDesc();
	}
	
	//find by artist
	public List<Song> songsContainingArtist(String artist) {
		return sRepo.findByArtistContaining(artist);
	}
	
	//create
	public Song createSong(Song newSong) {
		return sRepo.save(newSong);
	}
	
	//update
	public Song updateSong(Song song) {
		return sRepo.save(song);
	}
	
	//delete
	public void deleteSong(Long id) {
		sRepo.deleteById(id);
	}
}
