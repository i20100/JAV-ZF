package rechenaufgabe;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("17735095-63e8-49bd-aed6-6d3b425d5289")
public class Aufgabe {
    @objid ("faf6156b-a8b8-4c33-a6dd-ebb7eb374396")
    public static int zuloesendeAufgaben = 5;

    @objid ("61c3807d-00cd-41f8-a3cf-84523c009f1d")
    public int geloesteAufgaben;

    @objid ("161d8317-4337-44ef-984d-046aed682947")
    public int zahlA;

    @objid ("60601874-b503-42fe-9aa8-2db5e656936d")
    public int zahlB;

    @objid ("aa6c57ca-f61b-479b-bab1-df5180218be5")
    public int zahlOperator;

    @objid ("92b1e4b9-86a9-4784-9aa9-c32e9542e7da")
    public int resultat;

    @objid ("4d546859-b7ec-4d7b-9659-f7ee5972c42b")
    public ZufallsZahl zufallsZahl;

    @objid ("e833085f-f57b-4fd1-8617-1972bbe529cf")
    public Operator operator;

    @objid ("76977343-ff34-49f9-be65-e6a1f75084af")
    public void zufallszahlenErstellen() {
        // rufe 3x ZufallsZahl auf und Speichere die Werte in Variablen
        ZufallsZahl objZahlA = new ZufallsZahl();
        zahlA = objZahlA.getZufallsZahl();
        ZufallsZahl objZahlB = new ZufallsZahl();
        zahlB = objZahlB.getZufallsZahl();
        ZufallsZahl objZahlOperator = new ZufallsZahl(5);
        zahlOperator = objZahlOperator.getZufallsZahl();
    }

    @objid ("3f57e30f-6070-4b48-b179-d0104b60190c")
    public int berechneResultat() {
    	// Erstellen der Operatoren
		Operator operator = new Operator();

		// Auswahl Operation 1. von 5 via zahlOperator &
		// Loesen der Aufgabe,  Rueckgabe ist das Resultat der Operation
		resultat = (operator.operationAuswaehlen(zahlOperator, zahlA, zahlB));
    	return resultat;
    }

}
