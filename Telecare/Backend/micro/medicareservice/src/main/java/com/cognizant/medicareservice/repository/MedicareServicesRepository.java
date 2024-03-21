package com.cognizant.medicareservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.medicareservice.model.MedicareServices;






public interface MedicareServicesRepository extends JpaRepository<MedicareServices, Integer> {


@Query("FROM MedicareServices m")
List<MedicareServices> getMedicareServices();
MedicareServices findById(int id);
}
