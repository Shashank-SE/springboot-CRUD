package com.crud.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.entities.Employee;
import com.crud.repository.EmployeeRepository;

@Service
public class EmpServiceImpl implements EmployeeServices{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee saveEmployee(Employee e) {
		 Employee s = employeeRepo.save(e);
	        return s;
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepo.findAll();
	}

	
	@Override
	public Employee delEmployee(int id) {
		 Optional<Employee> emp = employeeRepo.findById(id);
	        if (emp.isPresent()) {
	            Employee e = emp.get();
	            employeeRepo.delete(e);
	        }
	        return null;
	}

	@Override
	public Employee updateEmployee(int id, Employee updatedEmployee) {
		Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());
            return employeeRepo.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }
}
