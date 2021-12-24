package com.ketul.module.dto;

import java.util.List;

import com.ketul.module.Employee;

public class EmployeeDto {

	private List<Employee> listEmployees;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(List<Employee> listEmployees) {
		super();
		this.listEmployees = listEmployees;
	}

	public List<Employee> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(List<Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}

	@Override
	public String toString() {
		return "EmployeeDto [listEmployees=" + listEmployees + "]";
	}
	
	
}
