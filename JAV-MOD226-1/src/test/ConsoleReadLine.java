package test;

// package test; this is needed for testing in another folder without help of eclipse with creating the .jar when testing it manually via CMD

import java.io.Console;

/** Experiment using System.console.readLine() to get user input
 * @author Vincent
 * This is the basis for creating a JUnit test to work around the issue that System.console methods can't be run live in the IDE console.
 */
public class ConsoleReadLine {

	private static String userInput;
	Console console = System.console();

	/* This code needs to go into either the constructor or the get method:
	public static void main(String[] args) {
		Console console = System.console();
		
		if (console == null) {
			System.out.println("No console: non-interactive mode!");
			System.exit(0);
		}
		userInput = console.readLine();
	}
	*/

	/**
	 * @return the userInput
	 */
	public static String getUserInput() {
		return userInput;
	}

	@SuppressWarnings("static-access")
	public void setUserInput(String string) {
		this.userInput = string;
	}

}

//This is how it was tested manually using CLI via CMD
//public static void main(String[] args) {
//	Console console = System.console();
//
//	if (console == null) {
//		System.out.println("No console: non-interactive mode!");
//		System.exit(0);
//	}
//	System.out.print("Text entered will be stored. Get text by calling getUserInput() Enter text now: ");
//	userInput = console.readLine();
//	System.out.println("Calling getUserInput() now:");
//	System.out.print(getUserInput());
//}
