package mod226;

import java.util.Random;

public class L04_Aufg1_Zufallszahlen_Array_Sortieren {

	public static void main(String[] args) {
		/* 
		 * TODO Generiere 30 Zahlen zwischen 1-50
		TODO Speichere diese im Array und gib diese aus
		TODO Sortiere nun diese Zahlen und gib sie aus
		An wie vielen Positionen stand im alten Array eine grössere Zahl?
		TODO Vergleiche die Positionen einzeln: altes Array > neue Position
		Konsolenausgabe siehe AB226-04.docx Aufg1 */
		
//		Get Random Number from 1-50
//		https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
		double random = Math.random() * 50 + 1;		
		System.out.println(random); // Prints random as double
		System.out.println((int)random); // Prints random as int, Note the downcast
	}

}