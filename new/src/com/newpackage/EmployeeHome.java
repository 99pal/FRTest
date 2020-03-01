package com.newpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is the implementation class contains all the implementation part
 * 
 * @author Abhishek .
 */
public class EmployeeHome implements EmployeeMethods {
	private int count = 10;
	// this counter variable is used to count the loop iterations.
	private List<Employee> listOfEmployee;
	Employee emp;
	List<Employee> sameDOBList = null;

	public EmployeeHome() {
		emp = new Employee();
		listOfEmployee = new ArrayList<Employee>();
		sameDOBList = new ArrayList<Employee>();
		this.record();
	}

	/**
	 * this method contain all the list of members.
	 */
	public void record() {
		listOfEmployee.add(new Employee(1, "abhishek", LocalDate.of(1996, 10, 04)));
		listOfEmployee.add(new Employee(2, "himanshu", LocalDate.of(1987, 02, 25)));
		listOfEmployee.add(new Employee(3, "neeraj", LocalDate.of(1986, 05, 13)));
		listOfEmployee.add(new Employee(4, "sandeep", LocalDate.of(1993, 9, 01)));
		listOfEmployee.add(new Employee(5, "manish", LocalDate.of(1992, 8, 24)));
		listOfEmployee.add(new Employee(6, "sumit", LocalDate.of(1987, 12, 04)));
		listOfEmployee.add(new Employee(7, "deepander", LocalDate.of(1997, 10, 18)));
		listOfEmployee.add(new Employee(8, "mohit", LocalDate.of(1994, 03, 05)));
		listOfEmployee.add(new Employee(9, "hema", LocalDate.of(1992, 06, 25)));
		listOfEmployee.add(new Employee(10, "monika", LocalDate.of(1996, 10, 04)));
	}

	@Override
	public Employee searchEmployee(String name, LocalDate date) {
		int indexOfEmp = listOfEmployee.indexOf(new Employee(name, date));
		if (indexOfEmp == -1) {
			return null;
		} else {
			emp = listOfEmployee.get(indexOfEmp);
			return emp;
		}
	}

	@Override
	public boolean addEmpl(String name, LocalDate date) {
		boolean flag = listOfEmployee.add(new Employee(count++, name, date));
		return flag;
	}

	@Override
	public List<Employee> sameDobEmployee(LocalDate date) {
		for (Employee currEmp : listOfEmployee) {
			if (currEmp.dob.equals(date)) {
				sameDOBList.add(currEmp);
			}
		}
		return sameDOBList;

	}

	@Override
	public boolean deleteEmployee(int id) {
		if(id<listOfEmployee.size()-1) {
			Employee e = listOfEmployee.remove(id);
			if (!(e == null)) {
				return true;
			} else {
				return false;
			}
		}else {
		return false;
		}
	}
	public Employee deletedWithID(int id) {
		if(id>listOfEmployee.size()) {
		return null;
		}else {
		Employee delEmp=listOfEmployee.get(id);
		return delEmp;
		}
	}
	public void sortByName(int sortAnswer) {
		Collections.sort(listOfEmployee);
		if(sortAnswer==1) {
			Collections.sort(listOfEmployee);
			listOfEmployee.forEach((action)->System.out.println(action));
		}else {
			Collections.reverse(listOfEmployee);
			listOfEmployee.forEach((action)->System.out.println(action));
		}
	}
	public void sortByDate() {
		EmployeeDOBSorting empDOBSort=new EmployeeDOBSorting();
		Collections.sort(listOfEmployee,empDOBSort);
		listOfEmployee.forEach((action)->System.out.println(action));
	}
}
