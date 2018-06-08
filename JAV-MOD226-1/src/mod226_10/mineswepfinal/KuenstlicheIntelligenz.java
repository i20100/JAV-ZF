package mod226_10.mineswepfinal;

import java.util.ArrayList;
import java.util.List;

public class KuenstlicheIntelligenz {
	//	Zugriff auf ZellenArray ändern auf static
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
				//	System.out.println("Bombe auf zeile, spalte:" + zeile + ", " + spalte); //Kommentar ausblenden für detailierte Ausgabe
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
		// TODO aufteilen der Methode?
		// In hole Liste Bomben und wende Methode waahleVariante an
		// mach etwas mit der Antwort aus waehleVariante


		//1. Gehe nur von den Feldern aus welche Bomben besitzen
		//2. Gehe für jedes Feld welche Eine Bombe hat eine Routine durch
		//3. Routine erhöht Bombenzähler auf Zellen
		//4. Es gibt neun Verschiedene Methoden je nach Bombenort
		for (Zelle zelle : spielfeld.listeBombenOrte) {

			int zeile = zelle.yKoordinate;
			int spalte = zelle.xKoordinate;

			switch (waehleVariante(zelle)) {
			case 1:
				bombeObenLinks(spielfeld);
				break;
			case 2:
				bombeObenMitte(spielfeld, spalte);
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
		// gilt nur für Zelle[0][0]!
		// Erhöhe bombenInNachbarschaft für rechts, unten, rechts unten
		Spielfeld.zellenArray[0][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][1].bombenInNachbarschaft += 1;
	}

	public void bombeObenMitte(Spielfeld spielfeld, int spalte) {
		// gilt nur für Zelle[0][1]-[0][Spielfeld.zellenArray.[0].length-1]!
		// Erhöhe bombenInNachbarschaft für links, rechts, unten, unten li. u. re.
		// in Bezug auf aktuelle position!
		Spielfeld.zellenArray[0][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[0][spalte+1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][spalte+1].bombenInNachbarschaft += 1;
	}

	public void bombeObenRechts(Spielfeld spielfeld) {
		// gilt nur für Zelle[0][letzteSpalte]!
		// Erhöhe bombenInNachbarschaft für links, unten, links unten
		Spielfeld.zellenArray[0][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

	public void bombeUntenLinks(Spielfeld spielfeld) {
		// gilt nur für Zelle[letzteZeile][0]!
		// Erhöhe bombenInNachbarschaft für rechts, oben, rechts oben
		Spielfeld.zellenArray[letzteZeile][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][1].bombenInNachbarschaft += 1;
	}

	public void bombeUntenMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt nur für Zelle[letzteZeile][1]-[letzteZeile][Spielfeld.zellenArray.[0].length-1]!
		// Erhöhe bombenInNachbarschaft für links, rechts, oben, oben li. u. re.
		// in Bezug auf aktuelle position!
		Spielfeld.zellenArray[letzteZeile][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile][spalte+1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][spalte+1].bombenInNachbarschaft += 1;
	}

	public void bombeUntenRechts(Spielfeld spielfeld) {
		// gilt nur für Zelle[0][letzteSpalte]!
		// Erhöhe bombenInNachbarschaft für links, oben, links oben
		Spielfeld.zellenArray[letzteZeile][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[letzteZeile-1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

	public void bombeMitteLinks(Spielfeld spielfeld, int zeile) {
		// gilt nur für Zellen[1][0] - [letzteZeile-1][0]!
		// Erhöhe bombenInNachbarschaft für rechts, oben, unten, rechts oben und unten
		Spielfeld.zellenArray[zeile][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][0].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][1].bombenInNachbarschaft += 1;
	}

	public void bombeMitteMitte(Spielfeld spielfeld, int zeile, int spalte) {
		// gilt für alle Zellen welche keinen Rand berühren!
		// Erhöhe bombenInNachbarschaft für links, rechts, oben, unten, oben und unten li. u. re.
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
		// gilt nur für Zelle[1][letzteSpalte] - [letzteZeile-1][letzteSpalte]
		// Erhöhe bombenInNachbarschaft für links, oben, unten, links oben unten
		Spielfeld.zellenArray[zeile][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][letzteSpalte].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile-1][letzteSpalte-1].bombenInNachbarschaft += 1;
		Spielfeld.zellenArray[zeile+1][letzteSpalte-1].bombenInNachbarschaft += 1;
	}

	//	public int waehleVarianteOLD(int[][] ersteBombe) {
	//		return waehleVariante(ersteBombe);
	//	}

	public int waehleVariante(Zelle zelle) {
		int zeile = zelle.yKoordinate;
		int spalte = zelle.xKoordinate;

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
		return 0; // default return 0
	}

	public List<Zelle> pruefeNachbarzellenKeineBombe(int zeile, int spalte) {
		// wird in Aufdecken verwendet um Variante Nullen zeigen einzuleiten anpassen bzw. verweisen auf endgültige findeNullen + Tests wieder enablen
		List<Zelle> zellen = new ArrayList<Zelle>(); 
		zellen.add(Spielfeld.zellenArray[2][2]);
		zellen.add(Spielfeld.zellenArray[2][4]);
		zellen.add(Spielfeld.zellenArray[1][3]);
		zellen.add(Spielfeld.zellenArray[3][3]);
		zellen.add(Spielfeld.zellenArray[1][2]);
		zellen.add(Spielfeld.zellenArray[1][4]);
		zellen.add(Spielfeld.zellenArray[3][2]);
		zellen.add(Spielfeld.zellenArray[3][4]);

		//		for (Zelle zelle : zellen) {
		//			zelle.zeichen = "0";
		//		}	

		//TODO nachdem die Zellen mit Null gefunden wurden, diese in Liste schreiben und weitergeben?
		//??? Wie wird verhindert das eine Feld nicht mehrmals oder ewig geprüft wird? Flag setzen?
		List<Zelle> nachbarZellenMit0 = new ArrayList<>();
		return nachbarZellenMit0;
	}

	public void findeNullen(int zeile, int spalte) {
		// Cheat-Lösung 1
		//		Spielfeld.zellenArray[0][0].zeichen = "0";
		//		Spielfeld.zellenArray[1][0].zeichen = "0";
		//		Spielfeld.zellenArray[2][0].zeichen = "1";
		//		Spielfeld.zellenArray[3][0].zeichen = " ";
		//		Spielfeld.zellenArray[4][0].zeichen = "1";
		//		Spielfeld.zellenArray[5][0].zeichen = "0";
		//		Spielfeld.zellenArray[6][0].zeichen = "1";
		//		Spielfeld.zellenArray[7][0].zeichen = " ";

		// Cheat-Lösung 2
		//		Spielfeld.zellenArray[0][0].zeichen = "0";
		//		Spielfeld.zellenArray[1][0].zeichen = "0";
		//		Spielfeld.zellenArray[2][0].zeichen = "1";
		//
		//		Spielfeld.zellenArray[4][0].zeichen = "1";
		//		Spielfeld.zellenArray[5][0].zeichen = "0";
		//		Spielfeld.zellenArray[6][0].zeichen = "1";

		//DONE liste erstellen? sobald zelle keine bombe ist, und keine nachbarbomben hat, zellen zur liste hinzufügen
		//TODO bis wieder eine bombe kommt, danach neue liste ertellen
		List<Zelle> nullen = new ArrayList<Zelle>();

		for (int j = 0; j < Spielfeld.zellenArray[0].length; j++) {

			for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
				if (Spielfeld.zellenArray[i][j].bombe == false) {
					if (Spielfeld.zellenArray[i][j].bombenInNachbarschaft == 0) {
						nullen.add(Spielfeld.zellenArray[i][j]);
					}
				}
			}
		}

		// Ersetzte Zeichen Zelle mit "0"
		for (Zelle zelle : nullen) {
			zelle.zeichen = Integer.toString(zelle.bombenInNachbarschaft);
		}

		beschrifteZellenZwischenNullUndBombe(nullen);

		//1. check feld auf bombe, wenn ja skip, da nichts mit dem Feld geschehen soll da default wert für Zelle ja " " sein sollte.s
		//2. check ob zelle.nachbarbomben grösser als null, wenn ja mach was, auch nichts,
		// diese Zellen müssen dann von allen nullen aus aufgerufen werden und mit anzahl nachbarbomben beschrieben werden.
		//3. wenn nein, mach das richtige


		// TODO erstelle Listenbzugsattribut pro Zelle
		// TODO erstelle Liste pro neues nicht verbundenes Null in Spalte
		//		List<Zelle> 

	}

	public void beschrifteZellenZwischenNullUndBombe(List<Zelle> nullen) {
		// beschrifte alle Nachbarzellen aus der Liste Nullen mit den Werten 
		// aus zelle.bombeinnachbarschaft
		// Das heisst für jede Zelle gilt ein anderer Schlüssel welche Nachbarzellen
		// zu prüfen sind, wie bei Methode beschrifteNachbarzellenZuBomben
		// TODO da dieses vorgehen bereits einmal angwendet wird bei beschrifteNachbarzellenZuBomben, 
		// dessen methode so anpassen, dass diese für beide Fälle geht!

		// Notiz Ablauf der Auswahl, welche Kriterien sind bei beiden Methoden gleich, wo unterscheiden Sie sich?
		// Beide haben eine Liste von Zellen welche abgearbeitet werden müssen.
		// bei beiden muss dann entsprechend der aktuellen Zelle, alle Benachbarten Zellen gefunden werden und diese manipuliert werden.
		// Die Manipulation ist aber nicht mehr dieselbe bei beiden.
		// Einmal müssen die Bomben in der Nachbarschaft gefunden werden bzw. die Anzahl der Bomben in Nachbarschaft aktualisiert werden
		// Ein andermal muss die Information ob die Nachbarzellen an Bomben angrenzen nun in das Feld .zeichen übertragen werden
		// Anders ausgedrückt, bei beiden muss Anhand einer Zelle alle Nachbarzellen gefunden werden und diese aber unterschiedlich manipuliert werden.
		// Wie müsste nun das Codegerüst dazu aussehen?

		// Listentyp muss gleich sein, Momentan ist es einmal ein int Array und einemal eine Liste vom Typ Zelle
		// Die Liste kann aber schlecht in ein Array umgewandelt werden weil diese dynamisch ist, d.h. dessen Anzahl ist bei Erstellung unbekannt
		// D.h. ist es möglich und Sinnvoll den int Array in eine Liste zu wechseln?
		// das wechseln zur Liste ist kein problem nur das anpassen der Funktionen welche sich auf das Array beziehen umzustellen auf eine Liste...
		// wie kann nachgeschaut werden welche Methoden das int Array benutzen?

		for (Zelle zelle : nullen) {

			switch (waehleVariante(zelle)) {
			case 1:
				NullObenLinks(zelle);
				break;
			case 2:
				NullObenMitte(zelle);
				break;
			case 3:
				NullObenRechts(zelle);
				break;
			case 4:
				NullMitteLinks(zelle);
				break;
			case 5:
				NullMitteMitte(zelle);
				break;
			case 6:
				NullMitteRechts(zelle);
				break;
			case 7:
				NullUntenLinks(zelle);
				break;
			case 8:
				NullUntenMitte(zelle);
				break;
			case 9:
				NullUntenRechts(zelle);
				break;

			default:
				break;
			}
		}


	}

	public void NullUntenRechts(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
	}

	public void NullUntenMitte(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
		zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
	}

	public void NullUntenLinks(Zelle zelle) {
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
	}

	public void NullMitteRechts(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
		zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);	
	}

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

	public void NullMitteLinks(Zelle zelle) {
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
		zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
	}

	public void NullObenRechts(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);	
	}

	public void NullObenMitte(Zelle zelle) {
		zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);	
		zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);	
	}

	public void NullObenLinks(Zelle zelle) {
		zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
		zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
		zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);	
	}

	public void findeNullenSolve8(int zeile, int spalte) {
		// INFORMATION, WIRD DIESE METHODE AUFGERUFEN IST BEREITS KLAR DAS DIESE
		// ZELLE KEINE BOMBE ENTHÄLT UND AUCH KEINE IN DER NACHBARZELLE IST!

		// TODO Randproblem lösen alle Randzellen alle gepruefteXY auf true setzen
		// TODO methode zu Zellenarray erstellen auslagern


		//Liste reseten
		//TODO Liste am Ende löschen! Da Static! gelöst mit Zeile oberhalb?
		//		Spielfeld.listeNullenSolve8 = new ArrayList<Zelle>(); // wird neu bereits in Spielfeld initialisiert
		// aber clear ist jetzt nötig! Liste von allen Einträgen befreien, wenn noch alte drin!
		Spielfeld.listeNullenSolve8.clear();

		// eigene position in liste speichern?
		Spielfeld.listeNullenSolve8.add(Spielfeld.zellenArray[zeile][spalte]);

		// Sezte zeichen für aufgedecktes feld auf Bombe keine aka '0'
		Spielfeld.listeNullenSolve8.get(0).zeichen = Integer.toString(Spielfeld.listeNullenSolve8.get(0).bombenInNachbarschaft);

		//prüfe in Richtung: links
		//		TODO prüfe flag links noch nicht gesetzt
		//		TODO Flag ersetzt auch das Randproblem, kein outofbound wenn flag an jedem rand gesetzt wurde!
		//		DONE prüfe alle zellen links auf ist hatkeineBombe wenn ja zu liste, wenn nein abbruch
		//		DONE nun nimm liste und setze alle zeichen auf "0" und setzte flag links geprüft
		// TODO funktion schreiben für links, oben, rechts, unten welche sich auf jede Zelle anwenden lässt?

		naechsteLinks(Spielfeld.listeNullenSolve8.get(0));
		//		Spielfeld.listeNullenSolve8.add(e)
		Spielfeld.listeNullenSolve8.get(0).geprueftLinks = true;

		// TODO I think not it gives me a concurrentModificationExeption! Read up on this online!
		//		for (Zelle zelle : Spielfeld.listeNullenSolve8) {
		//			naechsteLinks(zelle);
		//		}
	}

	public void naechsteLinks(Zelle zelle) {
		int zeile = zelle.xKoordinate;
		int spalte = zelle.yKoordinate;
		//TODO FIXME Wrap in Exception Handler wenn out of bound! bzw. am Rand!!!
		for (int i = 0; i < spalte; i++) {

			Zelle naechsteZelle = Spielfeld.zellenArray[zeile][spalte-1-i];
			if (naechsteZelle.bombenInNachbarschaft == 0) {
				Spielfeld.listeNullenSolve8.add(naechsteZelle);
				naechsteZelle.zeichen = Integer.toString(naechsteZelle.bombenInNachbarschaft);
				naechsteZelle.geprueftLinks = true;
			} else {
				i = spalte;
			}
		}
	}

}