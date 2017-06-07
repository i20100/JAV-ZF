package mastermind;

public class IntToString {

	static int[] code = {1, 1, 4, 2}; // Init Variable Code
	static int[] code2 = {1, 1, 4, 2}; // Init Variable Code
//	String a = codeToString;
//	String b = codeToString2;

	public static void main(String[] args) {
		/* Testen von Int to String in Schleife. Resultat: true! aber wieso?
		 * Versuch ausweiten! Zeile code2 hinzugefügt und Vergleich
		 * codeToString == codeToString2 => Resultat: false!
		 * 3. Versuch: Prüfen umweg über variablen:
		 * Bsp. String a = code, String b = code2?*/

		String codeToString = "";
		for (int i = 0; i < code.length; i++) {
			codeToString = codeToString + Integer.toString(code[i]);
		}
		String codeToString2 = "";
		for (int i = 0; i < code2.length; i++) {
			codeToString2 = codeToString2 + Integer.toString(code2[i]);
		}
		System.out.println("codeToString: " + codeToString);
		System.out.println("codeToString2: "+ codeToString2);
		System.out.println("Vergleich von codeToString == codeToString");
		System.out.println(codeToString == codeToString);
		System.out.println("Vergleich von codeToString == codeToString2");
		System.out.println(codeToString == codeToString2);

	}
}