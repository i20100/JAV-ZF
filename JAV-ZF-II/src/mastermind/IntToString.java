package mastermind;

public class IntToString {

	static int[] code = {1, 1, 4, 2}; // Init Variable Code

	public static void main(String[] args) {
		// Testen von Int to String in Schleife


		String codeToString = "";
		for (int i = 0; i < code.length; i++) {
			codeToString = codeToString + Integer.toString(code[i]);
//			Those two commentlines are for test only!
//			System.out.println(codeToString);
		}
System.out.println(codeToString);

	}

}
