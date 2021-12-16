package com.lti.app.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lti.app.helper.ExcelHelper;
import com.lti.app.pojo.Employee;
import com.lti.app.repository.EmployeeRepo;

@Service
public class ExcelService 
{
	@Autowired
	EmployeeRepo repo;
	
	public ByteArrayInputStream load() {
	    List<Employee> tutorials = repo.findAll();

	    ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
	    return in;
	  }
	  public void save(MultipartFile file) {
		    try {
		      List<Employee> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
		      repo.saveAll(tutorials);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		  }

		  public List<Employee> getAllEmployees() {
		    return repo.findAll();
		  }
}
