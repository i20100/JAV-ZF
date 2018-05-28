package mod226_10.mineswepfinal;

public class KuenstlicheIntelligenz {
//	Zugriff auf ZellenArray �ndern auf static
	int letzteSpalte = Spielfeld.zellenArray[0].length-1;
	int letzteZeile = Spielfeld.zellenArray.length-1;

	public int zaehleVerteilteBomben(Spielfeld spielfeld) {
		int verteilteBomben = 0;
		for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
			for (int j = 0; j < Spielfeld.zellenArray[i].length; j++) {
				if (Spielfeld.zellenArray[i][j].bombe == true)
					verteilteBomben = verteilteBomben+1;
			}
		}
		return verteilteBomben;
	}

	public void verteileBomben(Spielfeld spielfeld, int gewuenschteBomben) {
		int anzahlZellen = zaehleZellen(spielfeld);

		for (int i = 0; i < gewuenschteBomben; i++) {
			int randomInt = (int) (Math.random()*anzahlZellen);
			int zeile = randomInt/Spielfeld.zeilen;
			int spalte = randomInt%Spielfeld.zeilen;
			if (Spielfeld.zellenArray[zeile][spalte].bombe == false) {
				Spielfeld.zellenArray[zeile][spalte].setzeBombe();
				//	System.out.println("Bombe auf zeile, spalte:" + zeile + ", " + spalte); //Kommentar ausblenden f�r detailierte Ausgabe
			} else {
				i = i-1;
			}
		}
	}

	public int zaehleZellen(Spielfeld spielfeld) {
		int anzahlZellen = 0;
		for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
			for (int j = 0; j < Spielfeld.zellenArray[i].length; j++) {
				anzahlZellen += 1;
			}
		}
		return anzahlZellen;
	}

	public void beschrifteNachbarzellenZuBomben(Spielfeld spielfeld) {
		//1. Gehe nur von den Feldern aus welche Bomben besitzen
		//2. Gehe f�r jedes Feld welche Eine Bombe hat eine Routine durch
		//3. Routine erh�ht Bombenz�hler auf Zellen
		//4. Es gibt neuen Verschiedene Methode je nach Bombenort

	}

	public void bombeObenLinks(Spielfeld spielfeld) {
		// gilt nur f�r Zelle[0][0]!
		// Erh�he bombenInNachbarschaft f�r rechts, unten, rechts unten
		Spielfeld.zellenArray[0][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][1].bombenInNachbarschaft += 1;
	}

	public void bombeObenMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt nur f�r Zelle[0][1]-[0][Spielfeld.zellenArray.[0].length-1]!
		// Erh�he bombenInNachbarschaft f�r links, rechts, unten, unten li. u. re.
		// in Bezug auf aktuelle position!
		Spielfeld.zellenArray[0][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[0][spalte+1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte+1].bombenInNachbarschaft += 1;
	}

	public void bombeObenRechts(Spielfeld spielfeld) {
		// gilt nur f�r Zelle[0][letzteSpalte]!
		// Erh�he bombenInNachbarschaft f�r links, unten, links unten
		Spielfeld.zellenArray[0][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

	public void bombeUntenLinks(Spielfeld spielfeld) {
		// gilt nur f�r Zelle[letzteZeile][0]!
		// Erh�he bombenInNachbarschaft f�r rechts, oben, rechts oben
		Spielfeld.zellenArray[letzteZeile][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][1].bombenInNachbarschaft += 1;
	}

	public void bombeUntenMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt nur f�r Zelle[letzteZeile][1]-[letzteZeile][Spielfeld.zellenArray.[0].length-1]!
		// Erh�he bombenInNachbarschaft f�r links, rechts, oben, oben li. u. re.
		// in Bezug auf aktuelle position!
		Spielfeld.zellenArray[letzteZeile][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile][spalte+1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte+1].bombenInNachbarschaft += 1;
	}

	public void bombeUntenRechts(Spielfeld spielfeld) {
		// gilt nur f�r Zelle[0][letzteSpalte]!
		// Erh�he bombenInNachbarschaft f�r links, oben, links oben
		Spielfeld.zellenArray[letzteZeile][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

	public void bombeMitteLinks(Spielfeld spielfeld, int zeile) {
		// gilt nur f�r Zellen[1][0] - [letzteZeile-1][0]!
		// Erh�he bombenInNachbarschaft f�r rechts, oben, unten, rechts oben und unten
		Spielfeld.zellenArray[zeile][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][1].bombenInNachbarschaft += 1;
	}

	public void bombeMitteMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt f�r alle Zellen welche keinen Rand ber�hren!
		// Erh�he bombenInNachbarschaft f�r links, rechts, oben, unten, oben und unten li. u. re.
		// in Bezug auf aktuelle position!
		Spielfeld.zellenArray[zeile][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile][spalte+1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][spalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][spalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][spalte+1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][spalte+1].bombenInNachbarschaft += 1;
	}

	public void bombeMitteRechts(Spielfeld spielfeld, int zeile) {
		// gilt nur f�r Zelle[1][letzteSpalte] - [letzteZeile-1][letzteSpalte]
		// Erh�he bombenInNachbarschaft f�r links, oben, unten, links oben unten
		Spielfeld.zellenArray[zeile][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

}