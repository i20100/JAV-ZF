package mod226_10.mineswepfinal;

public class KuenstlicheIntelligenz {

	public int zaehleVerteilteBomben(Spielfeld spielfeld) {
		int verteilteBomben = 0;
		for (int i = 0; i < spielfeld.zellenArray.length; i++) {
			if (spielfeld.zellenArray[i].bombe == true)
				verteilteBomben = verteilteBomben+1;
		}
		return verteilteBomben;
	}

	public void verteileBomben(Spielfeld spielfeld, int gewuenschteBomben) {
		int anzahlZellen = spielfeld.zellenArray.length;
		for (int j = 0; j < gewuenschteBomben; j++) {
			int randomInt = (int) (Math.random()*anzahlZellen);
			if (spielfeld.zellenArray[randomInt].bombe == false) {
				spielfeld.zellenArray[randomInt].setzeBombe();
			} else {
				j = j-1;
			}
		}
	}
	
	public void erstelleBombenListe(Spielfeld spielfeld) {
//		listeBombenOrte = new int[gewuenschteBomben];
		int verteilteBomben = zaehleVerteilteBomben(spielfeld);
		spielfeld.listeBombenOrte = new int[verteilteBomben];
		int zaehlerlisteBombenorte = 0;
		for (int j = 0; j < spielfeld.zellenArray.length; j++) {
			if (spielfeld.zellenArray[j].bombe == true) {
				spielfeld.listeBombenOrte[zaehlerlisteBombenorte] = j;
				zaehlerlisteBombenorte = zaehlerlisteBombenorte+1;
			}
		}
	}
	
	public void beschrifteNachbarzellenZuBomben(Spielfeld spielfeld) {
		//1. Gehe nur von den Feldern aus welche Bomben besitzen
		//2. Gehe für jedes Feld welche Eine Bombe hat eine Routine durch
		//3. Routine erhöht Bombenzähler auf Zellen
		//4. Routine merkt wenn Felder nicht angrenzend! Ränder
		
		//simple Version, geht nur ein Objekt in Array davor und dahinter anpassen
		for (int i = 0; i < spielfeld.listeBombenOrte.length; i++) {
			int feldEnthaeltBombe = spielfeld.listeBombenOrte[i];
			//feld davor
			spielfeld.zellenArray[feldEnthaeltBombe-1].bombenInNachbarschaft += 1;
			//feld danach
			spielfeld.zellenArray[feldEnthaeltBombe+1].bombenInNachbarschaft += 1;
		}
	}

}