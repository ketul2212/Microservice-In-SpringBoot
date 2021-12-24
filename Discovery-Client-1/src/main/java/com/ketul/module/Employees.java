package com.ketul.module;

import java.util.ArrayList;
import java.util.List;

public class Employees {

	private List<Employee> listEmployee;
	
	public Employees() {
		super();
	}

	public Employees(List<Employee> listEmployee) {
		super();
		this.listEmployee = listEmployee;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

	@Override
	public String toString() {
		return "Employees [listEmployee=" + listEmployee + "]";
	}

	
}

