package mod226;

public class L03_Aufg1b_Fakultaet {

	public static void main(String[] args) {

		// Fakult�t - Funktion f�r Fakult�t
		// Die Berechnung der Fakult�t ist die Summe aller einzelnen reellen Positiven
		// Zahlen, oder die Summe von n * n-1 * n-2... bis n-x >= 1
		
		int n = 10; // Wert welcher als Fakult�t berechnet werden soll
		int summe = n;

		// Sonderfall Fakult�t von Null = Eins
		// Sonderfall 0! wird mit dieser if Verzweigung abgefangen
		if (n == 0)
			n = 0;
		summe = 1;
		
		// Berechnung der Fakult�t 'n!'
		for (int i = 1; i < n; i++) {
			summe = summe * (n-i);
			System.out.println("Zwischensumme: " + summe);	
		}
		System.out.println("Fakult�t von " + n + "! ist: " + summe);

	}
}