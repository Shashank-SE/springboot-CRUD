package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.entities.Employee;
import com.crud.services.EmployeeServices;



@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeServices employeeServices;
	
	 @PostMapping("/save")
	 public Employee save(@RequestBody Employee e) {
		 return employeeServices.saveEmployee(e);
	 }
	 
	 @GetMapping("/find-by-id/{id}")
	 Employee getMethod(@PathVariable("id") Integer id) {
		 return employeeServices.getEmployee(id);
	 }
	 
	 @GetMapping("/findAll")
	 List<Employee> findAll() {
		 return employeeServices.findAll();
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 String delete(@PathVariable("id") Integer id) {
		 employeeServices.delEmployee(id);
		 return "Employee details is deleted successfully";
	 }
	 
	 @PutMapping("/update/{id}")
	 public Employee update(@PathVariable("id") Integer id, @RequestBody Employee updatedEmployee) {
		 return employeeServices.updateEmployee(id, updatedEmployee);
	 }
}
