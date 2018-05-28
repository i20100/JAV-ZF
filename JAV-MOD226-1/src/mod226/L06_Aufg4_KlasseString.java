package mod226;

import java.util.Arrays;

public class L06_Aufg4_KlasseString {
	public static void main(String[] args) {
		// Eigenes String Experiment
		char[] abc = new char[3];
		char a = 'a';
		char b = 'b';
		char c = 'c';
		
		abc[0] = a;
		abc[1] = b;
		abc[2] = c;
		
//		String newABC = String(abc[3]); // Geht auch nicht
//		String newABC = String(char abc[3]); // Geht auch nicht...
//		String newABC = String(abc[3], 1, 1); // Dito
		
		System.out.println(Arrays.toString(abc));
		
		
//		String Befehle		
		String def = "def";
		System.out.println(def.charAt(1));
		String ghi = new String(def);
//		String ghi = def;
		System.out.println(ghi);
		System.out.println(def.length());
		System.out.println("abc".length());
		
//		Vergleiche		
		String s = "Hallo";
		String t = new String(s);
		String u = "Hallo";
		
		System.out.println(s.equals(t)); // true, da .equals = the same sequence of characters as this object
		System.out.println(s == t); // false -> sagt aus das es nicht die gleiche Referenz hat
		System.out.println(s.equals(u)); // true
		System.out.println(s == u); // true

	}

}
