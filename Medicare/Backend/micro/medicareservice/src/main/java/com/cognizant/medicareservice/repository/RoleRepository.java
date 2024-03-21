package com.cognizant.medicareservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.medicareservice.model.Role;





@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	Role findByName(String name);
}
