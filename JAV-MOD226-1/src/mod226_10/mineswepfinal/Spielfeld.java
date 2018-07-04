package mod226_10.mineswepfinal;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("6f95d20d-8cb0-4295-b3ee-87d1508129d8")
public class Spielfeld {
	@objid ("e19ea3e3-81a1-4e70-970a-1212868f2036")
	public static int spalten = 8;

	@objid ("8e694de4-f0a9-40a7-9f5d-dedd78104eac")
	public static int zeilen = 8;

	@objid ("080a90b4-179f-468a-b69c-c1700b831e79")
	public int gewuenschteBomben = 10;

	@objid ("66f7561a-c9d2-4609-890f-2c1ccbbfa7a2")
	public static Zelle[][] zellenArray = new Zelle[zeilen][spalten];

	@objid ("99a3ac8b-356e-443f-971a-4e45a293cdb4")
	public List<Zelle> listeBombenOrte;

	@objid ("8357d361-1727-40a7-9732-5b3c132d7471")
	public KuenstlicheIntelligenz kI;

	@objid ("c34c7b64-7e01-4c60-8aaa-f7843ceaddba")
	public void initialisiereZellenInArray() {

		for (int i = 0; i < zeilen; i++) {
			for (int j = 0; j < spalten; j++) {
				zellenArray[i][j] = new Zelle(i, j);
				//	kI.bestimmePositionImSpielfeld(zellenArray[i][j]);
			}
		}
		initialisiereZellenPositionImSpielfeld();  
	}

	public void initialisiereZellenPositionImSpielfeld() {
		// DONE schreibe Automatisierung damit jede Zelle direkt nach init die ZellenPosition erhält.
		// DONE rufe diesen Code Teil bei initialisiereZellenInArray() bzw. erstelle Mutterfunktion welche beides aufruft.
		// DONE Prüfe ob Tests dazu reichen, Teil der Tests dazu bestehen bereits: testbestimmePositionImSpielfeld bzw. kI.bestimmePositionImSpielfeld

		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();

		for (int i = 0; i < zeilen; i++) {
			for (int j = 0; j < spalten; j++) {
				kI.bestimmePositionImSpielfeld(zellenArray[i][j]);
			}
		}	
	}

	@objid ("42058280-1ed2-465b-8f92-4a092121ac35")
	public Spielfeld() {
	}

	// TODO teste diesen Konstruktor. Geht das? Klasse als parameter uebergeben welche die gleiche Klasse ist welche erstellt werden soll?
	@objid ("8b409b3a-b54b-43c4-b752-3ff91e0e07e8")
	public Spielfeld(Spielfeld spielfeld) {
		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		initialisiereZellenInArray();

		kI.verteileBomben(spielfeld, gewuenschteBomben);
		kI.beschrifteNachbarzellenZuBomben(spielfeld);
	}

	@objid ("ab544d4e-773f-417c-b5ab-2ce47c573b9c")
	public Spielfeld(int bomben) {
		initialisiereZellenInArray();
		//        KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		//        kI.verteileBomben(gewuenschteBomben);
		//        kI.beschrifteNachbarzellenZuBomben(spielfeld); // Fehler spielfeld
	}

	@objid ("0cb1bf88-4c70-4a89-9a52-b6c7860df5ae")
	public void erstelleBombenListeOLD() {
		erstelleBombenListe();
	}

	@objid ("a1797932-0fff-4039-8175-c9472d67cb97")
	public void erstelleBombenListe() {
		listeBombenOrte = new ArrayList<Zelle>();

		for (int i = 0; i < zellenArray.length; i++) {
			for (int j = 0; j < zellenArray[i].length; j++) {
				if (zellenArray[i][j].bombe == true) {
					listeBombenOrte.add(zellenArray[i][j]);
				}
			}
		}
	}

	@objid ("fecfddf0-6763-4a03-9079-c5f69d53eaf2")
	public void markieren(int zeile, int spalte) {
		zellenArray[zeile][spalte].zeichen = "!";
	}

	@objid ("d3728ff4-8033-4fad-b938-7c779560a944")
	public void aufdecken(int zeile, int spalte) {
		if (zellenArray[zeile][spalte].bombe == true) {
			zellenArray[zeile][spalte].zeichen = "*";
			//TODO switch to spielEnde();
		}
		else if (0 < zellenArray[zeile][spalte].bombenInNachbarschaft) {
			zellenArray[zeile][spalte].zeichen = String.valueOf(zellenArray[zeile][spalte].bombenInNachbarschaft);
		}
		else {
			zellenArray[zeile][spalte].zeichen = "0";
			KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
			kI.findeNullen(zeile, spalte);
		}
	}

}
