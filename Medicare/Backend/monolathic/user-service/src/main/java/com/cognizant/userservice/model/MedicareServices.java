package com.cognizant.userservice.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="medicare_services")
public class MedicareServices {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medicare_service_id")
  private int id;
   @Column(name="medicare_service")  
  private String medicareservice;
   @Column(name="service_description")  
   private String servicedesc;
   @Column(name="amount")
   private int amount;

public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMedicareservice() {
                return medicareservice;
}
public void setMedicareservice(String medicareservice) {
                this.medicareservice = medicareservice;
}
public String getServicedesc() {
                return servicedesc;
}
public void setServicedesc(String servicedesc) {
                this.servicedesc = servicedesc;
}
public int getAmount() {
                return amount;
}
public void setAmount(int amount) {
                this.amount = amount;
}
@Override
public String toString() {
                return "MedicareServices [id=" + id + ", medicareservice=" + medicareservice + ", servicedesc=" + servicedesc
                                                + ", amount=" + amount + "]";
}
   



}










