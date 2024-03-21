package com.cognizant.medicareservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicareservice.model.MedicareServices;
import com.cognizant.medicareservice.service.MedicareService;




@RestController
@CrossOrigin
@RequestMapping("/medicare")
public class MedicareController {
                @Autowired
                MedicareService medicareService;
                @GetMapping("/{id}")
                public MedicareServices getMedicare(@PathVariable("id") int id) {
                                                return medicareService.getMedicare(id);
                }
                
                @PutMapping("")
                public void modifyMedicare(@RequestBody MedicareServices medicare) {
                	medicareService.modifyMedicare(medicare);      
                }
                
                @GetMapping("")
                public List<MedicareServices> getAllMedicareServices() {
                                
                                          return medicareService.getMedicareServices();
                                                                }
                                                                
                
}
