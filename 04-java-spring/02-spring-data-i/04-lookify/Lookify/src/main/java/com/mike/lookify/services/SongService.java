package com.mike.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mike.lookify.models.Song;
import com.mike.lookify.repositories.SongRepository;

@Service
public class SongService {
	private SongRepository sRepo;
	
	public SongService(SongRepository repo) {
		this.sRepo = repo;
	}
	
	//getAll
	public List<Song> getAllSongs() {
		return this.sRepo.findAll();
	}
	
	//getOne
}
