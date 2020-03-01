package com.newpackage;

import java.time.LocalDate;

/**
 * This class contain all the relevant data of Employee Two separate constructor
 * has been made in this class in order to search the employee on basis of
 * object content.
 * 
 * @author Abhishek
 */
public class Employee implements Comparable<Employee>{

	int id; // it represent the ID of Employee.
	String name; // it represent the name of Employee.
	LocalDate dob; // it represent the DATE OF BIRTH of Employee.
public Employee() {}
	public Employee(int id) {
		super();
		this.id = id;
	}

	public Employee(LocalDate dob) {
		super();
		this.dob = dob;
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param dob
	 */
	public Employee(int id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	// constructor overloading in order search the employee
	// on bases of @name and @dob(DATE OF BIRTH).
	public Employee(String name, LocalDate dob) {
		this.name = name;
		this.dob = dob;
	}

	/*
	 * This method is used to match two objects on the bases of content inside it.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee emph = (Employee) obj;
		return name.equals(emph.name) && dob.equals(emph.dob);
	}

	/*
	 * this method is used to print the object content.
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}
}
