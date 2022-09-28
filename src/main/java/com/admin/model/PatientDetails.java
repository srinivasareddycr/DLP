package com.admin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String patientName;
	private String address;
	private String dob;
	private String  emailId;
	private String phoneNumber;
	private String drugId;
	private String drugName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDrugId() {
		return drugId;
	}
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public PatientDetails(Integer id, String patientName, String address, String dob, String emailId, String phoneNumber,
			String drugId, String drugName) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.address = address;
		this.dob = dob;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.drugId = drugId;
		this.drugName = drugName;
	}
	public PatientDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "PatientDetails [id=" + id + ", patientName=" + patientName + ", address=" + address + ", dob=" + dob
				+ ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", drugId=" + drugId + ", drugName="
				+ drugName + "]";
	}
	
	
}
