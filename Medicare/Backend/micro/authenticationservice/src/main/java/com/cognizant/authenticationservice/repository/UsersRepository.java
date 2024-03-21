package com.cognizant.authenticationservice.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.Users;




@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

	Users findByUsername(String name);

    @Query("select u from Users u join u.roleList r where r.name='doctor' and u.approve like 'P'")
    List<Users> doctorPendingDetails();


    @Query("select u from Users u join u.roleList r where r.name='patient' and u.approve like 'P'")
    List<Users> patientPendingDetails();

	public List<Users> deleteById(int id);


}
