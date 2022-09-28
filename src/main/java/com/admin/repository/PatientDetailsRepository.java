package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.PatientDetails;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer> {

}
