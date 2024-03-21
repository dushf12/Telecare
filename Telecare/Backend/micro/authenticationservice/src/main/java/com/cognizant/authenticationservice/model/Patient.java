package com.cognizant.authenticationservice.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.cognizant.authenticationservice.model.Doctor;
import com.cognizant.authenticationservice.model.Report;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Component
@Entity
@Table(name="patient")
public class Patient {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                    @Column(name="patient_id")
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
                   private long number;  
                   @Column(name="alt_contact_number")
                private long altnumber;
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
                   @Column(name="zip_code")
                private String code;
                   @Column(name="state")
                private String state;
               
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
                public long getNumber() {
                                return number;
                }
                public void setNumber(long number) {
                                this.number = number;
                }
                public long getAltnumber() {
                                return altnumber;
                }
                public void setAltnumber(long altnumber) {
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
                public String getCode() {
                                return code;
                }
                public void setCode(String code) {
                                this.code = code;
                }
                public String getState() {
                                return state;
                }
                public void setState(String state) {
                                this.state = state;
                }
              
                   
     /* (non-Javadoc)
				 * @see java.lang.Object#toString()
				 */
				@Override
				public String toString() {
					return "Patient [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
							+ ", gender=" + gender + ", dob=" + dob + ", number=" + number + ", altnumber=" + altnumber
							+ ", email=" + email + ", password=" + password + ", address1=" + address1 + ", address2="
							+ address2 + ", city=" + city + ", code=" + code + ", state=" + state + ", dotorList="
							+ dotorList + ", reportList=" + reportList + "]";
				}


	@JsonIgnore
    @ManyToMany(mappedBy = "patientList")
       private Set<Doctor> dotorList;
                

                public Set<Doctor> getDotorList() {
		return dotorList;
	}
	public void setDotorList(Set<Doctor> dotorList) {
		this.dotorList = dotorList;
	}

				@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patient_report",
        joinColumns = @JoinColumn(name = "pr_da_id"), 
        inverseJoinColumns = @JoinColumn(name = "pr_re_id"))
				private Set<Report> reportList ;

                public Set<Report> getReportList() {
                                return reportList;
                }
                public void setReportList(Set<Report> reportList) {
                                this.reportList = reportList;
                }
   
               
                
                
}