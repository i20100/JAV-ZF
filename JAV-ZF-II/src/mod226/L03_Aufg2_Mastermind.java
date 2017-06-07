package mod226;

import java.util.Random;

public class L03_Aufg2_Mastermind {

	public static void main(String[] args) {
		/* Codegenerator = viermal eine Zufallszahl aus einem limitierten Zahlen Bereich
		Standard Zahlenbereich 1-6, also 6 Möglichkeiten */
	
		String code = "";

		//		i = Möglichkeiten, auslagern als Inputvarialbe
		//		Zufallszahl verketter
		for (int i = 4; i > 0; i--) {
			
			//		Zufallszahl bestimmer
			Random  ZUFALL  = new Random();
			int zahlX = ZUFALL.nextInt(6)+ 1;
			
			code = code + String.valueOf(zahlX);
		}
		System.out.println(code);

	}}