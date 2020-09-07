package com.mike.licenseassignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.licenseassignment.models.Person;
import com.mike.licenseassignment.repositories.PersonRepository;

@Service
public class PersonService {
@Autowired

private PersonRepository pRepo;

//create person
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	//get person
	public Person getPerson(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	
	//get all people
	public List<Person> getAllPeople() {
		return pRepo.findAll();
	}
	
}
