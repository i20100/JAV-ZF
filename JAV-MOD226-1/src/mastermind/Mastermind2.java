package mastermind;

public class Mastermind2 {

	public static void main(String[] args) {
		// Code besteht aus 6 m�glichn Farben wurden 4 ausgew�hlt.
		// Tip Spieler besteht aus 6 m�glichen Zahlen wurden 4 ausgew�hlt.

		
		int[] tip = {1, 1, 1, 1};
		
		System.out.println("Anzahl mit richtiger Position: " + berechneAnzRichtiePosition(tip));

	}
	// TODO input als String oder als einzelne Int Werte aus dem Tip Spieler nehmen?
	public static int berechneAnzRichtiePosition(int[] tip) {
		/* Input m�sste Variabel sein? D.h. wenn 4 Zahlen erwartet werden
		m�ssen vier verarbeitet werden und 4 als input diefiniert werden.*/
		
		int[] code = {1, 1, 4, 2};
		
		int anzRichtige = 0;
		for (int i = 0; i < 4; i++) {
//			System.out.println("test");

			if (tip[i] == code[i]) {
				anzRichtige = anzRichtige + 1;
			} anzRichtige = anzRichtige + 0;
		}
		return anzRichtige;
	}
}
