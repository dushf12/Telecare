package com.cognizant.authenticationservice.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cognizant.authenticationservice.model.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="report")
public class Report {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="report_id")
private int id;
@Column(name="customer_id")
private int cusid;
@Column(name="doctor_id")
private int docid;
@Column(name="medicare_id")
private int medid;

@Column(name="service_data")
private Date servicedata;
@Column(name="test_result_date")
private Date testresultdate;
@Column(name="diag_1_actual_value")
private String actualvalue1;
@Column(name="diag_1_normal_range")
private String normalrange1;
@Column(name="diag_2_actual_value")
private String actualvalue2;
@Column(name="diag_2_normal_range")
private String normalrange2;
@Column(name="diag_3_actual_value")
private String actualvalue3;
@Column(name="diag_3_normal_range")
private String normalrenge3;
@Column(name="diag_4_actual_value")
private String actualvalue4;

@Column(name="diag_4_normal_range")
private String normalrenge4;
@Column(name="doctors_comments")
private String doctorcomments;
@Column(name="other_info")
private String otherinfo;
@Column(name="dapprove_status")
private String status;

/**
 * @return the status
 */
public String getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}
public int getId() {
                return id;
}
public void setId(int id) {
                this.id = id;
}

public String getActualvalue1() {
                return actualvalue1;
}
public void setActualvalue1(String actualvalue1) {
                this.actualvalue1 = actualvalue1;
}
public String getNormalrange1() {
                return normalrange1;
}
public void setNormalrange1(String normalrange1) {
                this.normalrange1 = normalrange1;
}
public String getActualvalue2() {
                return actualvalue2;
}
public void setActualvalue2(String actualvalue2) {
                this.actualvalue2 = actualvalue2;
}
public String getNormalrange2() {
                return normalrange2;
}
public void setNormalrange2(String normalrange2) {
                this.normalrange2 = normalrange2;
}
public String getActualvalue3() {
                return actualvalue3;
}
public void setActualvalue3(String actualvalue3) {
                this.actualvalue3 = actualvalue3;
}
public String getNormalrenge3() {
                return normalrenge3;
}
public void setNormalrenge3(String normalrenge3) {
                this.normalrenge3 = normalrenge3;
}
public String getActualvalue4() {
                return actualvalue4;
}
public void setActualvalue4(String actualvalue4) {
                this.actualvalue4 = actualvalue4;
}

public String getNormalrenge4() {
                return normalrenge4;
}
public void setNormalrenge4(String normalrenge4) {
                this.normalrenge4 = normalrenge4;
}
public String getDoctorcomments() {
                return doctorcomments;
}
public void setDoctorcomments(String doctorcomments) {
                this.doctorcomments = doctorcomments;
}
public String getOtherinfo() {
                return otherinfo;
}
public void setOtherinfo(String otherinfo) {
                this.otherinfo = otherinfo;
}


public int getCusid() {
	return cusid;
}
public void setCusid(int cusid) {
	this.cusid = cusid;
}
public int getDocid() {
	return docid;
}
public void setDocid(int docid) {
	this.docid = docid;
}
public int getMedid() {
	return medid;
}
public void setMedid(int medid) {
	this.medid = medid;
}






/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Report [id=" + id + ", cusid=" + cusid + ", docid=" + docid + ", medid=" + medid + ", servicedata="
			+ servicedata + ", testresultdate=" + testresultdate + ", actualvalue1=" + actualvalue1 + ", normalrange1="
			+ normalrange1 + ", actualvalue2=" + actualvalue2 + ", normalrange2=" + normalrange2 + ", actualvalue3="
			+ actualvalue3 + ", normalrenge3=" + normalrenge3 + ", actualvalue4=" + actualvalue4 + ", normalrenge4="
			+ normalrenge4 + ", doctorcomments=" + doctorcomments + ", otherinfo=" + otherinfo + ", status=" + status
			+ ", patientList=" + patientList + "]";
}
/**
 * @return the servicedata
 */
public Date getServicedata() {
	return servicedata;
}
/**
 * @param servicedata the servicedata to set
 */
public void setServicedata(Date servicedata) {
	this.servicedata = servicedata;
}
/**
 * @return the testresultdate
 */
public Date getTestresultdate() {
	return testresultdate;
}
/**
 * @param testresultdate the testresultdate to set
 */
public void setTestresultdate(Date testresultdate) {
	this.testresultdate = testresultdate;
}






@JsonIgnore
@ManyToMany(mappedBy = "reportList")
   private Set<Patient> patientList;
public Set<Patient> getPatientList() {
                return patientList;
}
public void setPatientList(Set<Patient> patientList) {
                this.patientList = patientList;
}


}



