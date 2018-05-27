package mod226_10.mineswepfinal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("6f95d20d-8cb0-4295-b3ee-87d1508129d8")
public class Spielfeld {
	@objid ("e19ea3e3-81a1-4e70-970a-1212868f2036")
	public int spalten = 8;

	@objid ("8e694de4-f0a9-40a7-9f5d-dedd78104eac")
	public int zeilen = 8;

	@objid ("080a90b4-179f-468a-b69c-c1700b831e79")
	public int gewuenschteBomben = 10;

	@objid ("66f7561a-c9d2-4609-890f-2c1ccbbfa7a2")
	public Zelle[][] zellenArray = new Zelle[zeilen][spalten];

	public int[][] listeBombenOrte;
	//	public List<Integer> listeBombenOrte;

	public Spielfeld() {}

	public Spielfeld(Spielfeld spielfeld) {
		initialisiereZellenInArray();
		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		kI.bombenVerteilen(spielfeld, gewuenschteBomben);
	}


	@objid ("c34c7b64-7e01-4c60-8aaa-f7843ceaddba")
	public void initialisiereZellenInArray() {
		for (int i = 0; i < zeilen; i++) {
			for (int j = 0; j < spalten; j++) {
				zellenArray[i][j] = new Zelle();
			}
		}
	}

	public void erstelleBombenListe() {
		listeBombenOrte = new int[gewuenschteBomben][2];
		// TEST TODO löschen
		
		System.out.println(listeBombenOrte[0][0]);
		int zaehlerlisteBombenorte = 0;
		for (int i = 0; i < zellenArray.length; i++) {
			for (int j = 0; j < zellenArray[i].length; j++) {
				if (zellenArray[i][j].bombe == true) {
					listeBombenOrte[zaehlerlisteBombenorte][0] = i;
					listeBombenOrte[zaehlerlisteBombenorte][1] = j;
					zaehlerlisteBombenorte += 1;
				}
			}
		}
	}

	public void markieren(int zeile, int spalte) {
		zellenArray[zeile][spalte].zeichen = "!";
	}

	public void aufdecken(int zeile, int spalte) {
		if (zellenArray[zeile][spalte].bombe == true) {
			zellenArray[zeile][spalte].zeichen = "*";
			//TODO switch to spielEnde();
		}
		else {
			zellenArray[zeile][spalte].zeichen = String.valueOf(zellenArray[zeile][spalte].bombenInNachbarschaft);
			// TODO merke Berechnung der Nachabarbomben muss bereits erfolgt sein
		}

	}

}
