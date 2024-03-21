package com.cognizant.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.userservice.model.Patient;
import com.cognizant.userservice.model.Report;
import com.cognizant.userservice.service.PatientService;

@CrossOrigin("http://localhost:4201")
@RestController
public class PatientController {

	@Autowired
	PatientService patientService;
	
	

	
	
    String role;

	@PostMapping("/patient")
	public String patientsignUp(@RequestBody Patient patientList) {
		role="patient";
		return patientService.patientsignUp(patientList,role);
	}
	
	@GetMapping("/patient/viewreport/{patientName}")
	 public List<Report> generatereport(@PathVariable("patientName") String patientName){
        return patientService.patientReports(patientName);
}
	
	@GetMapping("/patient/getpatient/{patientName}")
	 public Patient getPatient(@PathVariable("patientName") String patientName){
       return patientService.getPatient(patientName);
	
}
}