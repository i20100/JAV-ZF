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

}