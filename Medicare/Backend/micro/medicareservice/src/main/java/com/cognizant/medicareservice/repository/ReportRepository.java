package com.cognizant.medicareservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.medicareservice.model.Report;


public interface ReportRepository extends JpaRepository<Report, String>{
	 @Query("select u from Report u where u.cusid=?1")
	 List<Report> getReports(int patientId);
}
