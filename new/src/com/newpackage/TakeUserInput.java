package com.newpackage;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TakeUserInput {
	//Reference object to read user input.
	private Scanner readinput;
	//To check loop input used inside showDisplayMenu method.
	private String loopInput;
	//To check count on Employee
	private int count = 10;
	//Used for taking Employee name and DOB in String.
	private String empName,year,month,day;
	//Return integer variable of String variable taken above in String format.
	private int returnYear = 0,returnMonth = 0,returnDay = 0;
	//Used inside while loop for repetitive loop until flag turn false.
	private boolean flag = true;

	/**
	 * Constructor for initialization.
	 */
	public TakeUserInput() {
		readinput = new Scanner(System.in);
	}
	//Reference object of @ValidateEmployee class.
	ValidateEmployee validateEmp = new ValidateEmployee();
	//Reference object of @Employee class.
	EmployeeHome empHome = new EmployeeHome();

	/**
	 * This method will display choice to perform certain action
	 */
	public void displayMenu() {
		System.out.println("enter your choice");
		System.out.println("press 1:search employee");
		System.out.println("press 2:Add Employee");
		System.out.println("press 3:Delete an Employee");
		System.out.println("press 4:Serach same DOB Employee");
		System.out.println("press 5: TO sort by name");
		System.out.println("press 6:To sort by DOB");
		// taking input for switch case.
		int n = readinput.nextInt();

		switch (n) {
		// This case to search the employee in database
		case 1:
			// This part of code is responsible for registering name.
			System.out.print("Enter Employee Name:");
			empName = readinput.next();
			boolean returnEmpName = validateEmp.isValidateName(empName);
			while (!returnEmpName) {
				System.out.println("Enter a valid name:");
				empName = readinput.next();
				returnEmpName = validateEmp.isValidateName(empName);
			}
			System.out.println("Enter DOB");
			// This part of code is responsible for registering year.
			System.out.print("Enter year in yyyy format: ");
			while (flag) {
				year = readinput.next();
				returnYear = validateEmp.isValidateYear(year);
				if (returnYear == 0) {
					System.out.println("Enter valid year: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// This part of code is responsible for registering month.
			System.out.print("Enter Month in MM format:");
			while (flag) {
				month = readinput.next();
				returnMonth = validateEmp.isValidateMonth(month);
				if (returnMonth == 0) {
					System.out.println("Enter valid month: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// This part of code is responsible for registering day.
			System.out.print("Enter day in DD format:");
			while (flag) {
				day = readinput.next();
				returnDay = validateEmp.isValidateDay(day, returnMonth, returnYear);
				if (returnDay == 0) {
					System.out.println("Enter valid day: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// From here the searching of Employee process will start.
			Employee searchRecord = empHome.searchEmployee(empName, LocalDate.of(returnYear, returnMonth, returnDay));
			System.out.println("Employee is: " + searchRecord);
			showDisplayMenu();
			break;
			//This case will Add Employee in list.
		case 2:
			// This part of code is responsible for registering name.
			System.out.print("Enter Employee Name:");
			empName = readinput.next();
			boolean returnAddEmp = validateEmp.isValidateName(empName);
			while (!returnAddEmp) {
				System.out.println("Enter a valid name:");
				empName = readinput.next();
				returnEmpName = validateEmp.isValidateName(empName);
			}
			System.out.println("Enter DOB");
			// This part of code is responsible for registering year.
			System.out.print("Enter year in yyyy format: ");
			while (flag) {
				year = readinput.next();
				returnYear = validateEmp.isValidateYear(year);
				if (returnYear == 0) {
					System.out.println("Enter valid year: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// This part of code is responsible for registering month.
			System.out.print("Enter Month in MM format:");
			while (flag) {
				month = readinput.next();
				returnMonth = validateEmp.isValidateMonth(month);
				if (returnMonth == 0) {
					System.out.println("Enter valid month: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// This part of code is responsible for registering day.
			System.out.print("Enter day in DD format:");
			while (flag) {
				day = readinput.next();
				returnDay = validateEmp.isValidateDay(day, returnMonth, returnYear);
				if (returnDay == 0) {
					System.out.println("Enter valid day: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// This part of code help in searching Employee is already Exist.
			Employee searchEmply = empHome.searchEmployee(empName, LocalDate.of(returnYear, returnMonth, returnDay));
			// From here the Adding of Employee process will start.
			if (searchEmply == null) {
				boolean addEmployee = empHome.addEmpl(empName, LocalDate.of(returnYear, returnMonth, returnDay));
				if (addEmployee) {
					System.out.println("Employee is Added :" + addEmployee);
					++count;
					System.out.println("Total Employee in List are " + count + ".");
				}
			} else {
				System.out.println("User already present in List.");
			}
			showDisplayMenu();
			break;
			//This case will help Deleting Employee.
		case 3:
			System.out.print("Enter Employee ID:");
			while(flag) {
				String idStringInput=readinput.next();
				int idInput=validateEmp.checkID(idStringInput);
				if(idInput>0) {
				Employee deleteEmp=empHome.deletedWithID(idInput);
				if(deleteEmp==null) {
					flag=true;
					System.out.println("Enter correct Employee ID:");
				}else {
					System.out.println(deleteEmp);
					System.out.println("Do you Really Want to Delete Y/N?:");
					String delInput=readinput.next();
					if(delInput.equalsIgnoreCase("y")) {
				boolean deleteFlag = empHome.deleteEmployee(idInput);
				if (deleteFlag) {
					System.out.println("Employee Deleted successfully");
					--count;
					System.out.println("Now list has "+count+" Employee.");
					flag=false;
				}}else if(delInput.equalsIgnoreCase("N")){
					System.out.println("Enter ID to Search Again:");
				}
				}
			}
			else {
				flag=true;
				System.out.print("Enter valid ID:");
			}
			}
			flag=true;
			showDisplayMenu();
			break;
			//This case will in searching Same date Employee.
		case 4:
			System.out.println("Enter DOB");
			// This part of code is responsible for registering year.
			System.out.print("Enter year in yyyy format: ");
			while (flag) {
				year = readinput.next();
				returnYear = validateEmp.isValidateYear(year);
				if (returnYear == 0) {
					System.out.println("Enter valid year: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// This part of code is responsible for registering month.
			System.out.print("Enter Month in MM format:");
			while (flag) {
				month = readinput.next();
				returnMonth = validateEmp.isValidateMonth(month);
				if (returnMonth == 0) {
					System.out.println("Enter valid month: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// This part of code is responsible for registering day.
			System.out.print("Enter day in DD format:");
			while (flag) {
				day = readinput.next();
				returnDay = validateEmp.isValidateDay(day, returnMonth, returnYear);
				if (returnDay == 0) {
					System.out.println("Enter valid day: ");
				} else {
					flag = false;
				}
			}
			flag = true;
			// From here the searching of Employee process will start.
			List<Employee> sameDOBResult = empHome.sameDobEmployee(LocalDate.of(returnYear, returnMonth, returnDay));
			sameDOBResult.forEach((action)->System.out.println(action));
			showDisplayMenu();
			break;
			//This 
		case 5:
			System.out.println("Enter 1 to sort as A-z:");
			System.out.println("Enter 2 to sort as Z-a:");
			System.out.print("Here:");
			int sortAnswer=readinput.nextInt();
			empHome.sortByName(sortAnswer);
			showDisplayMenu();
			break;
		case 6:
			empHome.sortByDate();
			showDisplayMenu();
			break;
		}
	}

	/**
	 * This method will check user input whether user wants to perform operation
	 * again or not. If he press "y" he will see @displayMenu again. If he press "N"
	 * he will be terminated from program right away. Here we also check from
	 * invalid option if he press anything other than "y" or "n".
	 */
	public void showDisplayMenu() {
		System.out.print("ENTER Y/N IF YOU WANT TO SEE MENU AGAIN:");
		loopInput = readinput.next();
		while (true) {
			// This loop is used when user type "Exit" at any point of program.
			if (loopInput.equalsIgnoreCase("exit")) {
				System.out.println("==++==GOODBYE==++==");
				System.exit(0);
			} else if (loopInput.equalsIgnoreCase("Y")) {
				displayMenu();
			}
			// this loop is to repeat the whole process again and again
			// until user user enter "N" in the console.
			else if (loopInput.equalsIgnoreCase("N")) {
				System.out.println("======THANK YOU======");
				break;
			}
			// here checking if user is entering anything other than "y" or "n".
			else {
				System.out.println("INVALID OPTION");
				System.out.println("PLEASE ENTER Y/N");
				loopInput = readinput.next();
			}

		}
	}
}
