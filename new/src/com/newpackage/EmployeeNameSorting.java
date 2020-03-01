package com.newpackage;

import java.util.Comparator;

/**
 * This class is helps in sorting list on the basis of EmployeeName. This class
 * implements @comparator class.
 * 
 * @author Abhishek
 *
 */
public class EmployeeNameSorting implements Comparator<Employee> {

	/**
	 * TODO modify this to sort z-a
	 * {@inheritDoc}
	 */
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.name.compareTo(o2.name);
	}
public int compareAtoZ(Employee o1,Employee o2) {
	
}
}
