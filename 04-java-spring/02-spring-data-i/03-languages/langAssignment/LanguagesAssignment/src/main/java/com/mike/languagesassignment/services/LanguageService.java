package com.mike.languagesassignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.languagesassignment.models.Language;
import com.mike.languagesassignment.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository langRepo;
	
	//getAll
	public List<Language> getAllLangs() {
		return this.langRepo.findAll();
	}
	
	//get by id
	public Language findLanguage(Long id) {
		return langRepo.findById(id).orElse(null);
	}
	
	//create
	public Language createLanguage(Language newLang) {
		return this.langRepo.save(newLang);
	}
	
	public Language createLanguage(String language, String creator, Float version) {
		Language newLanguage = new Language(language, creator, version);
				return this.langRepo.save(newLanguage);
	}
	
	//update
	public Language updateLanguage(Language updatedLang) {
		return this.langRepo.save(updatedLang);
	}
	
	
	//delete
	public void deleteLanguage(Long id) {
		this.langRepo.deleteById(id);
	}
}
