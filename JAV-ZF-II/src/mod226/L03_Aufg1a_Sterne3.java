package mod226;

public class L03_Aufg1a_Sterne3 {

	public static void main(String[] args) {

		int h = 3; // H�he Baum einziger Wert Benutzer!
		int z = 1; // aktuelle Zeile wird in Erster Schleife ++1
		int l = 0; // aktuelle Anzahl Leerzeichen
		int s = 0; // aktuelle Anzahl "Bl�tter" bwz. Sterne

		//		Zeilenschleife z++
		for (; z <= h; z++) {

			// Leerzeichenschleife, setzt Anzahl Leerzeichen bis Baumbeginn				
			for (l=(h-z)*2; l > 0; l--) {
				System.out.print(" ");
			}

			// "Bl�tter"-Schleife, setzt Anzahl Bl�tter pro Zeile ab Baumbeginn
			for (s= (z-1)*4+1; s > 0; s--) {
				System.out.print("*");
			}

			// Zeilenschaltung 
			System.out.println();
		}
	}
}