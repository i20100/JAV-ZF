package mastermind;

public class SchleifeVersuche {
	static int zaehler= 0; // Variable für Anzahl Versuche
	static int versuche = 2; // Anzahl Versuche festlegen

	public static void main(String[] args) {

		do {
			versuchsZaehler();
		} while (zaehler < versuche);
		System.out.println("Ende");

	}

	private static void versuchsZaehler() {
		// TODO Auto-generated method stub
		zaehler = ++zaehler;
		System.out.println("Z<V!");
		
	}
}