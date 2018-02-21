package mod226;

import java.util.Scanner;

public class L03_Aufg2_Scanner2 {

	public static void main(String[] args) {

		while (true) {
			
		System.out.println("Willkommen beim Spiel Mastermind");
		
		System.out.println("Geben Sie Ihren Namen ein: ");

		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();

		System.out.println("Geben Sie den Zahlenbereich für die Codeerstellung an: ");
		System.out.println("Bsp. Bei der Eingabe von 6 wird der Code aus den Zahlen 0-6 erstellt.");

		// Scanne nächste Eingabe als Zahl 
		int zahlenbereich = scanner.nextInt();

		System.out.println("Geben Sie die Anzahl Stellen des Codes ein: ");
		System.out.println("Bsp. Bei der Eingabe von 3 wird der Code aus XYZ bestehen.");

		//Scanne nächste Eingabe als Zahl 
		int stellen = scanner.nextInt();

		System.out.println("Sie haben ausgewählt: Zahlenbereich: "  
		+ zahlenbereich + ", Stellen: " + stellen);
		System.out.println("Spiel Starten? J/N?");
		
		// Scanne Startbedingung
		char antwort = scanner.next().charAt(0);
		if (antwort == 'J' || antwort == 'j') {
			// Weiter zum Spiel, jetzt nur restart
			System.out.println("Spiel wird geladen.");
			break;
		}
		else System.out.println("Spiel wird neu gestartet.");
		main(args);
		}

		// TODO close scanner
		// TODO Benutze den Namen des Spielers am Spielende!
	}		
}
