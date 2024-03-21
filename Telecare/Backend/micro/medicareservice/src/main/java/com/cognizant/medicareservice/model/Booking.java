package com.cognizant.medicareservice.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cognizant.medicareservice.model.Doctor;
import com.cognizant.medicareservice.model.Patient;

public class Booking {
    //Set<Doctor> list = new HashSet<>();
Set<Patient> listone=new HashSet<>();


public Set<Patient> getListone() {
    return listone;
}
public void setListone(Set<Patient> listone) {
    this.listone = listone;
}
//public Set<Doctor> getList() {
//    return list;
//}
//public void setList(Set<Doctor> list) {
//    this.list = list;
//}
public Booking(Set<Doctor> list, Set<Patient> listone) {
	super();
	//this.list = list;
	this.listone = listone;
}
public Booking() {
	super();
}


}
