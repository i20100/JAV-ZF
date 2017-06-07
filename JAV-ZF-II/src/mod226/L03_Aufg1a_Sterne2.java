package mod226;

public class L03_Aufg1a_Sterne2 {

	public static void main(String[] args) {

		int h = 3; // Höhe Tannenbaum
		int z = 0; // z = leerzeichen2 anzahl leerzeichen pro Zeile

		//		Zeilen Schleife, i = aktuelle Zeile
		for (int i = 0; i < h; i++) {
			//				Spaltenschleife
			for (z = h-1; z > 0; z--) {
				System.out.print("Test");
			}
//			for (int j=(h*2)-1; j > 0; --j) {
//				System.out.print("*");
//			}
			System.out.println("z");
		}					
	}
}
