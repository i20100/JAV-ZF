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
		//4. Es gibt neun Verschiedene Methoden je nach Bombenort
		for (int i = 0; i < spielfeld.listeBombenOrte.length; i++) {
			int zeile = spielfeld.listeBombenOrte[i][0];
			int spalte = spielfeld.listeBombenOrte[i][1];

			int[][] bombe;
			bombe = new int[1][2];
			bombe[0][0] = zeile;
			bombe[0][1] = spalte;
			//			System.out.println("Bombe "+i+", Zeile, Spalte: "+zeile+", "+spalte);

			;
			switch (waehleVariante(bombe)) {
			case 1:
				bombeObenLinks(spielfeld);
				break;
			case 2:
				bombeObenMitte(spielfeld, zeile, spalte);
				break;
			case 3:
				bombeObenRechts(spielfeld);
				break;
			case 4:
				bombeMitteLinks(spielfeld, zeile);
				break;
			case 5:
				bombeMitteMitte(spielfeld, zeile, spalte);
				break;
			case 6:
				bombeMitteRechts(spielfeld, zeile);
				break;
			case 7:
				bombeUntenLinks(spielfeld);
				break;
			case 8:
				bombeUntenMitte(spielfeld, zeile, spalte);
				break;
			case 9:
				bombeUntenRechts(spielfeld);
				break;

			default:
				break;
			}
		}
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

	public int waehleVariante(int[][] ersteBombe) {
		// TODO Auto-generated method stub
		int zeile = ersteBombe[0][0];
		int spalte = ersteBombe[0][1];

		if (zeile == 0) {
			if (spalte == 0) {
				return 1;
			} 
			if (spalte == Spielfeld.spalten-1) {
				return 3;
			}
			else {
				return 2;
			}
		}

		if (zeile == Spielfeld.zeilen-1) {
			if (spalte == 0) {
				return 7;
			} 
			if (spalte == Spielfeld.spalten-1) {
				return 9;
			}
			else {
				return 8;
			}
		}

		if (zeile < Spielfeld.zeilen-1 && zeile > 0) {
			if (spalte == 0) {
				return 4;
			} 
			if (spalte == Spielfeld.spalten-1) {
				return 6;
			}
			else {
				return 5;
			}
		}

		return 0;
	}

}