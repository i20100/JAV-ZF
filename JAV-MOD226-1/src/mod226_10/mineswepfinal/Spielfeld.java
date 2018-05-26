package mod226_10.mineswepfinal;

import java.util.List;

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
	public Zelle[] zellenArray = new Zelle[(spalten*zeilen)];

	public int[] listeBombenOrte;
	//	public List<Integer> listeBombenOrte;

	public Spielfeld() {}

	public Spielfeld(Spielfeld spielfeld) {
		initialisiereZellenInArray();
		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		kI.verteileBomben(spielfeld, gewuenschteBomben);
	}


	@objid ("c34c7b64-7e01-4c60-8aaa-f7843ceaddba")
	public void initialisiereZellenInArray() {
		for (int i = 0; i < zellenArray.length; i++) {
			zellenArray[i] = new Zelle();
		}
	}

//	public void erstelleBombenListe() {
////		listeBombenOrte = new int[gewuenschteBomben];
//		listeBombenOrte = new int[gewuenschteBomben];
//		int zaehlerlisteBombenorte = 0;
//		for (int j = 0; j < zellenArray.length; j++) {
//			if (zellenArray[j].bombe == true) {
//				listeBombenOrte[zaehlerlisteBombenorte] = j;
//				zaehlerlisteBombenorte = zaehlerlisteBombenorte+1;
//			}
//		}
//	}

	public void markieren(int zeile, int spalte) {
		int i = spalte + (zeile * 8);
		this.zellenArray[i].zeichen = "!";
	}

	public void aufdecken(int zeile, int spalte) {
		int i = spalte + (zeile * 8);

		if (zellenArray[i].bombe == true) {
			zellenArray[i].zeichen = "*";
			//TODO switch to spielEnde();
		}
		else {
			zellenArray[i].zeichen = String.valueOf(zellenArray[i].bombenInNachbarschaft);
			// TODO umstellen auf zeige versteckte Berechnung benachbarter Bomben
			int nachbarBomben = this.zellenArray[i].findeNachbarBomben();
		}

	}

}
