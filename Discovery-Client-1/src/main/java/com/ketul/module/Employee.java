package com.ketul.module;

public class Employee {

	private int id;
	private String name;

	public Employee() {
		super();
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	public boolean equals(Object object) {
		if(this == object)
			return true;
		else {
			if(object instanceof Employee) {
				Employee u = (Employee)object;
				if(u.getId() == id)
					return true;
				else
					return false;
			}
			else
				return false;
		}
	}
	
	public int hashCode() {
		return id;
	}
}
