import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a02bf3ad-425d-4156-b0a5-6636d1664ccb")
public class AufgabeUI {
	@objid ("19fba093-2822-49f5-8c7f-1b7572e6000d")
	public Aufgabe aufgabe;

	@objid ("5afdf129-0ac1-4c04-b319-326962b55e22")
	public static void main(String[] args) {
		// Erstellen der zahlA, zahlB und zahlOperator
		Aufgabe Aufgabe1 = new Aufgabe();
		Aufgabe1.zufallszahlenErstellen();
		
		// Erstellen der Operatoren und Auswahl Operation 1. von 5
		Operator ersterOperator = new Operator();
		// TODO als Rückgabe kommt das resultat der Operation als int
System.out.println(ersterOperator.operationAuswaehlen(Aufgabe1.zahlOperator, Aufgabe1.zahlA, Aufgabe1.zahlB));

		// FIXME dieser Abschnitt sollte unter der Methode aufgabeStellen laufen
		// FIXME ersteAufgabe.operator, wie stelle ich nun der operator richtig dar?
		// brauche nochmals eine Liste {1=+, 2=-, ...} ? Liste = doppelspurigkeit
		// und von der Liste Aufgabe.operator = welcher Operator?
		// wenn ja die Liste beim Operator einbauen um die Auswahl der Rechnung
		// und die Liste moeglichst nahe beieinander zu haben (zusammenhang klar)
		// Switch 1-5 char: '+', '-', ....
		// Methode bei Operator erstellt: zeigeOperatorAlsZeichen
		// Auswahl: ersterOperator.zeigeOperatorAlsZeichen(Aufgabe1.zahlOperator)
		System.out.println(
				"Berechne: " + Aufgabe1.zahlA + " " + Aufgabe1.operator + 
				" " + Aufgabe1.zahlB + " = ?");

		//    	    	aufgabeStellen();

	}



	@objid ("ce947900-42a6-4666-855e-f98c77701972")
	public void AufgabeStellen() {
		// TODO Syso der Aufgabe mit korrektem Operator
//		System.out.println(
//				"Berechne: " + zahlA + " " + operator + 
//				" " + zahlB + " = ?");
	}

	@objid ("815285d3-d216-494f-a735-a628b3ceaccd")
	public void AntwortAuswerten() {
		// TODO Aufgabe selber loesen
		// TODO Antwort lesen
		// TODO Antwort vergleichen
		// TODO Benutzer informieren
	}

}
