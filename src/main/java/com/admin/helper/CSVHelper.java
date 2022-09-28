package com.admin.helper;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.admin.model.PatientDetails;


public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = {  "address", "dob", "drugId","drugName","emailId","patientName","phoneNumber" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
    	
      return false;
    }
System.out.println("true");
    return true;
  }

  public static List<PatientDetails> csvToTutorials(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    		
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
    
      List<PatientDetails> tutorials = new ArrayList<PatientDetails>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
    	  PatientDetails tutorial = new PatientDetails(
             // Integer.parseInt(csvRecord.get("id")),
    			 
              csvRecord.get("address"),
              csvRecord.get("dob"),
              csvRecord.get("drugId"),
              csvRecord.get("drugName"),
              csvRecord.get("emailId"),
              csvRecord.get("patientName"),
              csvRecord.get("phoneNumber")
              
              
            );

        tutorials.add(tutorial);
        System.out.println(tutorial);
      }

      return tutorials;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream tutorialsToCSV(List<PatientDetails> tutorials) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (PatientDetails tutorial : tutorials) {
        List<String> data = Arrays.asList(
           
           //  String.valueOf(tutorial.getId()),
            
           
             tutorial.getAddress(),
             tutorial.getDob(),
             tutorial.getEmailId(),
             tutorial.getDrugId(),
             tutorial.getDrugName(),
             tutorial.getPatientName(),
             tutorial.getPhoneNumber());
        

        csvPrinter.printRecord(data);
        
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }

}