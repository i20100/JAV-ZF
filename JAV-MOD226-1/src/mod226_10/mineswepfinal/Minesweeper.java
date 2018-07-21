package mod226_10.mineswepfinal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a91c080d-7e95-4de4-8070-cb426dda6061")
public class Minesweeper {
	@objid ("ea35c8a8-6f06-47ec-970a-1afac2291c5f")
	private final Benutzerschnittstelle benutzerschnittstelle = new Benutzerschnittstelle();

	@objid ("4e6181a3-9e3f-4f9f-a9b5-ee4f816f12b8")
	private final static Spielfeld spielfeld = new Spielfeld();

	@objid ("fa036034-0213-4a88-9f98-c8e41c70f934")
	public static void main(String[] args) {
		Minesweeper minesweeper = new Minesweeper();
		minesweeper.ki(spielfeld);
		minesweeper.spielen();
	}

	@objid ("ad3a7df8-f221-4ab9-b1db-66dc0dcede7c")
	private void spielen() {
		do {
			benutzerschnittstelle.zeigeSpielfeld(spielfeld);
			benutzerschnittstelle.zeigeEingabeaufforderung();
			Kommando kommando = benutzerschnittstelle.liesEingabe();
			kommando.ausfuehren(spielfeld);
		} while (spielLaeuft());
		benutzerschnittstelle.zeigeSpielfeld(spielfeld);
		benutzerschnittstelle.zeigeSchlussmeldung();
	}

	@objid ("890def89-27b6-41a7-b38c-f02ea594a6ad")
	private boolean spielLaeuft() {
		//XXX Was soll hier rein, was war die Idee des Lehrers fuer diese Methode?
		// pruefe ob alle Felder aufgedeckt sind, wenn ja Spiel gewonnen!
		// pruefe ob eine bombe explodiert ist, wenn ja Spiel verloren!
		boolean abbruchBedingung = false;

		//pruefe gewonnen und verloren
		{
			// gewonnen
			int nichtAufgedeckteFelder = 0;
			int bombenExplodiert = 0;
			
			for (Zelle zelle : spielfeld.listeAllerZellen) {
				if (zelle.zeichen == " ") {
					nichtAufgedeckteFelder += 1;
				}
				if (zelle.zeichen == "*") {
					bombenExplodiert += 1;
				}
			}

			if (nichtAufgedeckteFelder > 0 || bombenExplodiert > 0) {
				abbruchBedingung = true;
			} 
		}
		return abbruchBedingung;
	}

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
