package com.cognizant.medicareservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.medicareservice.model.Doctor;
import com.cognizant.medicareservice.model.MedicareServices;
import com.cognizant.medicareservice.repository.DoctorRepository;
import com.cognizant.medicareservice.repository.MedicareServicesRepository;


@Component
public class MedicareService {
                @Autowired
                MedicareServicesRepository medicareServiceRepository;
                
                
                @Autowired
               DoctorRepository doctorRepository;
                @Transactional
                                public MedicareServices getMedicare(int id) {
                	System.err.println(id);
                	                        Doctor doc=doctorRepository.findById(id);System.err.println(doc);
                	                       int medicalServiceId=doc.getMedicareserviceid();
                                                
                                                return medicareServiceRepository.findById(medicalServiceId);
                                }
                                @Transactional
                                public void modifyMedicare(MedicareServices medicare) {
                                                // TODO Auto-generated method stub
                                                medicareServiceRepository.save(medicare);
                                }
                
                                                @Transactional
                                                public List<MedicareServices> getMedicareServices() {
                                                                // TODO Auto-generated method stub
                                                                return  medicareServiceRepository.getMedicareServices();
                                                }
                                                
}

