package mastermind;

public class berechneAnzRichtigeOhnePosition {

	public static void main(String[] args) {
		// Code besteht aus 6 möglichn Farben wurden 4 ausgewählt.
		// Tip Spieler besteht aus 6 möglichen Zahlen wurden 4 ausgewählt.


		int[] tip = {1, 2, 3, 4};

		System.out.println("Anzahl mit richtige Zahlen ohne Position: " + berechneAnrRichtigeOhnePos(tip));

	}
	// TODO input als String oder als einzelne Int Werte aus dem Tip Spieler nehmen?
	public static int berechneAnrRichtigeOhnePos(int[] tip) {
		/* Input müsste Variabel sein? D.h. wenn 4 Zahlen erwartet werden
			müssen vier verarbeitet werden und 4 als input diefiniert werden.*/

		int[] code = {1, 3, 2, 1};

		// *Exit bei Treffer, damit jede Zahl nur einmal gezählt wird.
		int anzRichtige = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tip[i] == code[j]) {
					anzRichtige = anzRichtige + 1;
					j = 4; // => Exit bei Treffer
				} anzRichtige = anzRichtige + 0;
			}
		}
		return anzRichtige;
	}
}
