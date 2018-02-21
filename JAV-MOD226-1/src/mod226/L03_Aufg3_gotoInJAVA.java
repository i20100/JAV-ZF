package mod226;

import java.util.Scanner;

public class L03_Aufg3_gotoInJAVA {

	public static void main(String[] args) {
		// Beispiel einfacher goto Befehl in JAVA
		// Quelle: http://stackoverflow.com/questions/18604169/how-to-go-back-to-a-specific-line-in-java
		
		Startitz: while (true) {
		    // Do something useful here...
			System.out.println("Start");
		    System.out.println("Do you want to continue? Y/N");
		    // Get input here.
		    
	
			
		    Scanner reader = new Scanner(System.in);
		    char c = reader.next().charAt(0);
			
		    if (c=='Y') {
		        continue Startitz;
		    } else {
		       System.out.println("Goodbye!");
		       break;
		    }
		}

	}

}
