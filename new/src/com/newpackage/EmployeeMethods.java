package com.newpackage;

import java.time.LocalDate;
import java.util.List;

/**
 * It is an interface that contains all the methods used in the @EmpHome class.
 * 
 * @author Abhishek
 */
public interface EmployeeMethods {

	/**
	 * this is a dummy method and helps in finding Employee
	 */
	public Employee searchEmployee(String name,LocalDate date);

	/**
	 * this is a dummy method and helps in adding Employee
	 */
	public boolean addEmpl(String name,LocalDate date);

	/**
	 * This is a dummy method and helps in finding Employee with same Date of Birth
	 */
	public List<Employee> sameDobEmployee(LocalDate date);

	/**
	 * this is a dummy method and helps in deleting Employee
	 */
	public boolean deleteEmployee(int id);
}
