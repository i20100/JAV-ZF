package test;

import java.util.Scanner;

public class Mastermind {
	static int[] codeArray = {0, 0, 0, 0}; // Init Variable Code
	static int[] tipArray = {0, 0, 0, 0}; // Variable für Benutzer Tipp

	public static void main(String[] args) {
		
		tipUser(tipArray);


//		generate 4 numbers and write them to codeArray
		for (int i = 0; i < codeArray.length; i++) {
			double random = Math.random() * 6 + 1;
			codeArray[i] = (int)random;
		}
		
//		test codeArray and tipArray
		System.out.println(arrayToString(codeArray));
		System.out.println(arrayToString(tipArray));
		
	
	}

//	Array to "xxxx" String converter
	static String arrayToString(int[] array) {
		String arrayToString = "";
		for (int i = 0; i < array.length; i++) {
			arrayToString = arrayToString + Integer.toString(array[i]);
		}
		return arrayToString;
	}
	
	
	/** Aks User for his guess and gets the Userinput. 
	 * @param tipArray
	 */
	public static void tipUser(int[] tipArray) {
		System.out.println("Bitte geben Sie vier Zahlen zwischen 1-6 nach einander ein. Jede Zahl gefolgt von Enter.");
		// TODO Zahleneingabe ohne Enter nach jeder Zahl ermöglichen
		// TODO close reader
		Scanner reader = new Scanner(System.in);
		for (int i = 0; i < tipArray.length; i++) {
			tipArray[i] = reader.nextInt();
		}
	}
	
	
}
