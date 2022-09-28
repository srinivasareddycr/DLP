package com.admin.services;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.admin.helper.CSVHelper;
import com.admin.model.PatientDetails;
import com.admin.repository.PatientDetailsRepository;


@Service
public class CSVService {
  @Autowired
  PatientDetailsRepository repository;

  public void save(MultipartFile file) {
    try {
    	
      List<PatientDetails> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      
      repository.saveAll(tutorials);
     
    } catch (IOException e) {
    	System.out.println(e.getMessage());
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
      
    }
  }

  public ByteArrayInputStream load() {
    List<PatientDetails> tutorials = repository.findAll();

    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
    return in;
  }

  public List<PatientDetails> getAllTutorials() {
    return repository.findAll();
  }
}