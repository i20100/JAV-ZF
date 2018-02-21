package rechenaufgabe;

import java.util.Scanner;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a02bf3ad-425d-4156-b0a5-6636d1664ccb")
public class AufgabeUI {
	@objid ("19fba093-2822-49f5-8c7f-1b7572e6000d")
	//	public Aufgabe aufgabe;

	@objid ("5afdf129-0ac1-4c04-b319-326962b55e22")
	public static void main(String[] args) {
		// Erstellen der zahlA, zahlB und zahlOperator
		Aufgabe Aufgabe1 = new Aufgabe();
		Aufgabe1.zufallszahlenErstellen();
		
		// Aufgabe berechneResultat testen
		System.out.println(Aufgabe1.berechneResultat());

		// Loesung Aufgabe,  Rueckgabe ist das Resultat der Operation
//		System.out.println(ersterOperator.operationAuswaehlen(Aufgabe1.zahlOperator, Aufgabe1.zahlA, Aufgabe1.zahlB));

		// FIXME dieser Abschnitt sollte unter der Methode aufgabeStellen laufen
		// Problem auf die Instanz Aufgabe1 kann nicht ausserhalb der Main Methode zugegriffen werden.
		// Wieso?
		// 
		System.out.println(
				"Berechne: " + Aufgabe1.zahlA + " " + Aufgabe1.operator .zeigeOperatorAlsZeichen(Aufgabe1.zahlOperator) + 
				" " + Aufgabe1.zahlB + " = ?");

		//    	    	aufgabeStellen();

		// AntwortAuswerten mit Objekt als parameter übergeben, jedoch wie greife ich nun auf die Werte zu
		// und wann müssen die Werte berechnet sein damit dies überhaupt mögich ist?
//		AntwortAuswerten(Aufgabe1);

	}



	@objid ("ce947900-42a6-4666-855e-f98c77701972")
	public void AufgabeStellen() {
		// TODO Syso der Aufgabe mit korrektem Operator
		//		System.out.println(
		//				"Berechne: " + Aufgabe1.zahlA + " " + ersterOperator.zeigeOperatorAlsZeichen(Aufgabe1.zahlOperator) + 
		//				" " + Aufgabe1.zahlB + " = ?");
	}

	@objid ("815285d3-d216-494f-a735-a628b3ceaccd")
	public void AntwortAuswerten(Aufgabe aufgabe) {
		// DONE Aufgabe selber loesen, siehe oben

		System.out.println("Antwort eingeben: ");

		// TODO Antwort lesen
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println(i);


		// TODO Antwort vergleichen
		//		if (i == this.Aufgabe.resultat) {
		//	}

		// TODO Benutzer informieren
	}

}
