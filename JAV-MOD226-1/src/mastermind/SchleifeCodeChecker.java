package mastermind;

import java.util.Arrays;

public class SchleifeCodeChecker {

	static int[] code = {1, 1, 4, 2}; // Init Variable Code
	static int[] tip = {0, 0, 0, 0}; // Variable f�r Benutzer Tipp

	public static void main(String[] args) {
		// Dieser Versuch zeigt das zwei Array mit == Vergleich False ergeben!!
		System.out.println("Code = " + (Arrays.toString(code)));
		System.out.println("Tip = " + (Arrays.toString(tip)));
		//int[] tip = {1, 1, 4, 2}; 
		tip = setTip();
		System.out.println("Tip = " + (Arrays.toString(tip)));
		
//		Check Tip == Code
		if (tip == code) {
			System.out.println("Tip == Code");
		} System.out.println("Tip != Code");
		
	/*	do {
			System.out.println("Checke Tip");
			System.out.println("Tip != Code");	
			//Default is comment out next Line = Loop Tip is not Code!
			getTip();
		} while (tip != code);*/

	}

	static int[] setTip() {
		int[] tip = {1, 1, 4, 2};
		return tip; 
	}

	public static int[] getTip() {
		return tip;
	}

/*	public static void setTip(int[] tip) {
		SchleifeCodeChecker.tip = tip;
	}*/

}