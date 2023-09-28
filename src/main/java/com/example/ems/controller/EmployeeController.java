package com.example.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.dto.Employee;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ems/")
public class EmployeeController {

@Autowired
EmployeeService employeeService;
	@GetMapping("/getemployees")
public ResponseEntity<List<Employee>>  getAllEmployees(){

return employeeService.getAllEmployees();

}

	
@PostMapping("/insert")
public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
{
	return employeeService.createEmployee(employee);
}
@GetMapping("/getemployees/{id}")
public ResponseEntity<Employee>  getEmployeeById(@PathVariable Long id){

return employeeService.getEmployeeById(id);

}

@PutMapping("/updateemployee/{id}")
public ResponseEntity<Employee>  updateEmployeeById(@PathVariable Long id,@RequestBody Employee employee){

return employeeService.updateEmployeeById(id,employee);

}

@DeleteMapping("/deleteemployee/{id}")
public ResponseEntity<HttpStatus>  deleteEmployeeById(@PathVariable Long id){

return employeeService.deleteEmployeeById(id);

}
}
