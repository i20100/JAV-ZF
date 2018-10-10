package mod226_10.mineswepfinal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Minesweeper Klasse, baut die Spielumgebung auf und startet Benutzerschnittstelle
 * und prueft Spielendbedingung laufend. Beendet Spiel je nach Spielsituation.
 * 
 * @author Vincent
 * @version 1.1
 *
 */
@objid ("a91c080d-7e95-4de4-8070-cb426dda6061")
public class Minesweeper {
	/**
	 * Instanz ist die Verbindung zur Benutzereingabe.
	 */
	@objid ("ea35c8a8-6f06-47ec-970a-1afac2291c5f")
	private final Benutzerschnittstelle benutzerschnittstelle = new Benutzerschnittstelle();

	/**
	 * Instanz enthaelt Daten zum Spiel. Zellen usw.
	 */
	@objid ("4e6181a3-9e3f-4f9f-a9b5-ee4f816f12b8")
	private final static Spielfeld spielfeld = new Spielfeld();

	/**
	 * @see Minesweeper
	 * @param args
	 */
	@objid ("fa036034-0213-4a88-9f98-c8e41c70f934")
	public static void main(String[] args) {
		Minesweeper minesweeper = new Minesweeper();
		minesweeper.ki(spielfeld);
		minesweeper.spielen();
	}

	/**
	 * @see Minesweeper
	 */
	@objid ("ad3a7df8-f221-4ab9-b1db-66dc0dcede7c")
	private void spielen() {
		spielversionAnzeigen();
		spielBegruessung();
		do {
			benutzerschnittstelle.zeigeSpielfeld(spielfeld);
			benutzerschnittstelle.zeigeEingabeaufforderung();
			Kommando kommando = benutzerschnittstelle.liesEingabe();
			kommando.ausfuehren(spielfeld);
		} while (spielLaeuft());
		benutzerschnittstelle.zeigeSpielfeld(spielfeld);
		benutzerschnittstelle.zeigeSchlussmeldung();
		benutzerschnittstelle.zeigeSpielabbruch();
		benutzerschnittstelle.warteAufBenutzereingabe();
	}


	/**
	 * Begruesst Spieler.
	 */
	private void spielBegruessung() {
		// TODO Auto-generated method stub
		System.out.println("Willkommen zu Minesweeper\n\n");
	}

	/**
	 * Ausgabe aktuelle Version, jeder neue Release kann so nachvollzogen werden.
	 */
	private void spielversionAnzeigen() {
		System.out.println("Version 1.1");
//		System.out.println(@version); // Todo is it possible to print the javadoc version? or is this a seperate version just for the doc?
	}

	/** spielLaeuft prueft Abbruchbedingung fuer gewonnen und verloren
	 *  und steigt aus der Spielschlaufe aus sobald gewonnen oder verloren.
	 * 
	 * @return spielLaufenLassen Status Abbruchbedingung aus Schleife
	 */
	@objid ("890def89-27b6-41a7-b38c-f02ea594a6ad")
	public boolean spielLaeuft() {
		//XXX Was soll hier rein, was war die Idee des Lehrers fuer diese Methode?
		// pruefe ob alle Felder aufgedeckt sind, wenn ja Spiel gewonnen!
		// pruefe ob eine bombe explodiert ist, wenn ja Spiel verloren!
		boolean spielLaufenLassen = true;

		//pruefe gewonnen und verloren
		{
			int nichtAufgedeckteFelder = 0;
			int bombenExplodiert = 0;
			int markierteBomben = 0;

			for (Zelle zelle : Spielfeld.listeAllerZellen) {
				if (zelle.zeichen == " ") {
					nichtAufgedeckteFelder += 1;
				}
				if (zelle.zeichen == "!") {
					markierteBomben += 1;

				}
				if (zelle.zeichen == "*") {
					bombenExplodiert += 1;
				}
			}

			// DONE if Bedingung aufsetzen fuer Spiel gewonnen 
//			System.out.println("nichtAufgedeckteFelder = "+nichtAufgedeckteFelder);
			// old
			//			if (nichtAufgedeckteFelder == Spielfeld.listeAllerZellen.size() - Spielfeld.listeBombenOrte.size()) {
			if (nichtAufgedeckteFelder == 0 && markierteBomben == Spielfeld.listeBomben.size()
					) {
				spielLaufenLassen = false;
			} 
			if (bombenExplodiert > 0) {
				spielLaufenLassen = false;
			}
		}
		return spielLaufenLassen;
	}

	/**
	 * Bereitet Spielfeld vor, verteilt die Bomben, beschriftet die Zellen entsprechend
	 * ihren direkten Nachbarn.
	 * 
	 * @param aktuellesSpielfeld
	 */
	@objid ("4811778f-9629-4242-a4c5-a2a81c116e4c")
	private void ki(Spielfeld aktuellesSpielfeld) {
		//		if (spielfeld.listeBombenOrte.size() > 0) {
		//			System.out.println("listeBombenOrte.size = "+ Integer.toString(spielfeld.listeBombenOrte.size()));
		//		}

		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		kI.verteileBomben(spielfeld, spielfeld.gewuenschteBomben);
		spielfeld.erstelleBombenListe();
		kI.beschrifteNachbarzellenZuBomben(spielfeld);
	}

}
