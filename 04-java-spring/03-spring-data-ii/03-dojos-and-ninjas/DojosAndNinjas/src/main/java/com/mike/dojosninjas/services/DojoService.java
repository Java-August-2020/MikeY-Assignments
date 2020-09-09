package com.mike.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.dojosninjas.models.Dojo;
import com.mike.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository dRepo;
	
	//create dojo
	public Dojo createDojo(Dojo dojo) {
		return dRepo.save(dojo);
	}
	
	//find by id
	public Dojo findDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	//findAll
	public List<Dojo> allDojos() {
		return dRepo.findAll();
	}
	
}
