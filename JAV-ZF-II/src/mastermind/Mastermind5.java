package mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mastermind5 {

	static int[] code = {1, 1, 4, 2}; // Init Variable Code
	static int[] tip = {0, 0, 0, 0}; // Variable für Benutzer Tipp
	static int zaehler = 0; // Variable für Anzahl Versuch
	static int versuche = 3; // Anzahl Versuche festlegen

	public static void main(String[] args) {
		/* Spiel Masterminds
		Spielcode: aus 6 möglichen Farben (Zahlen 1-6) werden 4 ausgewählt.
		Spieler gibt aus diesen 6 Möglichkeiten eine beliebige Kombination ein.
		Spiel wertet Tipp aus und gibt Anzahl verbleibende Tipps an.*/

		// Spielbeginn		
		System.out.println("Willkommen bei Masterminds"+"\n");

		// Generierung Code (Geheimzahl)
		String geheimCode = generateCode(6,4);
		code = new int[geheimCode.length()];
		for (int i = 0; i < geheimCode.length(); i++) {
			// Hack Integer.decode erwartet String via "" + Char wird String
			code[i] = Integer.decode("" + geheimCode.charAt(i));
		}
		do {
			// User Eingabe Abfrage via Scanner
			tipUser(tip);

			// Auswertung User Eingabe
			System.out.println("Ihr Tip lautet: " + Arrays.toString(tip));
			System.out.println("Anzahl richtige Zahlen ohne Betrachtung der Position: " + berechneAnrRichtigeOhnePos(tip));
			System.out.println("Anzahl mit richtiger Position: " + berechneAnzRichtiePosition(tip));

			// Nur für Fehlersuche Kommentar entfernen 
//			System.out.println(Arrays.toString(tip)); // old before tip was converted to String
			System.out.println("geheimCode ist: " + geheimCode);
			System.out.println("code is:" + code);
			System.out.println("typToString is: " + tipToString(tip));
			System.out.println("Arrays.toString(tip) is: " + Arrays.toString(tip));

			// Spiel Ende Code geknackt
			// TODO aks Kurt how to check for tip == code and zaehler < versuche at the same time?
		} while (tipToString(tip) != geheimCode && zaehler < versuche);
		if (tipToString(tip) == geheimCode) {
			System.out.println("Glückwunsch Sie sind ein Mastermind!!");
		}
		// TODO neustart einfügen mit Abfrage J/N
		System.out.println("Sie haben den Code nicht geknackt. Das Spiel wird neu gestartet...");

	}

	/***
	 * Tip Benutzer abfragen und Anzahl Versuche festhalten
	 * @param tip
	 */
	public static void tipUser(int[] tip) {
		System.out.println("Bitte geben Sie vier Zahlen zwischen 1-6 nach einander ein. Jede Zahl gefolgt von Enter.");
		// TODO Zahleneingabe ohne Enter nach jeder Zahl ermöglichen
		// TODO close reader
		Scanner reader = new Scanner(System.in);
		for (int i = 0; i < tip.length; i++) {
			tip[i] = reader.nextInt();
		}
		zaehler = zaehler + 1; 
		System.out.println("Danke für den " + zaehler + ". Tip. Sie haben noch " + (versuche-zaehler) + " versuche übrig.");
	}

	static String tipToString(int[] tip) {
		String tipBecomesString = "";
		for (int i = 0; i < tip.length; i++) {
			tipBecomesString = tipBecomesString + Integer.toString(tip[i]);
			
		}
		return tipBecomesString;
	}
	
	/***
	 * Berechnet die Anzahl der erratenen Zahlen aus dem Geheimcode ohne die 
	 * Position der Zahlen zu berücksichtigen 
	 * @param tip
	 * @return int Anzahl erratene/vorhandene Zahlen
	 */
	public static int berechneAnrRichtigeOhnePos(int[] tip) {
		// *Exit bei Treffer, damit jede Zahl nur einmal gezählt wird.
		int anzRichtige = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tip[i] == code[j]) {
					anzRichtige = anzRichtige + 1;
					j = 4; // => Exit bei Treffer
				} anzRichtige = anzRichtige + 0;
			}
		}
		return anzRichtige;
	}

	/**
	 * Berechnet die Anzahl der erratenen Zahlen auf der richtigen Position
	 * @param tip
	 * @return int Anzahl Zahlen Position richtig
	 */
	public static int berechneAnzRichtiePosition(int[] tip) {
		int anzRichtige = 0;
		for (int i = 0; i < 4; i++) {
			//			System.out.println("test");
			if (tip[i] == code[i]) {
				anzRichtige = anzRichtige + 1;
			} 
			//			anzRichtige = anzRichtige + 0;
		}
		return anzRichtige;
	}

	/**
	 * Geheimcode aus Zufallszahlen erstellen
	 * @param moeglicheZahlen
	 * @param anzahlStellen
	 * @return String bestehend aus den einzelnen Zufallszahlen
	 */
	public static String generateCode(int moeglicheZahlen, int anzahlStellen) {
		String code = "";
		//	anzahlStellen Schleife
		for (int i = 0; i < anzahlStellen; i++) {
			String zufallsZahl=generateZufallszahl(moeglicheZahlen);
			code = code + zufallsZahl;
		}
		return code;
	}

	/**
	 * Submethode von generateCode, erstellt eine Zufallzahl
	 * @param mZ
	 * @return String einer Zufallszahl
	 */
	public static String generateZufallszahl(int mZ) {
		//		Zufallszahl bestimmer
		Random  ZUFALL  = new Random();
		int zahlX = ZUFALL.nextInt(mZ)+ 1;
		String convZahlX = String.valueOf(zahlX);
		return convZahlX;
	}
}