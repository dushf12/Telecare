package com.cognizant.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.userservice.model.Patient;
import com.cognizant.userservice.model.Report;
import com.cognizant.userservice.model.Users;

public interface ReportRepository extends JpaRepository<Report, String>{
	 @Query("select u from Report u where u.cusid=?1")
	 List<Report> getReports(int patientId);
}
