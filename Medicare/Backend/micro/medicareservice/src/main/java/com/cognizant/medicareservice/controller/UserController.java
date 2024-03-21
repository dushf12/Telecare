package com.cognizant.medicareservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicareservice.model.Doctor;
import com.cognizant.medicareservice.model.MedicareServices;
import com.cognizant.medicareservice.model.Patient;
import com.cognizant.medicareservice.model.Report;
import com.cognizant.medicareservice.model.Users;
import com.cognizant.medicareservice.repository.DoctorRepository;
import com.cognizant.medicareservice.service.AppUserDetailsService;
import com.cognizant.medicareservice.service.UserService;

@CrossOrigin("http://localhost:4201")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	AppUserDetailsService appUserDetailsService;
	@Autowired
	DoctorRepository doctorRepository;
    String role;
	@PostMapping("/doctor")
	public String doctersignUp(@RequestBody Doctor doctorList) {
		role="doctor";
		return userService.doctersignUp(doctorList,role);
	}
	
	
	@GetMapping("/doctordetails")
	public List<Doctor> Detail(){
		return userService.doctorDetails();
		
	}
	
	@GetMapping("/doctordetailsById/{id}")
	public Doctor doctorDetail(@PathVariable("id")int id){
		return userService.doctorDetailsById(id);
		
	}
	
	@GetMapping("/doctordetailsByName/{name}")
	public Doctor doctorDetail(@PathVariable("name")String name){
		return userService.doctorDetailsByName(name);
		
	}
	
    @GetMapping("/doctorapproverequest")
    public List<Users> doctorPendingDetails(){
                    return userService.doctorPendingDetails();
    }
    
   
    
    @PutMapping("/admindoctorupdate")
    public void doctoResponse(@RequestBody Users user)
    {
    	user.setApprove("A");
        String username=user.getUsername();

        List<Doctor> doctorlist=doctorRepository.findAll();
       
     for (Doctor doctor : doctorlist) {
                    
                    
                    
                     if(doctor.getFirstname().equals(username))
                    {
                                    doctor.setStatus("A");
                                      doctorRepository.save(doctor);
                                    
                    }
                    
     }
    	userService.doctoResponse(user);
    }
    
   
    @DeleteMapping("/{deleteid}")
    public List<Users> deletedetails(@PathVariable("deleteid")int deleteid)
    {
    	return userService.deleteDetails(deleteid);
    }
    
    
    /////patient
    
    
    @GetMapping("/patientapproverequest")
    public List<Users> patientPendingDetails(){
                    return userService.patientPendingDetails();
    }
    
    
    @PutMapping("/adminpatientupdate")
    public void patientResponse(@RequestBody Users user)
    {
    	user.setApprove("A");
   // System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,uppssss");
    	userService.patientResponse(user);
    }
    
    @DeleteMapping("/patient/{deleteid}")
    public List<Users> deleteDetailsPatient(@PathVariable("deleteid")int deleteid)
    {
    	return userService.deleteDetailsPatient(deleteid);
    }
    
    //////DocApprove
    
    
    
    @PutMapping("/doctorpatientupdate/{docname}")
    public void doctorPatientResponse(@PathVariable("docname") String docname,@RequestBody Patient patient)
    {
    System.err.println(patient);
    System.err.println(docname);
    userService.doctorapprove(docname,patient);
    }
    
    @DeleteMapping("/doctorpatientdelete/{deleteid}/{username}")
    public void deletereportid(@PathVariable("deleteid") int patientid,@PathVariable("username") String username)
    {
    	System.err.println("DELETE ID : " +patientid +" "+username);
    	 	userService.deletereportid(patientid,username);
    }
    
    @GetMapping("/genaratereport/{patientid}/{doctor}")
    public Report generatereport(@PathVariable("patientid") int patientid,@PathVariable("doctor") String doctor){
                    return userService.generatereport(patientid,doctor);
    }
    
    @PutMapping("/postreport")
    public void postReport(@RequestBody Report report) {
    	userService.modifyReport(report);      
    }
    
}
