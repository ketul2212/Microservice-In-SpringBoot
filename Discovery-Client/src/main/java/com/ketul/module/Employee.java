package com.ketul.module;


public class Employee {

	private int id;
	private String name;
	private String eTech;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, String eTech) {
		super();
		this.id = id;
		this.name = name;
		this.eTech = eTech;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteTech() {
		return eTech;
	}

	public void seteTech(String eTech) {
		this.eTech = eTech;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", eTech=" + eTech + "]";
	}
}
