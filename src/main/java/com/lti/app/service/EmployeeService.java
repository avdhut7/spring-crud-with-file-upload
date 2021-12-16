package com.lti.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lti.app.pojo.Employee;
import com.lti.app.repository.EmployeeRepo;

@Service
@Transactional
public class EmployeeService 
{
	@Autowired
    private EmployeeRepo repo;
     
    public List<Employee> listAll() {
        return repo.findAll(Sort.by("email").ascending());
    }
}
