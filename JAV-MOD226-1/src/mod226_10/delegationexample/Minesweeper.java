package mod226_10.delegationexample;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import mod226_09.Spielfeld;

@objid ("a91c080d-7e95-4de4-8070-cb426dda6061")
public class Minesweeper {
	@objid ("ea35c8a8-6f06-47ec-970a-1afac2291c5f")
	private final Benutzerschnittstelle benutzerschnittstelle = new Benutzerschnittstelle();

	@objid ("4e6181a3-9e3f-4f9f-a9b5-ee4f816f12b8")
	private final Spielfeld spielfeld = new Spielfeld();

	@objid ("fa036034-0213-4a88-9f98-c8e41c70f934")
	public static void main(String[] args) {
		Minesweeper minesweeper = new Minesweeper();
		minesweeper.spielen();
	}

	private void spielen() {
		do {
			benutzerschnittstelle.zeigeSpielfeld(spielfeld);
			benutzerschnittstelle.zeigeEingabeaufforderung();
			String[] eingabeTeile = benutzerschnittstelle.liesEingabe();
			int zeile = Integer.valueOf(eingabeTeile[1]);
			int spalte = Integer.valueOf(eingabeTeile[2]);
			switch (eingabeTeile[0]) {
			case "T":
				spielfeld.aufdecken(spalte, zeile);
				break;
			case "M":
				spielfeld.markieren(spalte, zeile);
				break;
			}
		} while (spielLaeuft());
		benutzerschnittstelle.zeigeSpielfeld(spielfeld);
		benutzerschnittstelle.zeigeSchlussmeldung();
	}


	@objid ("890def89-27b6-41a7-b38c-f02ea594a6ad")
	private boolean spielLaeuft() {
	}

}
