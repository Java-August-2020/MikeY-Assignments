package com.mike.licenseassignment.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.licenseassignment.models.License;
import com.mike.licenseassignment.repositories.LicenseRepository;

@Service
public class LicenseService {
@Autowired

private LicenseRepository lRepo;


//create license
public License createLicense(License newLicense) {
	Long licenseNumber = this.lRepo.count();
	newLicense.setNumber(String.format("00000%d", licenseNumber));
	return this.lRepo.save(newLicense);
}

public License getLicense(Long id) {
	return lRepo.findById(id).orElse(null);
	}

}