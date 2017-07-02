package mod226;

import java.util.Arrays;

public class L04_Aufg1_Zufallszahlen_Array_Sortieren {

	private static int anzahlZahlen = 30;
	private static int[] arso;
	private static int counterArraPosHigher = 0;

	public static void main(String[] args) {
		/* 
		 * DONE Generiere 30 Zahlen zwischen 1-50
		DONE Speichere diese im Array und gib diese aus
		XXX Sortiere nun diese Zahlen und gib sie aus
		An wie vielen Positionen stand im alten Array eine grössere Zahl?
		DONE Vergleiche die Positionen einzeln: altes Array > neue Position
		Konsolenausgabe siehe AB226-04.docx Aufg1 => 
		Anzahl Positionen im Ursprungsarray eine grössere Zahl stand
		 als in dem sortierten Array?*/

		//		Get Random Number from 1-50
		//		https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

		// create random array (ARray RAndom)
		int[] arra = new int[anzahlZahlen];
		for (int i = 0; i < arra.length; i++) {
			double random = Math.random() * 50 + 1;		
			arra[i] = (int) random;
		}

		System.out.println(Arrays.toString(arra));

		//XXX sortieren - sortiermechano? 
		//DONE 1. copry arra to arso
		// 2. Nimm zahl arso[i] vergleiche mit arso[i+1]
		//if arso[i]>arso[i+1] then save arso[i] to arsoTemp, then arso[i] = arso[i+1]
		// then arso[i+1] = arsoTemp, restart loop? or i++
		// else i++


		// copy arra to arso (ARray SOrted)
		int[] arso = new int[anzahlZahlen];
		//XXX copy of arra array into arso array with for loop, better way?
		for (int i = 0; i < arso.length; i++) {
			arso[i] = arra[i];
		}
		System.out.println(Arrays.toString(arso));

        // Sorting of arso Array form low to high
		for (int j = 0; j < arso.length; j++) {
			for (int i = 0; i < arso.length-1; i++) {
				if (arso[i] > arso [i+1]) {
					int arsoTemp = arso[i];
					arso[i] = arso [i+1];
					arso[i+1] = arsoTemp;
				}
			}
		}
		System.out.println(Arrays.toString(arso));

		// Counting times where value from original Array was higher than now in sorted Array
		for (int i = 0; i < arso.length; i++) {
			if (arra[i] > arso[i]) {
				counterArraPosHigher  = counterArraPosHigher +1;
			}
		}

		System.out.println("An "+counterArraPosHigher +" Positionen war im unsortierten Array eine grössere Zahl.");

	}
}