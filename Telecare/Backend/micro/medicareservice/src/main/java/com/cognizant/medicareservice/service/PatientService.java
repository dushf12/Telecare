package com.cognizant.medicareservice.service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.medicareservice.model.Doctor;
import com.cognizant.medicareservice.model.Patient;
import com.cognizant.medicareservice.model.Report;
import com.cognizant.medicareservice.model.Role;
import com.cognizant.medicareservice.model.Users;
import com.cognizant.medicareservice.repository.DoctorRepository;
import com.cognizant.medicareservice.repository.PatientRepository;
import com.cognizant.medicareservice.repository.ReportRepository;
import com.cognizant.medicareservice.repository.RoleRepository;
import com.cognizant.medicareservice.repository.UsersRepository;
@Service
public class PatientService {

	
	  @Autowired
	    PatientRepository  patientRepository;
	  
		@Autowired
		RoleRepository roleRepository;
		
		@Autowired
		UsersRepository userRepository;
		@Autowired
		DoctorRepository doctorRepository;
		@Autowired
		ReportRepository reportRepository;
		
		@Transactional
		public String patientsignUp(Patient patient,String role) {
			Patient name = patientRepository.findByUsername(patient.getFirstname());

	        if (name == null) {
	            Patient newpatient = new Patient();
	            
	            Users user = new Users();
	            
	            user.setUsername(patient.getFirstname());
	            user.setPassword(passwordEncodered().encode(patient.getPassword()));
	            user.setApprove("P");
	            Role roles = roleRepository.findByName(role);
				Set<Role> prole = new HashSet<>();
				prole.add(roles);
				user.setRoleList(prole);
	          
	            newpatient.setFirstname(patient.getFirstname());
	            newpatient.setLastname(patient.getLastname());
	            newpatient.setPassword(passwordEncodered().encode(patient.getPassword()));
	            newpatient.setGender(patient.getGender());
	            newpatient.setAge(patient.getAge());
	            newpatient.setDob(patient.getDob());
	            newpatient.setCity(patient.getGender());
	            newpatient.setAddress1(patient.getAddress1());
	            newpatient.setAddress2(patient.getAddress2());
	            newpatient.setCode(patient.getCode());
	            newpatient.setEmail(patient.getEmail());
	            newpatient.setState(patient.getState());
	            newpatient.setAltnumber(patient.getAltnumber());     
	            newpatient.setNumber(patient.getNumber());
	    
	            patientRepository.save(newpatient);
	            userRepository.save(user);
	            return "true";
	}
	return "false";

		}
	      
		  public List<Report> patientReports(String patientName){
			  
			  Patient pat = patientRepository.findByUsername(patientName);
			  int patientId =pat.getId();
              return reportRepository.getReports(patientId);
}
            
 public Patient getPatient(String patientName){
			  
              return patientRepository.findByUsername(patientName);
}
            
		
		@Bean
		public PasswordEncoder passwordEncodered() {
			return new BCryptPasswordEncoder();
		}

	
			
	
}