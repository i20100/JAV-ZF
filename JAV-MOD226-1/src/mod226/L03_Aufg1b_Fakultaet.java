package mod226;

public class L03_Aufg1b_Fakultaet {

	public static void main(String[] args) {

		// Fakultät - Funktion für Fakultät
		// Die Berechnung der Fakultät ist die Summe aller einzelnen reellen Positiven
		// Zahlen, oder die Summe von n * n-1 * n-2... bis n-x >= 1
		
		int n = 10; // Wert welcher als Fakultät berechnet werden soll
		int summe = n;

		// Sonderfall Fakultät von Null = Eins
		// Sonderfall 0! wird mit dieser if Verzweigung abgefangen
		if (n == 0)
			n = 0;
		summe = 1;
		
		// Berechnung der Fakultät 'n!'
		for (int i = 1; i < n; i++) {
			summe = summe * (n-i);
			System.out.println("Zwischensumme: " + summe);	
		}
		System.out.println("Fakultät von " + n + "! ist: " + summe);

	}
}