package test;

import java.util.Scanner;

public class Mastermind {
	static int[] codeArray = {0, 0, 0, 0}; // Init Variable Code
	static int[] tipArray = {0, 0, 0, 0}; // Variable für Benutzer Tipp
	static int versuche = 3; // Anzahl Rateversuche um Code zu knacken
	static int zaehler = 0; // Variable um restliche Versuche zu berechnen 


	public static void main(String[] args) {
		generateCode(codeArray);
		System.out.println(arrayToString(codeArray));

		do {
			tipUser(tipArray);

			//		Evaluate User Input
			System.out.println("Anzahl richtige Zahlen ohne Betrachtung der Position: "
					+ berechneAnrRichtigeOhnePos(tipArray));
			System.out.println("Anzahl mit richtiger Position: "
					+ berechneAnzRichtiePosition(tipArray));


			//		test codeArray and tipArray, Helper for debugging
			System.out.println(arrayToString(codeArray));
			System.out.println(arrayToString(tipArray));

		} while (versuche > zaehler);
		System.out.println("Keine Versuche mehr übrig. "
				+ "Sie haben den Code nicht geknackt. "
				+ "Das Spiel ist beendet...");


	}

	/** Generates the Code (Geheimcode) which the User has to guess.
	 * @param codeArray2
	 */
	private static void generateCode(int[] codeArray2) {
		//		generate 4 numbers and write them to codeArray
		for (int i = 0; i < codeArray.length; i++) {
			double random = Math.random() * 6 + 1;
			codeArray[i] = (int)random;
		}		
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
				if (tip[i] == codeArray[j]) {
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
			if (tip[i] == codeArray[i]) {
				anzRichtige = anzRichtige + 1;
			} 
			//			anzRichtige = anzRichtige + 0;
		}
		return anzRichtige;
	}


	/** Converts any Int[] array to a single String
	 * @param array
	 * @return
	 */
	static String arrayToString(int[] array) {
		String arrayToString = "";
		for (int i = 0; i < array.length; i++) {
			arrayToString = arrayToString + Integer.toString(array[i]);
		}
		return arrayToString;
	}


	/** Aks User for his guess and gets the Userinput. 
	 * @param tipArray
	 */
	public static void tipUser(int[] tipArray) {
		System.out.println("Bitte geben Sie vier Zahlen zwischen 1-6 nach einander ein. Jede Zahl gefolgt von Enter.");
		// TODO Zahleneingabe ohne Enter nach jeder Zahl ermöglichen
		// TODO close reader
		Scanner reader = new Scanner(System.in);
		for (int i = 0; i < tipArray.length; i++) {
			tipArray[i] = reader.nextInt();
		}
		zaehler = zaehler + 1; 
		System.out.println("Danke für den " + zaehler + ". Tip. "
				+ "Sie haben noch " + (versuche-zaehler) + " versuche übrig.");
	}



	
}
