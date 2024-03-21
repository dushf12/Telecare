package com.cognizant.authenticationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.authenticationservice.model.MedicareServices;




public interface MedicareServicesRepository extends JpaRepository<MedicareServices, Integer> {


@Query("FROM MedicareServices m")
List<MedicareServices> getMedicareServices();
MedicareServices findById(int id);
}
