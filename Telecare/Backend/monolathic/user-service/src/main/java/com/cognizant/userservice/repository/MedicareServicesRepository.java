package com.cognizant.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.userservice.model.MedicareServices;



public interface MedicareServicesRepository extends JpaRepository<MedicareServices, Integer> {


@Query("FROM MedicareServices m")
List<MedicareServices> getMedicareServices();
MedicareServices findById(int id);
}
