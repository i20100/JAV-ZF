package test;

import java.io.Console;

/** This Class is to experiment with the class Console and its functionality to get user input
 * @author Vincent
 * Main goal is to experiment with the way the user input can be read from the console. Since there are different ways to achive this.
 * See: http://www.codejava.net/java-se/file-io/3-ways-for-reading-input-from-the-user-in-the-console to get an idea of the ways.
 * 
 * Simpler version made under ConsoleReadLine.java, since this code example uses different methods to get the user input.
 */
public class ConsoleClass {
private static String username;

/*	Example code taken from the website:
	Console console = System.console();
	if (console == null) {
		System.out.println("No console: non-interactive mode!");
		System.exit(0);
	}
	
	System.out.print("Enter your username: ");
	String username = console.readLine();
	
	System.out.print("Enter your password: ");
	char[] password = console.readPassword();
	
	String passport = console.readLine("Enter your %d (th) passport number: ", 2);*/
	
	public static void main(String[] args) {
		
	Console console = System.console();
	if (console == null) {
	    System.out.println("No console: non-interactive mode!");
	    System.exit(0);
	}
	 
	System.out.print("Enter your username: ");
	username = console.readLine();
	 
	System.out.print("Enter your password: ");
	char[] password = console.readPassword();
	 
	String passport = console.readLine("Enter your %d (th) passport number: ", 2);
	}

	public static String getUserName() {
		return username;
	}

}
