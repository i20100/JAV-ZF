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

	public List<Zelle> listeBombenOrte;

	public KuenstlicheIntelligenz kI;
	//	public List<Integer> listeBombenOrte;

	public static List<Zelle> listeNullenSolve8 = new ArrayList<Zelle>();

	public Spielfeld() {}

	// TODO teste diesen Konstruktor. Geht das? Klasse als parameter übergeben welche die gleiche Klasse ist welche erstellt werden soll?
	public Spielfeld(Spielfeld spielfeld) {
		initialisiereZellenInArray();
		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		kI.verteileBomben(spielfeld, gewuenschteBomben);
		kI.beschrifteNachbarzellenZuBomben(spielfeld);
	}

	public Spielfeld(int bomben) {
		initialisiereZellenInArray();
		//		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		//		kI.verteileBomben(gewuenschteBomben);
		//		kI.beschrifteNachbarzellenZuBomben(spielfeld); // Fehler spielfeld
	}

	@objid ("c34c7b64-7e01-4c60-8aaa-f7843ceaddba")
	public void initialisiereZellenInArray() {
		for (int i = 0; i < zeilen; i++) {
			for (int j = 0; j < spalten; j++) {
				zellenArray[i][j] = new Zelle(i, j);
				
			}
		}
	}

	public void erstelleBombenListeOLD() {
		erstelleBombenListe();
	}

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

	public void markieren(int zeile, int spalte) {
		zellenArray[zeile][spalte].zeichen = "!";
	}

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
			kI.pruefeNachbarzellenKeineBombe(zeile, spalte); //Ersetzen bzw. ausklammern wenn alle Test laufen, auch disabled
			// TODO merke Berechnung der Nachabarbomben muss bereits erfolgt sein
		}

	}

}
