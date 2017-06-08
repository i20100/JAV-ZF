package test;

public class Mastermind {
	static int[] codeArray = {0, 0, 0, 0}; // Init Variable Code
	
	public static void main(String[] args) {

//		generate 4 numbers and write them to codeArray
		for (int i = 0; i < codeArray.length; i++) {
			double random = Math.random() * 6 + 1;
			codeArray[i] = (int)random;
			System.out.println((int)random); // Prints random as int, Note the downcast	
		}
//		convert array to string tipToString() exists
//		save Tip to Array int[] arrayTip
	}

}
