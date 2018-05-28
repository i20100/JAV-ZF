package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleScanner {


	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		askUserName();
		int age = askUserAge();
		checkAge(age);
		
		scanner.close();
	}

	private static void askUserName() {
		System.out.println("Tell me your name:");
		@SuppressWarnings("unused")
		String name = scanner.nextLine();
	}

	private static int askUserAge() {
		int age = -1;
		do {
			System.out.println("Your age:");
			try {
				age  = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input for age!");
				scanner.nextLine();
			}
		} while (age < 0);
		return age;
	}

	private static void checkAge(int age) {
		if (age < 18) {
			System.out.println("Your minor.");
		}
		else System.out.println("Your adult.");
	}

}
