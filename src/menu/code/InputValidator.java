package code;

import java.util.Scanner;

class InputValidator {
	private Scanner input;
	public InputValidator() {
	    this.input = new Scanner(System.in);
	}

	public int getValidInt(String prompt) {
	    int choice = -1;
	    while (choice < 0) {
	        System.out.println(prompt);
	        try {
	            choice = Integer.parseInt(input.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	        }
	    }
	    return choice;
	}

	public double getValidDouble(String prompt) {
	    double number = -1;
	    while (number < 0) {
	        System.out.println(prompt);
	        try {
	            number = Double.parseDouble(input.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid number.");
	        }
	    }
	    return number;
	}

	public String getValidString(String prompt) {
	    String inputString = "";
	    while (inputString.isEmpty()) {
	        System.out.println(prompt);
	        inputString = input.nextLine().trim();
	        if (inputString.isEmpty()) {
	            System.out.println("Invalid input. Please enter a valid string.");
	        }
	    }
	    return inputString;
	}


}
