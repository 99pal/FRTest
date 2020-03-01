package com.newpackage;

import java.util.Comparator;

public class EmployeeDOBSorting implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o2.dob.compareTo(o1.dob);
	}

}
