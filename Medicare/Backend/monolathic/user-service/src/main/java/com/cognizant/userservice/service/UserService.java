package com.cognizant.userservice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.userservice.model.Doctor;
import com.cognizant.userservice.model.MedicareServices;
import com.cognizant.userservice.model.Patient;
import com.cognizant.userservice.model.Report;
import com.cognizant.userservice.model.Role;
import com.cognizant.userservice.model.Users;
import com.cognizant.userservice.repository.DoctorRepository;
import com.cognizant.userservice.repository.MedicareServicesRepository;
import com.cognizant.userservice.repository.PatientRepository;
import com.cognizant.userservice.repository.ReportRepository;
import com.cognizant.userservice.repository.RoleRepository;
import com.cognizant.userservice.repository.UsersRepository;

@Service
public class UserService {
	@Autowired
	UsersRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	MedicareService medicareServices;
	@Autowired
	MedicareServicesRepository medicareServicesRepository;
	@Autowired
	ReportRepository reportRepository;

	@Transactional
	public String doctersignUp(Doctor doctor, String role) {
		Doctor name = doctorRepository.findByUsername(doctor.getFirstname());

		if (name == null) {
			Doctor newdoctor = new Doctor();

			Users user = new Users();

			user.setUsername(doctor.getFirstname());
			user.setPassword(passwordEncode().encode(doctor.getPassword()));
			user.setApprove("P");
			Role roles = roleRepository.findByName(role);
			Set<Role> docrole = new HashSet<>();
			docrole.add(roles);
			user.setRoleList(docrole);

			newdoctor.setFirstname(doctor.getFirstname());
			newdoctor.setLastname(doctor.getLastname());
			newdoctor.setPassword(passwordEncode().encode(doctor.getPassword()));
			newdoctor.setGender(doctor.getGender());
			newdoctor.setAge(doctor.getAge());
			newdoctor.setDob(doctor.getDob());
			newdoctor.setCity(doctor.getGender());
			newdoctor.setAddress1(doctor.getAddress1());
			newdoctor.setAddress2(doctor.getAddress2());
			newdoctor.setCode(doctor.getCode());
			newdoctor.setEmail(doctor.getEmail());
			newdoctor.setClinicname(doctor.getClinicname());
			newdoctor.setState(doctor.getState());
			newdoctor.setAltnumber(doctor.getAltnumber());
			newdoctor.setMedicareserviceid(doctor.getMedicareserviceid());
			newdoctor.setNumber(doctor.getNumber());
			newdoctor.setDegree(doctor.getDegree());
			newdoctor.setWorkhours(doctor.getWorkhours());
			MedicareServices medicalservice = medicareServicesRepository.findById(doctor.getMedicareserviceid());
			System.out.println("****************************");
			System.out.println(",,,,,,,,,,,,,,," + medicalservice);
			newdoctor.setMedicareService(medicalservice);
			newdoctor.setStatus("P");
			doctorRepository.save(newdoctor);
			userRepository.save(user);

			return "true";
		}
		return "false";

	}

	@Transactional
	public List<Doctor> doctorDetails() {
		return doctorRepository.getDoctordetailsapproved();
	}

	@Transactional
	public Doctor doctorDetailsById(int id) {
		return doctorRepository.findById(id);
	}

	public Doctor doctorDetailsByName(String name) {
		return doctorRepository.findByUsername(name);
	}

	@Transactional
	public List<Users> doctorPendingDetails() {
		return userRepository.doctorPendingDetails();
	}

	@Transactional
	public List<Users> patientPendingDetails() {
		return userRepository.patientPendingDetails();
	}

	@Transactional
	public List<Users> deleteDetails(int id) {
		return userRepository.deleteById(id);
	}

	public void doctoResponse(Users user) {
		userRepository.save(user);
	}

	public void patientResponse(Users user) {
		userRepository.save(user);
	}

	@Transactional
	public List<Users> deleteDetailsPatient(int id) {
		return userRepository.deleteById(id);
	}

	@Transactional
	public Users findByUsername(String user) {
		return userRepository.findByUsername(user);
	}

	@Transactional
	public void doctorapprove(String doctor, Patient patient) {
		int f = 0;
		Doctor name = doctorRepository.findByUsername(doctor);
		System.err.println(name);
		int docid = name.getId();
		int paiid = patient.getId();
		List<Report> reportlist = reportRepository.findAll();
		for (Report report : reportlist) {
			String id = Integer.toString(docid);
			String id1 = Integer.toString(paiid);
			String doid = Integer.toString(report.getDocid());
			String paid = Integer.toString(report.getCusid());
			if (doid.equals(id) && paid.equals(id1) && f == 0) {
				report.setStatus("A");
				reportRepository.save(report);
				f = 1;
			} else if (doid.equals(id) && paid.equals(id1) && f == 1) {
				reportRepository.delete(report);
			}
		}

	}

	@Transactional
	public void deletereportid(int patientid, String username) {

		Doctor name = doctorRepository.findByUsername(username);
		System.err.println("NAME LIST " + name);
		int docid = name.getId();
		String id1 = Integer.toString(patientid);
		List<Report> reportlist = reportRepository.findAll();
		for (Report report : reportlist) {
			String id = Integer.toString(docid);

			String doid = Integer.toString(report.getDocid());
			String paid = Integer.toString(report.getCusid());
			if (doid.equals(id) && paid.equals(id1)) {
				System.err.println("DELETE REPORT : " + report);
				reportRepository.delete(report);

			}
		}

		// int docid=name.getId();
		Set<Patient> patientone = name.getPatientList();
		for (Patient patient2 : patientone) {
			String id = Integer.toString(patient2.getId());

			if (id1.equals(id)) {
				patientone.remove(patient2);
				doctorRepository.save(name);
			}

		}

	}

	public Report generatereport(int patient, String doctor) {
		Doctor name = doctorRepository.findByUsername(doctor);
		int docid = name.getId();

		List<Report> reportlist = reportRepository.findAll();
		for (Report report : reportlist) {
			String id = Integer.toString(docid);
			String id1 = Integer.toString(patient);
			String doid = Integer.toString(report.getDocid());
			String paid = Integer.toString(report.getCusid());
			if (doid.equals(id) && paid.equals(id1)) {
				return report;
			}

		}
		return null;
	}

	@Transactional
	public void modifyReport(Report report) {
		// TODO Auto-generated method stub
		reportRepository.save(report);
	}

	@Transactional
	@Bean
	public PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}

}
