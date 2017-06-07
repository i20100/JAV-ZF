package mastermind;

import java.util.Arrays;

public class SchleifeCodeCheckerWithIntToStringMethod {

	static int[] code = {1, 1, 4, 2}; // Init Variable Code
	static int[] tip = {0, 0, 0, 0}; // Variable für Benutzer Tipp

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Code = " + (Arrays.toString(code)));
		System.out.println("Tip = " + (Arrays.toString(tip)));
		//int[] tip = {1, 1, 4, 2}; 
		tip = setTip();
		System.out.println("Tip = " + (Arrays.toString(tip)));

		//		convert Arrays to String => IntToString.java
		codeToString()


		//			Those two commentlines are for test only!
		//			System.out.println(codeToString);
	}
	System.out.println(codeToString);

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

public static void codeToString() {
	String codeToString = "";
	for (int i = 0; i < code.length; i++) {
		codeToString = codeToString + Integer.toString(code[i]);

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