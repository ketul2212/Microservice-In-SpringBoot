package com.ketul.module;

public class Employee2 {

	private int id;
	private String name;
	private String eTech;

	public Employee2() {
		super();
	}

	public Employee2(int id, String name, String eTech) {
		super();
		this.id = id;
		this.name = name;
		this.eTech = eTech;
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

	public String geteTech() {
		return eTech;
	}

	public void seteTech(String eTech) {
		this.eTech = eTech;
	}

	
	
	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + ", eTech=" + eTech + "]";
	}

	public boolean equals(Object object) {
		if(this == object)
			return true;
		else {
			if(object instanceof Employee2) {
				Employee2 u = (Employee2)object;
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
