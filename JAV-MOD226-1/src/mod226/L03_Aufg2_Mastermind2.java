package mod226;

import java.util.Random;

public class L03_Aufg2_Mastermind2 {

	public static void main(String[] args) {
		System.out.println(generateCode(6, 2));
	}

	/* Codegenerator = erstellt eine Zahlenreihenfolge welche geknackt werden soll.
	 * Die Zahlenreihenfolge wird aus Zufallszahlen aus x (x=mögliche Zahlen) 
	 * y (y= Anzahl Stellen) erstellt. Bsp. x = 4, y = 5 => 43312. 
	 * Wiederholungen von y sind erlaubt. 
	 * Die Zahlen entsprechen den Farben in Masterminds.
	 * Diese Zahlen sind der Code der geknackt werden soll. */
	
	public static String generateCode(int moeglicheZahlen, int anzahlStellen) {
		
		String code = "";
		//	anzahlStellen Schleife
		for (int i = 0; i < anzahlStellen; i++) {
			String zufallsZahl=generateZufallszahl();
			code = code + zufallsZahl;
		}
		return code;
	}

	public static String generateZufallszahl() {
		//		Zufallszahl bestimmer
		Random  ZUFALL  = new Random();
		int zahlX = ZUFALL.nextInt(6)+ 1;
		String convZahlX = String.valueOf(zahlX);
		return convZahlX;
	}
}