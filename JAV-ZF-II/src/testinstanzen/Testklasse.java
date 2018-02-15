package testinstanzen;

import java.util.Scanner;

public class Testklasse {

	public static void main(String[] args) {
		A klasseA = new A();
		
		AntwortAuswerten(klasseA.a);
	}
	
	public static void AntwortAuswerten(int x) {
		System.out.println("Errate den Zahlenwert von a. Antwort eingeben: ");
		

		// TODO Antwort lesen
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println(i);

		// TODO Antwort vergleichen
		if (i == x) {
			System.out.println(x + " = " + i);
		} else
			System.out.println(x + " != " + i);
		//	}

	}

}
