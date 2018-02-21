package mod226;

import java.util.Random;

public class L03_Aufg1c_X0_Algorythmus2 {

	/* Algorythmus 2 - Version 2
	Die Methode generateDokument (a, b) erzeugt einen String mit einer zufälligen 
	Anzahl X (1-4) verteilt zwischen 0. Optionen (x, y) x = Anzahl Zeilen; 
	y = Anzahl Stellen (min. 8) */

	public static void main(String[] args) {
		System.out.println(generateDokument(5, 12));
	}

	public static String generateDokument(int anzahlZeilen, int anzahlZeichen){

		String dokument="";
		for (int i = 0; i < anzahlZeilen; i++) {
			String z=generateRow(anzahlZeichen);
			dokument = dokument + z + "\r\n";
		}
		return dokument;
	}

	public static String generateRow(int length) {
		// Zufallszahl gemäss Aufgabe => Random-Generator
		String text="";

		Random  ZUFALL  = new Random();
		int anzahlX = ZUFALL.nextInt(4)+ 1;

		// X0-Algorythmus Schleifen => X0-Generator
		for (int w = anzahlX; w > 0; w--) {
			text = text + "X";
			for (int i = anzahlX; i-1 < 4; i++) {
				text=text + "0";
			}
		}		

		// Nullfüller => 0-Generator
		length = length - text.length();
		for (int i = 0; i < length; i++) {
			text = text + "0";
		}

		return text;
	} // Ende Zeilenloop
}