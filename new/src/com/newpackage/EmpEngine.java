package com.newpackage;

/**
 * This is the main class code start from here it has a an object
 * of @EmployeeHome which help in initializing the list records in @EmployeeHome
 * class here we are calling display menu of @EmployeeHome class
 * 
 * @author Abhishek
 */
public class EmpEngine {

	public static void main(String[] args) {
		//Object of @TakeUserInput  class to access the display method.
		TakeUserInput eh = new TakeUserInput();
		//Calling display<Method></Method> to display options.
		eh.displayMenu();
	}

}