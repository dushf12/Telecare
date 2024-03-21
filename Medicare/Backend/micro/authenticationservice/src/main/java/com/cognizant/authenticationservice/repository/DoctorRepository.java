package com.cognizant.authenticationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.authenticationservice.model.Doctor;



public interface DoctorRepository  extends JpaRepository<Doctor, String> { 
	
	@Query("FROM Doctor u where u.firstname=?1")
	public Doctor findByUsername(String name);

    @Query("SELECT d.firstname FROM Doctor d")
    public List<Doctor> getDoctordetails( );
    Doctor findById(int id);
    
    @Query("FROM Doctor d where d.status like 'A'")
    public List<Doctor> getDoctordetailsapproved( );
}

