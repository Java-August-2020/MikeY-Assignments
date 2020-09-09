package com.mike.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.dojosninjas.models.Ninja;
import com.mike.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository nRepo;
	
	
	//create ninja
	public Ninja createNinja(Ninja ninja) {
		return nRepo.save(ninja);
	}
	
	//find ninja by id
//	public Ninja findNinja(Long id) {
//		return nRepo.findById(id).orElse(null);
//	}
	
	//find all ninja
	public List<Ninja> allNinjas() {
		return nRepo.findAll();
	}
}
