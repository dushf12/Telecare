package com.cognizant.userservice.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="doctor")
public class Doctor {
                @Id
                @PrimaryKeyJoinColumn
                    @Column(name="doctor_id")
                  private int id;
                   @Column(name="first_name")  
                  private String firstname;
                   @Column(name="last_name")  
                  private String lastname;
                   @Column(name="age")  
                 private int age;
                   @Column(name="gender")  
                  private String gender;
                   @Column(name="dob")  
                   private Date dob;
                   @Column(name="contact_number")  
                   private int number;  
                   @Column(name="alt_contact_number")
                private int altnumber;
                   @Column(name="email_id")
                private String email;
                   @Column(name="password")
                private String password;
                   @Column(name="address_line1")
                private String address1;
                   @Column(name="address_line2")
                private String address2;
                   @Column(name="city")
                private String city;
                   @Column(name="state")
                private String state;
                   @Column(name="zip_code")
                                private String code;
                   @Column(name="degree")
                                private String degree;
                   @Column(name="specality")
                                private String specality;
                   @Column(name="work_hours")
                                private String workhours;
                   @Column(name="clinic_name")
                                private String clinicname;
                   @Column(name="medicare_service_id")
                                private int medicareserviceid;
                   @Column(name="do_status")
                   private String status;
                   
                public String getStatus() {
					return status;
				}
				public void setStatus(String status) {
					this.status = status;
				}
				public int getId() {
                                return id;
                }
                public void setId(int id) {
                                this.id = id;
                }
                public String getFirstname() {
                                return firstname;
                }
                public void setFirstname(String firstname) {
                                this.firstname = firstname;
                }
                public String getLastname() {
                                return lastname;
                }
                public void setLastname(String lastname) {
                                this.lastname = lastname;
                }
                public int getAge() {
                                return age;
                }
                public void setAge(int age) {
                                this.age = age;
                }
                public String getGender() {
                                return gender;
                }
                public void setGender(String gender) {
                                this.gender = gender;
                }
                public Date getDob() {
                                return dob;
                }
                public void setDob(Date dob) {
                                this.dob = dob;
                }
              
              
               
                public int getNumber() {
					return number;
				}
				public void setNumber(int number) {
					this.number = number;
				}
				public int getAltnumber() {
					return altnumber;
				}
				public void setAltnumber(int altnumber) {
					this.altnumber = altnumber;
				}
				public String getEmail() {
                                return email;
                }
                public void setEmail(String email) {
                                this.email = email;
                }
                public String getPassword() {
                                return password;
                }
                public void setPassword(String password) {
                                this.password = password;
                }
                public String getAddress1() {
                                return address1;
                }
                public void setAddress1(String address1) {
                                this.address1 = address1;
                }
                public String getAddress2() {
                                return address2;
                }
                public void setAddress2(String address2) {
                                this.address2 = address2;
                }
                public String getCity() {
                                return city;
                }
                public void setCity(String city) {
                                this.city = city;
                }
                public String getState() {
                                return state;
                }
                public void setState(String state) {
                                this.state = state;
                }
                public String getCode() {
                                return code;
                }
                public void setCode(String code) {
                                this.code = code;
                }
                public String getDegree() {
                                return degree;
                }
                public void setDegree(String degree) {
                                this.degree = degree;
                }
                public String getSpecality() {
                                return specality;
                }
                public void setSpecality(String specality) {
                                this.specality = specality;
                }
                public String getWorkhours() {
                                return workhours;
                }
                public void setWorkhours(String workhours) {
                                this.workhours = workhours;
                }
                public String getClinicname() {
                                return clinicname;
                }
                public void setClinicname(String clinicname) {
                                this.clinicname = clinicname;
                }
                public int getMedicareserviceid() {
                                return medicareserviceid;
                }
                public void setMedicareserviceid(int medicareserviceid) {
                                this.medicareserviceid = medicareserviceid;
                }
                
                   
              
                @Override
				public String toString() {
					return "Doctor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
							+ ", gender=" + gender + ", dob=" + dob + ", number=" + number + ", altnumber=" + altnumber
							+ ", email=" + email + ", password=" + password + ", address1=" + address1 + ", address2="
							+ address2 + ", city=" + city + ", state=" + state + ", code=" + code + ", degree=" + degree
							+ ", specality=" + specality + ", workhours=" + workhours + ", clinicname=" + clinicname
							+ ", medicareserviceid=" + medicareserviceid + ", medicareService=" + medicareService + "]";
				}



				@OneToOne(targetEntity=MedicareServices.class,cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="medicare_service")
    private MedicareServices medicareService;
				public MedicareServices getMedicareService() {
					return medicareService;
				}
				public void setMedicareService(MedicareServices medicareService) {
					this.medicareService = medicareService;
				}


                @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_patient",
        joinColumns = @JoinColumn(name = "dp_do_id"), 
        inverseJoinColumns = @JoinColumn(name = "dp_pa_id"))
                private Set<Patient> patientList ;

                public Set<Patient> getPatientList() {
                                return patientList;
                }

                public void setPatientList(Set<Patient> patientList) {
                                this.patientList = patientList;
                }
                
      
                
}



