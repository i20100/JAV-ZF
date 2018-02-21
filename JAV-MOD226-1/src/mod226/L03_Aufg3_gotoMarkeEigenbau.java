package mod226;

import java.util.Scanner;

public class L03_Aufg3_gotoMarkeEigenbau {

	public static void main(String[] args) {
		/* Mittels Schelifen soll eine Navigation ermöglicht werden an den 
		 * Ausgangspunkt */

		Scanner reader = new Scanner(System.in);
		while (true) {

			System.out.println("Start");
			System.out.println("Wollen Sie Fortfahren? J/N");

			char antwort = reader.next().charAt(0);

			if (antwort == 'J' || antwort == 'j') {
				System.out.println("Restarting");
				main(args);
			}
			/* TODO Fage Kurt: 
			 * Abbruchbedingung wird 3x ausgegeben wenn zuerst 3x j gesagt wird
			wieso? */
			else System.out.println("Aborting");
			break;
		}

	}

}
