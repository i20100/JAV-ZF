package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleScanner {


	public static void main(String[] args) {
		System.out.println("Tell me your name:");

		Scanner scanner = new Scanner(System.in);

		String name = scanner.nextLine();

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

		if (age < 18) {
			System.out.println("Your minor.");
		}
		else System.out.println("Your adult.");
	}

}
