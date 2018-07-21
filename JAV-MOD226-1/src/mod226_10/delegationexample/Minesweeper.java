package mod226_10.delegationexample;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import mod226_10.mineswepfinal.Spielfeld;

@objid ("ac4e195e-9c6e-4767-9f83-8c9e86e6ec21")
public class Minesweeper {
	@objid ("88762306-9398-437b-9791-65c675afbf0a")
	private final Benutzerschnittstelle benutzerschnittstelle = new Benutzerschnittstelle();

	@objid ("3322e8fc-3d15-4d77-a95a-2c194c558362")
	private final Spielfeld spielfeld = new Spielfeld();


	@objid ("6292d80b-5e24-48d1-8b67-e4f764fdee29")
	public static void main(String[] args) {
		Minesweeper minesweeper = new Minesweeper();
		minesweeper = new Minesweeper();
		minesweeper.spielen();
	}

	@objid ("f454e8d8-e8db-464b-9481-fd5b7ae65866")
	private void spielen() {
		do {
			benutzerschnittstelle.zeigeSpielfeld(spielfeld);
			benutzerschnittstelle.zeigeEingabeaufforderung();
			Kommando kommando = benutzerschnittstelle.liesEingabe();
			kommando.ausfuehren(spielfeld);
		} while (spielLaeuft(spielfeld));
		benutzerschnittstelle.zeigeSpielfeld(spielfeld);
		benutzerschnittstelle.zeigeSchlussmeldung(spielfeld);
	}

	@objid ("c3ea221c-046b-480a-9731-898e0c7d8c0f")
	private boolean spielLaeuft(Spielfeld spielfeld) {
		return true;
	}



}
