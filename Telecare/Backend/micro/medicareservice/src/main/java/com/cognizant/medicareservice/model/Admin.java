package com.cognizant.medicareservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="admin")
public class Admin {
                @Id
                    @Column(name="admin_id")
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
       private          Date dob;
                   @Column(name="contact_number")  
                   private long number;  
                   @Column(name="alt_contact_number")
                private long altnumber;
                   @Column(name="email_id")
                private String email;
                   @Column(name="password")
                private String password;
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
                @Override
                public String toString() {
                                return "Admin [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
                                                                + gender + ", dob=" + dob + ", number=" + number + ", altnumber=" + altnumber + ", email=" + email
                                                                + ", password=" + password + "]";
                }
                   
                   
}

