package com.cognizant.userservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.userservice.model.Doctor;
import com.cognizant.userservice.repository.DoctorRepository;

@Component
public class DoctorService {
                @Autowired
                DoctorRepository doctorRepository;
                @Transactional
                public List<Doctor> getDoctorlist() {
                                // TODO Auto-generated method stub
                                return  doctorRepository.getDoctordetails();
                }
                @Transactional
                                public Doctor getDoctorById(int id) {
                                                // TODO Auto-generated method stub
                                                return doctorRepository.findById(id);
                                }
}
