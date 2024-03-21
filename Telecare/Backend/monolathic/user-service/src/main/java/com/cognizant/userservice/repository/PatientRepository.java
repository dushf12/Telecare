package com.cognizant.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.userservice.model.Doctor;
import com.cognizant.userservice.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{

	
	@Query("FROM Patient u where u.firstname=?1")
	public Patient findByUsername(String name);
	
	Patient findById(int id);
	
}
