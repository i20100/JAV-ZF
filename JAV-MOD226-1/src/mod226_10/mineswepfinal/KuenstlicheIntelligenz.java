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
		//4. Routine merkt wenn Felder nicht angrenzend! Ränder

//		//		simple Version, geht nur ein Objekt in Array davor und dahinter anpassen
//		for (int i = 0; i < spielfeld.listeBombenOrte.length; i++) {
//			int feldEnthaeltBombe = spielfeld.listeBombenOrte[i];
//			//feld davor
//			spielfeld.zellenArray[feldEnthaeltBombe-1].bombenInNachbarschaft += 1;
//			//feld danach
//			spielfeld.zellenArray[feldEnthaeltBombe+1].bombenInNachbarschaft += 1;
//		}
	}

}