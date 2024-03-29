package com.admin.model;


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
	private String emailId;
	private String phoneNumber;
	private String drugId;
	private String drugName;
	
	
	private  String status ="Inducted";
	
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public PatientDetails( String address, String dob, String drugId,String drugName,String emailId,  
			String patientName, String phoneNumber) {
		super();
		this.address = address;
		this.dob = dob;
		this.drugId = drugId;
		this.drugName = drugName;
		this.emailId = emailId;
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;

		
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
