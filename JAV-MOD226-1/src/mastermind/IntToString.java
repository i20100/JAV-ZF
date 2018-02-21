package mastermind;

public class IntToString {

	static int[] code = {1, 1, 4, 2}; // Init Variable Code
	static int[] code2 = {1, 1, 4, 2}; // Init Variable Code
	static String a = codeToString();
	static String b = codeToString2();

	public static void main(String[] args) {
		/* Testen von Int to String in Schleife. Resultat: true! aber wieso?
		 * Versuch ausweiten! Zeile code2 hinzugefügt und Vergleich
		 * codeToString == codeToString2 => Resultat: false!
		 * 3. Versuch: Prüfen Umweg über Variablen:
		 * Bsp. String a = code, String b = code2?*/

		System.out.println("a: " + a);
		System.out.println("b: "+ b);
		System.out.println("Vergleich von a == a");
		System.out.println(a == a);
		System.out.println("Vergleich von a == b");
		System.out.println(a == b);
	}

	private static String codeToString2() {
		String codeToString2 = "";
		for (int i = 0; i < code2.length; i++) {
			codeToString2 = codeToString2 + Integer.toString(code2[i]);
		}		
		return codeToString2;
	}

	private static String codeToString() {
		String codeToString = "";
		for (int i = 0; i < code.length; i++) {
			codeToString = codeToString + Integer.toString(code[i]);
		}
		return codeToString;
	}
}