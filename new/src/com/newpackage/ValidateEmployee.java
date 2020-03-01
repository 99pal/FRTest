package com.newpackage;

/**
 * This class will help in validating the name and DOB taken from user as an
 * input.
 * 
 * @name is the name of the employee passed for validation.
 * @DOB of the employee entered by the user.
 * @author Abhishek
 *
 */
public class ValidateEmployee {

	/**
	 * This is a method helps in validating name this method will check for any
	 * special character or number in a string,if found ask you to enter the String
	 * again. also return a value.
	 * 
	 * @param name will take employee name to validate.
	 * @return will return <true>or<false> is name is valid.
	 */
	public boolean isValidateName(String name) {
		boolean isValidName = true;
		if (!(name.matches("[a-zA-Z]+"))) {
			isValidName = false;
		}
		if (name.length() < 3) {
			isValidName = false;
		}
		return isValidName;
	}

	/**
	 * This method will validate the year entered by the user also check is date
	 * smaller than the present year.
	 * 
	 * @param year This is year input by user for validation.
	 * @return This method will return true if year entered is correct else false.
	 */
	public int isValidateYear(String year) {
		int returnYear = 0;
		boolean flag = true;
		while (flag) {
			if (!(year.matches("[0-9]+"))) {
				returnYear = 0;
				break;
			}
			flag = false;
			int newYear = Integer.parseInt(year);
			returnYear = newYear;
			if (newYear > 2020) {
				returnYear = 0;
			}
		}
		return returnYear;
	}

	/**
	 * This class will help in validating the month checking if input month is not
	 * more than 12
	 * 
	 * @param month will take month as user input.
	 * @return will return month in integer format.
	 */
	public int isValidateMonth(String month) {
		int returnMonth;
		if (!(month.matches("[0-9]+"))) {
			returnMonth = 0;
		}
		int newMonth = Integer.parseInt(month);
		returnMonth = newMonth;
		if (newMonth > 12) {
			returnMonth = 0;
		}
		return returnMonth;

	}

	/**
	 * This method will take day as user input in String form and check if don't
	 * contain anything other than integer.
	 * 
	 * @param day   is an user input.
	 * @param month automatically retrieve month from last input.
	 * @param year  automatically retrieve year from last input.
	 * @return it will return an integer value of day.
	 */
	public int isValidateDay(String day, int month, int year) {
		int returnDay;
		if (!(day.matches("[0-9]+"))) {
			returnDay = 0;
		}
		int newDay = Integer.parseInt(day);
		returnDay = newDay;
		if (month == 02) {
			boolean leapCheck = checkLeapYear(year);
			if (leapCheck && newDay >= 30) {
				returnDay = 0;
			} else if (!leapCheck && newDay >= 29) {
				returnDay = 0;
			}
			return returnDay;
		}

		return returnDay;

	}

	/**
	 * This part of code is to check the day if date is valid or not if the month
	 * is<February>or<02> then it will check for whether the year is leap year or
	 * not.If entered year is leap year it will not take days more than 29 and if
	 * year is not a leap year it wont take days more than 28.
	 */
	private boolean checkLeapYear(int year) {
		boolean flag;
		if (year % 400 == 0) {
			flag = true;
		} else if (year % 100 == 0) {
			flag = false;
		} else if (year % 4 == 0) {
			flag = true;
		} else

		{
			flag = false;
		}
		return flag;
	}

	/**
	 * This method will help in validating the ID entered by user whether enter
	 * input is correct or not.If it contain alphabets or special character it will
	 * return<zero> and if entered correct input it will return parsed id in
	 * Integer.
	 * 
	 * @param idInput it is String input entered by user.
	 * @return it will return an integer.
	 */
	public int checkID(String idInput) {
		int returnID = 0;
		if (idInput.matches("[0-9]+")) {
			returnID = Integer.parseInt(idInput);
			return returnID;
		} else {
			return returnID;
		}
	}
}
