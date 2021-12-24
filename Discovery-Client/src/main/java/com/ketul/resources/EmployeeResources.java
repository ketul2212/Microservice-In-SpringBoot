package com.ketul.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ketul.module.Employee;
import com.ketul.module.dto.EmployeeDto;

@RestController
public class EmployeeResources {
	
	@GetMapping("/users")
	public EmployeeDto getEmployees() {
		
		EmployeeDto employeeDto = new EmployeeDto();
		
		List<Employee> listEmployees = new ArrayList<Employee>();
		listEmployees.add(new Employee(1 , "Ketul", "Java"));
		listEmployees.add(new Employee(2, "Sunny", "C++"));
		
		employeeDto.setListEmployees(listEmployees);
		
		return employeeDto;
	}
	
	@GetMapping("/user")
	public Employee getEmployee() {
		
		
		
		
		
		
		
		return new Employee(101, "Ketul", "Java");
	}
}
