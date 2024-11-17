package com.crud.services;

import java.util.List;

import com.crud.entities.Employee;

public interface EmployeeServices {

	Employee saveEmployee(Employee e);
	
	Employee getEmployee(int id);
	
	List<Employee> findAll();
	
	Employee delEmployee(int id);
	
	Employee updateEmployee(int id, Employee updatedEmployee);
	

}
