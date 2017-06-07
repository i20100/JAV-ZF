package mod226;

public class L03_Aufg1a_Sterne3 {

	public static void main(String[] args) {

		int h = 3; // Höhe Baum einziger Wert Benutzer!
		int z = 1; // aktuelle Zeile wird in Erster Schleife ++1
		int l = 0; // aktuelle Anzahl Leerzeichen
		int s = 0; // aktuelle Anzahl "Blätter" bwz. Sterne

		//		Zeilenschleife z++
		for (; z <= h; z++) {

			// Leerzeichenschleife, setzt Anzahl Leerzeichen bis Baumbeginn				
			for (l=(h-z)*2; l > 0; l--) {
				System.out.print(" ");
			}

			// "Blätter"-Schleife, setzt Anzahl Blätter pro Zeile ab Baumbeginn
			for (s= (z-1)*4+1; s > 0; s--) {
				System.out.print("*");
			}

			// Zeilenschaltung 
			System.out.println();
		}
	}
}