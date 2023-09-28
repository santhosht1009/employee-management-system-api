package com.example.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ems.dto.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> l=employeeRepository.findAll();
		if(!l.isEmpty())
		return new ResponseEntity<>(l,HttpStatus.OK);
		else
			return null;
	}

	public ResponseEntity<Employee> createEmployee(Employee employee) {
	Employee e=	employeeRepository.save(employee);
		
		return new ResponseEntity<>(e,HttpStatus.CREATED);
	}

	public ResponseEntity<Employee> getEmployeeById(Long id) {
		Employee e=	employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id"+id));
		return new ResponseEntity<>(e,HttpStatus.OK);
	}

	public ResponseEntity<Employee> updateEmployeeById(Long id, Employee employee) {
		Employee e=	employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id"+id));
		e.setFirstname(employee.getFirstname());
		e.setLastname(employee.getLastname());
		e.setEmailId(employee.getEmailId());
		Employee ue =employeeRepository.save(e);
		
		return new ResponseEntity<>(ue,HttpStatus.OK) ;
	}

	public ResponseEntity<HttpStatus> deleteEmployeeById(Long id) {
		
		Employee e=	employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id"+id));
	employeeRepository.delete(e);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
