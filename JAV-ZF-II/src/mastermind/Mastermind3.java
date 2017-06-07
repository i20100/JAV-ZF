package mastermind;

import java.util.Random;

public class Mastermind3 {

	static int[] code = {1, 1, 4, 2};

	public static void main(String[] args) {
		// Code besteht aus 6 möglichn Farben wurden 4 ausgewählt.
		// Tip Spieler besteht aus 6 möglichen Zahlen wurden 4 ausgewählt.

		
		String geheimCode = generateCode(6,4);
		code = new int[geheimCode.length()];
		for (int i = 0; i < geheimCode.length(); i++) {
			;
			code[i] = Integer.decode("" + geheimCode.charAt(i));
		}

		int[] tip = {1, 2, 3, 4};
		// TODO prüfe beide Prüfemethoden und gib Resultat aus
		// TODO dann lass benutzer neue Eingabe machen

		System.out.println("Anzahl mit richtiger Position: " + berechneAnzRichtiePosition(tip));

	}

	// TODO input als String oder als einzelne Int Werte aus dem Tip Spieler nehmen?
	public static int berechneAnzRichtiePosition(int[] tip) {
		/* Input müsste Variabel sein? D.h. wenn 4 Zahlen erwartet werden
		müssen vier verarbeitet werden und 4 als input diefiniert werden.*/

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

	public static String generateZufallszahl(int mZ) {
		//		Zufallszahl bestimmer
		Random  ZUFALL  = new Random();
		int zahlX = ZUFALL.nextInt(mZ)+ 1;
		String convZahlX = String.valueOf(zahlX);
		return convZahlX;
	}
}