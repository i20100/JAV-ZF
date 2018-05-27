package mod226_10.mineswepfinal;

public class KuenstlicheIntelligenz {

	public int zaehleVerteilteBomben(Spielfeld spielfeld) {
		int verteilteBomben = 0;
		for (int i = 0; i < spielfeld.zellenArray.length; i++) {
			for (int j = 0; j < spielfeld.zellenArray[i].length; j++) {
				if (spielfeld.zellenArray[i][j].bombe == true)
					verteilteBomben = verteilteBomben+1;
			}
		}
		return verteilteBomben;
	}

	public void bombenVerteilen(Spielfeld spielfeld, int gewuenschteBomben) {
		// TODO verteile Bomben nicht am Rand, würde berechne Nachbarbombenproblem lösen
		int anzahlZellen = 0;
		for (int i = 0; i < spielfeld.zellenArray.length; i++) {
			for (int j = 0; j < spielfeld.zellenArray[i].length; j++) {
				anzahlZellen += 1;
			}
		}

		for (int i = 0; i < gewuenschteBomben; i++) {
			int randomInt = (int) (Math.random()*anzahlZellen);
			int zeile = randomInt/spielfeld.zeilen;
			int spalte = randomInt%spielfeld.zeilen;
			if (spielfeld.zellenArray[zeile][spalte].bombe == false) {
				spielfeld.zellenArray[zeile][spalte].setzeBombe();
			} else {
				i = i-1;
			}
		}
	}

	public void beschrifteNachbarzellenZuBomben(Spielfeld spielfeld) {
		//1. Gehe nur von den Feldern aus welche Bomben besitzen
		//2. Gehe für jedes Feld welche Eine Bombe hat eine Routine durch
		//3. Routine erhöht Bombenzähler auf Zellen
		//4. Es gibt neuen Verschiedene Methode je nach Bombenort

	}

	public void bombeObenLinks(Spielfeld spielfeld) {
		// gilt nur für Zelle[0][0]!
		// Erhöhe bombenInNachbarschaft für rechts, unten, rechts unten
		spielfeld.zellenArray[0][1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[1][0].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[1][1].bombenInNachbarschaft += 1;
	}

	public void bombeObenMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt nur für Zelle[0][1]-[0][spielfeld.zellenArray.[0].length-1]!
		// Erhöhe bombenInNachbarschaft für links, rechts, unten, unten li. u. re.
		// in Bezug auf aktuelle position!
		
		spielfeld.zellenArray[0][spalte-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[0][spalte+1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[1][spalte].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[1][spalte-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[1][spalte+1].bombenInNachbarschaft += 1;
	}
	
	public void bombeObenRechts(Spielfeld spielfeld) {
		// gilt nur für Zelle[0][spielfeld.zellenArray[0].length]!
		// Erhöhe bombenInNachbarschaft für links, unten, links unten
		spielfeld.zellenArray[0][spielfeld.zellenArray[0].length-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[1][spielfeld.zellenArray[0].length].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[1][spielfeld.zellenArray[0].length-1].bombenInNachbarschaft += 1;
	}
	
	public void bombeUntenLinks(Spielfeld spielfeld) {
		// gilt nur für Zelle[spielfeld.zellenArray.length][0]!
		// Erhöhe bombenInNachbarschaft für rechts, oben, rechts oben
		spielfeld.zellenArray[spielfeld.zellenArray.length][1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[spielfeld.zellenArray.length-1][0].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[spielfeld.zellenArray.length-1][1].bombenInNachbarschaft += 1;
	}
	
	public void bombeUntenMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt nur für Zelle[spielfeld.zellenArray.length][1]-[spielfeld.zellenArray.length][spielfeld.zellenArray.[0].length-1]!
		// Erhöhe bombenInNachbarschaft für links, rechts, oben, oben li. u. re.
		// in Bezug auf aktuelle position!
		spielfeld.zellenArray[spielfeld.zellenArray.length][spalte-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[spielfeld.zellenArray.length][spalte+1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[spielfeld.zellenArray.length-1][spalte].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[spielfeld.zellenArray.length-1][spalte-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[spielfeld.zellenArray.length-1][spalte+1].bombenInNachbarschaft += 1;
	}
	
	public void bombeUntenRechts(Spielfeld spielfeld) {
		// gilt nur für Zelle[0][spielfeld.zellenArray[0].length]!
		// Erhöhe bombenInNachbarschaft für links, oben, links oben
		spielfeld.zellenArray[spielfeld.zellenArray.length][spielfeld.zellenArray[0].length-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[spielfeld.zellenArray.length-1][spielfeld.zellenArray[0].length].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[spielfeld.zellenArray.length-1][spielfeld.zellenArray[0].length-1].bombenInNachbarschaft += 1;
	}
	
	public void bombeMitteLinks(Spielfeld spielfeld, int zeile) {
		// gilt nur für Zellen[1][0] - [spielfeld.zellenArray.length-1][0]!
		// Erhöhe bombenInNachbarschaft für rechts, oben, unten, rechts oben und unten
		spielfeld.zellenArray[zeile][1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile-1][0].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile+1][0].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile-1][1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile+1][1].bombenInNachbarschaft += 1;
	}

	public void bombeMitteMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt für alle Zellen welche keinen Rand berühren!
		// Erhöhe bombenInNachbarschaft für links, rechts, oben, unten, oben und unten li. u. re.
		// in Bezug auf aktuelle position!
		
		spielfeld.zellenArray[zeile][spalte-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile][spalte+1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile-1][spalte].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile+1][spalte].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile-1][spalte-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile-1][spalte+1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile+1][spalte-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile+1][spalte+1].bombenInNachbarschaft += 1;
	}
	
	public void bombeMitteRechts(Spielfeld spielfeld, int zeile) {
		// gilt nur für Zelle[1][spielfeld.zellenArray[0].length] - [spielfeld.zellenArray.length-1][spielfeld.zellenArray[0].length]
		// Erhöhe bombenInNachbarschaft für links, oben, unten, links oben unten
		spielfeld.zellenArray[zeile][spielfeld.zellenArray[0].length-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile-1][spielfeld.zellenArray[0].length].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile+1][spielfeld.zellenArray[0].length].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile-1][spielfeld.zellenArray[0].length-1].bombenInNachbarschaft += 1;
		spielfeld.zellenArray[zeile+1][spielfeld.zellenArray[0].length-1].bombenInNachbarschaft += 1;
	}
	
}