package mod226;

import java.util.Random;

public class L03_Aufg1c_X0_Algorythmus {

	public static void main(String[] args) {

		// X0-Algorythmus

		int anzahlX = 4; // Zahl welche später mit Funktion Random entsteht
		String text=""; // Platzhalter um X0-Generator Anzahl Zeichen zu zählen
		int zeichen = 10; // Anzahl Zeichen pro Zeile im Algorythmus
		int zeilen = 10; // Anzahl Zeilen


		// Zeilenloop => Zeilengenerator
		for (; zeilen > 0; zeilen--) {


			// Zufallszahl gemäss Aufgabe => Random-Generator
			Random  ZUFALL  = new Random();
			anzahlX = ZUFALL.nextInt(4)+ 1;

			// Beginn Print to Screen
			System.out.print("Zeile: " + zeilen + " Zufallszahl: " + anzahlX + " ");


			// XO-Algorythmus Schleifen => X0-Generator
			for (int w = anzahlX; w > 0; w--) {
				//			System.out.print("X");
				text = text + "X";
				for (int i = anzahlX; i-1 < 4; i++) {
					text=text + "0";
					//				System.out.print("0");
				}
			}		
			//		System.out.print(text);

			// Nullfüller => 0-Generator
			zeichen = zeichen - text.length();
			//		System.out.println(zeichen);
			for (;zeichen > 0; zeichen--) {
				//			System.out.print("0");
				text = text + "0";
			}

			System.out.println(text);
			text = ""; /* Reseten von Text, ask Kurt why do I need this, how 
			to realize those are missing beforehand? => Experience will help
			and proper testing. */
			zeichen = 10;
		} // Ende Zeilenloop

	}
	
	void generateDokument(){
		
		
		for (int i = 0; i < 10; i++) {
			@SuppressWarnings("unused")
			String z=generateRow(1);
		}
		
		
	}

	private String generateRow(int i) {
		return null;
	}
}