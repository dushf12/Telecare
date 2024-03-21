package com.cognizant.userservice.service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.userservice.model.Doctor;
import com.cognizant.userservice.model.Patient;
import com.cognizant.userservice.model.Report;
import com.cognizant.userservice.repository.DoctorRepository;
import com.cognizant.userservice.repository.MedicareServicesRepository;
import com.cognizant.userservice.repository.PatientRepository;
import com.cognizant.userservice.repository.ReportRepository;

@Component
public class BookingService {
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	MedicareServicesRepository medicareServiceRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	ReportRepository reportRepository;

	@Transactional
	public void bookAppointment(String patient, String doctor) throws ParseException {

		Patient patientone = patientRepository.findByUsername(patient);
		Doctor name = doctorRepository.findByUsername(doctor);
		int patientid = patientone.getId();
		int doctorid = name.getId();
		int medid = name.getMedicareserviceid();

		System.out.println("patient id" + patientid);
		Report report = new Report();
		report.setDocid(doctorid);
		report.setMedid(medid);
		report.setCusid(patientid);
		report.setStatus("W");

		Set<Patient> medi = name.getPatientList();
		Set<Report> report1 = patientone.getReportList();
		report1.add(report);
		reportRepository.save(report);
		medi.add(patientone);
		patientRepository.save(patientone);
		doctorRepository.save(name);

	}

	@Transactional
	public Set<Patient> getAllBookings(String doctor) {
		Doctor name = doctorRepository.findByUsername(doctor);
		System.err.println("IN THE BOOKING SECTION DOCTOR " + name.getId());
		Set<Patient> medi = name.getPatientList();
		// if(!name.getStatus().equals("A")){
		// Set<Patient> medi=name.getPatientList();
		// return medi;
		// }
		Set<Patient> patients = new HashSet<>();

		for (Patient patient : medi) {
			for (Report report : patient.getReportList()) {
				System.err.println("STATUS OF THE DOCTOR " + report.getStatus() + " " + report.getDocid());
				if ((report.getStatus().equals("W")) && (report.getDocid() == name.getId())) {
					System.err.println("DOCTOR ID WITHOUT STATUS A " + report.getDocid());
					patients.add(patient);
					break;
				}
			}
		}
		return patients;
	}

	@Transactional
	public Set<Patient> getApprovedPatients(String doctor) {
		Doctor name = doctorRepository.findByUsername(doctor);
		// System.err.println("IN THE BOOKING SECTION DOCTOR "+name.getId());
		Set<Patient> medi = name.getPatientList();
		System.err.println("aewdfada");
		// if(!name.getStatus().equals("A")){
		// Set<Patient> medi=name.getPatientList();
		// return medi;
		// }
		Set<Patient> patients = new HashSet<>();

		for (Patient patient : medi) {
			for (Report report : patient.getReportList()) {
				System.err.println("STATUS OF THE DOCTOR " + report.getStatus() + " " + report.getDocid());
				if ((report.getStatus().equals("A")) && (report.getDocid() == name.getId())) {
					System.err.println("DOCTOR ID WITHOUT STATUS A " + report.getDocid());
					patients.add(patient);
					break;
				}
			}
		}

		return patients;
	}

}
