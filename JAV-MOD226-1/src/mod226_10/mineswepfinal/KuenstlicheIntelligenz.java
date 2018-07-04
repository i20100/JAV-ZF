package mod226_10.mineswepfinal;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("46e5cc34-15f4-4b72-84ad-13048f8e6412")
public class KuenstlicheIntelligenz {
	//    Zugriff auf ZellenArray aendern auf static
	@objid ("31385a50-24ea-46dc-ba35-04b3dd09c5e1")
	int letzteSpalte = Spielfeld.zellenArray[0].length-1;

	@objid ("a42f17a0-80dc-45f1-858e-8dfecb661c61")
	int letzteZeile = Spielfeld.zellenArray.length-1;

	@objid ("73b918c7-b4b3-438c-a653-e29615f82538")
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

	@objid ("84d57aaf-6dc1-4aec-862c-9c32b9ab5846")
	public void verteileBomben(Spielfeld spielfeld, int gewuenschteBomben) {
		int anzahlZellen = zaehleZellen(spielfeld);

		for (int i = 0; i < gewuenschteBomben; i++) {
			int randomInt = (int) (Math.random()*anzahlZellen);
			int zeile = randomInt/Spielfeld.zeilen;
			int spalte = randomInt%Spielfeld.zeilen;
			if (Spielfeld.zellenArray[zeile][spalte].bombe == false) {
				Spielfeld.zellenArray[zeile][spalte].setzeBombe();
				//    System.out.println("Bombe auf zeile, spalte:" + zeile + ", " + spalte); //Kommentar ausblenden faer detailierte Ausgabe
			} else {
				i = i-1;
			}
		}
	}

	@objid ("6f8525a0-0c81-4856-bf4a-7d4b61fc6294")
	public int zaehleZellen(Spielfeld spielfeld) {
		int anzahlZellen = 0;
		for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
			for (int j = 0; j < Spielfeld.zellenArray[i].length; j++) {
				anzahlZellen += 1;
			}
		}
		return anzahlZellen;
	}

	@objid ("0738a83d-d103-4289-96d6-1de3141c59d4")
	public void beschrifteNachbarzellenZuBomben(Spielfeld spielfeld) {
		//1. Gehe nur von den Feldern aus welche Bomben besitzen
		//2. Gehe fuer jedes Feld welche Eine Bombe hat eine Routine durch
		//3. Routine erhoeht Bombenzaehler auf Zellen
		//4. Es gibt neun Verschiedene Methoden je nach Bombenort
		
		for (Zelle zelle : spielfeld.listeBombenOrte) {

			int zeile = zelle.yKoordinate;
			int spalte = zelle.xKoordinate;

			switch (zelle.positionImSpielfeld) {
			case OBENLINKS:
				bombeObenLinks(spielfeld);
				break;
			case OBEN:
				bombeObenMitte(spielfeld, spalte);
				break;
			case OBENRECHTS:
				bombeObenRechts(spielfeld);
				break;
			case LINKS:
				bombeMitteLinks(spielfeld, zeile);
				break;
			case MITTE:
				bombeMitteMitte(spielfeld, zeile, spalte);
				break;
			case RECHTS:
				bombeMitteRechts(spielfeld, zeile);
				break;
			case UNTENLINKS:
				bombeUntenLinks(spielfeld);
				break;
			case UNTEN:
				bombeUntenMitte(spielfeld, zeile, spalte);
				break;
			case UNTENRECHTS:
				bombeUntenRechts(spielfeld);
				break;

			default:
				break;
			}
		}
	}

	@objid ("ef8c618b-173c-4987-8018-7452e85e4b1e")
	public void bombeObenLinks(Spielfeld spielfeld) {
		// gilt nur fuer Zelle[0][0]!
		// Erhuehe bombenInNachbarschaft fuer rechts, unten, rechts unten
		Spielfeld.zellenArray[0][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][1].bombenInNachbarschaft += 1;
	}

	@objid ("9ffa8cc9-bc73-4dc9-9ffd-7b4ea2c4d24a")
	public void bombeObenMitte(Spielfeld spielfeld, int spalte) {
		// gilt nur fuer Zelle[0][1]-[0][Spielfeld.zellenArray.[0].length-1]!
		// Erhuehe bombenInNachbarschaft fuer links, rechts, unten, unten li. u. re.
		// in Bezug auf aktuelle position!
		Spielfeld.zellenArray[0][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[0][spalte+1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte+1].bombenInNachbarschaft += 1;
	}

	@objid ("1d67b988-0ace-4810-99be-19ab968ab416")
	public void bombeObenRechts(Spielfeld spielfeld) {
		// gilt nur fuer Zelle[0][letzteSpalte]!
		// Erhuehe bombenInNachbarschaft fuer links, unten, links unten
		Spielfeld.zellenArray[0][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

	@objid ("77044783-0d3c-42b8-80fa-aa1fb5550161")
	public void bombeUntenLinks(Spielfeld spielfeld) {
		// gilt nur fuer Zelle[letzteZeile][0]!
		// Erhuehe bombenInNachbarschaft fuer rechts, oben, rechts oben
		Spielfeld.zellenArray[letzteZeile][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][1].bombenInNachbarschaft += 1;
	}

	@objid ("d377ccf7-cbd5-4777-a7b5-e522824525d1")
	public void bombeUntenMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt nur fuer Zelle[letzteZeile][1]-[letzteZeile][Spielfeld.zellenArray.[0].length-1]!
		// Erhuehe bombenInNachbarschaft fuer links, rechts, oben, oben li. u. re.
		// in Bezug auf aktuelle position!
		Spielfeld.zellenArray[letzteZeile][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile][spalte+1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte+1].bombenInNachbarschaft += 1;
	}

	@objid ("fa1b53a9-1c20-4a91-b480-0180cecaa9ad")
	public void bombeUntenRechts(Spielfeld spielfeld) {
		// gilt nur fuer Zelle[0][letzteSpalte]!
		// Erhuehe bombenInNachbarschaft fuer links, oben, links oben
		Spielfeld.zellenArray[letzteZeile][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

	@objid ("14417964-d247-45e8-839f-4a9c6f835a11")
	public void bombeMitteLinks(Spielfeld spielfeld, int zeile) {
		// gilt nur fuer Zellen[1][0] - [letzteZeile-1][0]!
		// Erhuehe bombenInNachbarschaft fuer rechts, oben, unten, rechts oben und unten
		Spielfeld.zellenArray[zeile][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][1].bombenInNachbarschaft += 1;
	}

	@objid ("75859d58-f758-4741-beca-691f79181b99")
	public void bombeMitteMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt fuer alle Zellen welche keinen Rand beruehren!
		// Erhuehe bombenInNachbarschaft fuer links, rechts, oben, unten, oben und unten li. u. re.
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

	@objid ("ff012d49-7eb0-44cb-940c-184407e11afd")
	public void bombeMitteRechts(Spielfeld spielfeld, int zeile) {
		// gilt nur fuer Zelle[1][letzteSpalte] - [letzteZeile-1][letzteSpalte]
		// Erhuehe bombenInNachbarschaft fuer links, oben, unten, links oben unten
		Spielfeld.zellenArray[zeile][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

	@objid ("b99664e7-1281-4e05-800a-776f3b0cc22d")
	public PositionImSpielfeld bestimmePositionImSpielfeld (Zelle zelle) {
		// DONE methode umbennen auf bestimmePositionImSpielfeld
		// DONE del waehleVarianteOLD, wenn alle Tests umgebaut!
		// DONE wahleVariante umbauen, neue Attribute enum PositionImSpielfeld verwenden->

		int zeile = zelle.yKoordinate;
		int spalte = zelle.xKoordinate;

		if (zeile == 0) {
			if (spalte == 0) {
				zelle.positionImSpielfeld = PositionImSpielfeld.OBENLINKS;
			} 
			if (spalte == Spielfeld.spalten-1) {
				zelle.positionImSpielfeld = PositionImSpielfeld.OBENRECHTS;
			}
			else if (spalte > 0 && spalte < Spielfeld.spalten-1) {
				zelle.positionImSpielfeld = PositionImSpielfeld.OBEN;
			}
		}

		if (zeile == Spielfeld.zeilen-1) {
			if (spalte == 0) {
				zelle.positionImSpielfeld = PositionImSpielfeld.UNTENLINKS;
			} 
			if (spalte == Spielfeld.spalten-1) {
				zelle.positionImSpielfeld = PositionImSpielfeld.UNTENRECHTS;
			}
			else if (spalte > 0 && spalte < Spielfeld.spalten-1) {
				zelle.positionImSpielfeld = PositionImSpielfeld.UNTEN;
			}
		}

		if (zeile < Spielfeld.zeilen-1 && zeile > 0) {
			if (spalte == 0) {
				zelle.positionImSpielfeld = PositionImSpielfeld.LINKS;
			} 
			if (spalte == Spielfeld.spalten-1) {
				zelle.positionImSpielfeld = PositionImSpielfeld.RECHTS;
			}
			else if (spalte > 0 && spalte < Spielfeld.spalten-1) {
				zelle.positionImSpielfeld = PositionImSpielfeld.MITTE;
			}
		}
		return zelle.positionImSpielfeld; // TODO löschen, wenn findeNullen dies nicht mehr braucht
	}

	@objid ("9c549826-4bdb-49eb-b4e1-8292fa875515")
	public void findeNullen(int zeile, int spalte) {

		List<Zelle> nullen = new ArrayList<Zelle>();

		findeNachbarNullZellen(nullen);
		beschrifteNachbarNullMitNull(nullen);
		beschrifteZellenZwischenNullUndBombe(nullen);

		//1. check feld auf bombe, wenn ja skip, da nichts mit dem Feld geschehen soll da default wert fuer Zelle ja " " sein sollte.s
		//2. check ob zelle.nachbarbomben groesser als null, wenn ja mach was, auch nichts,
		// diese Zellen muessen dann von allen nullen aus aufgerufen werden und mit anzahl nachbarbomben beschrieben werden.
		//3. wenn nein, mach das richtige

		// TODO erstelle Listenbezugsattribut pro Zelle
	}

	@objid ("c2fbf017-7d23-42b9-a64f-504fa8451011")
	public void findeNachbarNullZellen(List<Zelle> nullen) {
		// FIXME unterscheide verbunden mit Aufdeckort und nicht verbunden: nicht verbundene Zellen duerfen nicht in die Liste aufgenommen werden!
		// FIXME findet ALLE Nullen auf dem Spielfeld! ALLE! 
		for (int j = 0; j < Spielfeld.zellenArray[0].length; j++) {
			for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
				if (Spielfeld.zellenArray[i][j].bombe == false) {
					if (Spielfeld.zellenArray[i][j].bombenInNachbarschaft == 0) {
						nullen.add(Spielfeld.zellenArray[i][j]);
					}
				}
			}
		}
	}

	@objid ("847e7ea8-dacf-40b0-b15c-864238719a12")
	public void beschrifteNachbarNullMitNull(List<Zelle> nullen) {
		for (Zelle zelle : nullen) {
			zelle.zeichen = Integer.toString(zelle.bombenInNachbarschaft);
		}
	}

	@objid ("d576208c-655d-4a94-a1a6-1a5f29e1b72c")
	public void beschrifteZellenZwischenNullUndBombe(List<Zelle> nullen) {
		// beschrifte alle Nachbarzellen aus der Liste Nullen mit den Werten 
		// aus zelle.bombeinnachbarschaft
		// Das heisst fuer jede Zelle gilt ein anderer Schluessel welche Nachbarzellen
		// zu pruefen sind, wie bei Methode beschrifteNachbarzellenZuBomben
		// TODO da dieses vorgehen bereits einmal angwendet wird bei beschrifteNachbarzellenZuBomben, 
		// dessen methode so anpassen, dass diese fuer beide Faelle geht!

		// Notiz: Ablauf der Auswahl, welche Kriterien sind bei beiden Methoden gleich, wo unterscheiden Sie sich?
		// Beide haben eine Liste von Zellen welche abgearbeitet werden muessen.
		// bei beiden muss dann entsprechend der aktuellen Zelle, alle Benachbarten Zellen gefunden werden und diese manipuliert werden.
		// Die Manipulation ist aber nicht mehr dieselbe bei beiden.
		// Einmal muessen die Bomben in der Nachbarschaft gefunden werden bzw. die Anzahl der Bomben in Nachbarschaft aktualisiert werden
		// Ein andermal muss die Information ob die Nachbarzellen an Bomben angrenzen nun in das Feld .zeichen uebertragen werden
		// Anders ausgedrueckt, bei beiden muss Anhand einer Zelle alle Nachbarzellen gefunden werden und diese aber unterschiedlich manipuliert werden.
		// Wie muesste nun das Codegeruest dazu aussehen?

		// Listentyp muss gleich sein, Momentan ist es einmal ein int Array und einemal eine Liste vom Typ Zelle
		// Die Liste kann aber schlecht in ein Array umgewandelt werden weil diese dynamisch ist, d.h. dessen Anzahl ist bei Erstellung unbekannt
		// D.h. ist es moeglich und Sinnvoll den int Array in eine Liste zu wechseln?
		// das wechseln zur Liste ist kein problem nur das anpassen der Funktionen welche sich auf das Array beziehen umzustellen auf eine Liste...
		// wie kann nachgeschaut werden welche Methoden das int Array benutzen?

		for (Zelle zelle : nullen) {

			switch (zelle.positionImSpielfeld) {
			case OBENLINKS:
				NullObenLinks(zelle);
				break;
			case OBEN:
				NullObenMitte(zelle);
				break;
			case OBENRECHTS:
				NullObenRechts(zelle);
				break;
			case LINKS:
				NullMitteLinks(zelle);
				break;
			case MITTE:
				NullMitteMitte(zelle);
				break;
			case RECHTS:
				NullMitteRechts(zelle);
				break;
			case UNTENLINKS:
				NullUntenLinks(zelle);
				break;
			case UNTEN:
				NullUntenMitte(zelle);
				break;
			case UNTENRECHTS:
				NullUntenRechts(zelle);
				break;

			default:
				break;
			}
		}
	}

	@objid ("f47dc93e-72bf-4319-9718-ef7142ef1338")
	public void NullUntenRechts(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
	}

	@objid ("78d4f7f8-210b-4a19-a2e0-279d5b3fea0e")
	public void NullUntenMitte(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
		zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
	}

	@objid ("631f0061-875f-49f0-9f0c-e3f424fe3cb5")
	public void NullUntenLinks(Zelle zelle) {
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
	}

	@objid ("b4cdd8f3-ea23-4250-9ddd-5c350a668c8a")
	public void NullMitteRechts(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
		zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);
	}

	@objid ("0c7cee93-ab66-4cdb-a6ef-bf36da610521")
	public void NullMitteMitte(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
		zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);    
		zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
		zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
	}

	@objid ("3f35f70f-62eb-477f-af42-996640db4893")
	public void NullMitteLinks(Zelle zelle) {
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
		zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
	}

	@objid ("09aa2fb6-ca86-4885-8504-666efa4a8da2")
	public void NullObenRechts(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);
	}

	@objid ("8fd5c9bc-6666-42c3-b5d9-cc557580a12d")
	public void NullObenMitte(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);    
		zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
	}

	@objid ("b6767ed9-e17b-4325-8c1d-adb55726d615")
	public void NullObenLinks(Zelle zelle) {
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
	}

	@objid ("9e4456f0-edbd-43e2-a013-f27dff0631ce")
	public void kreuzSuche() {
	}

}
