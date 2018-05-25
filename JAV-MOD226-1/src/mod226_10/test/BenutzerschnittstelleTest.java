package mod226_10.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mod226_10.mineswepfinal.Benutzerschnittstelle;
import mod226_10.mineswepfinal.Kommando;
import mod226_10.mineswepfinal.Spielfeld;
import mod226_10.mineswepfinal.Zelle;
import mod226_10.mineswepfinal.KuenstlicheIntelligenz;

class BenutzerschnittstelleTest {

	private Benutzerschnittstelle benutzerschnittstelle;
	private Spielfeld spielfeld;

	@BeforeEach
	void setUp() throws Exception {
		spielfeld = new Spielfeld();
		spielfeld.initialisiereZellenInArray();
		benutzerschnittstelle = new Benutzerschnittstelle();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Test zellenArray enthält Zellen Objekte, d.h. Befehl erstelleSpielfeld() erstellt Array mit Objekten, nicht 'leeres' Array")
	void testzeigeZellenArray() {
		assertNotNull(spielfeld.zellenArray[0]);
	}

	@Test
	@DisplayName("Test Standard Zellenrepraesentation auf dem Spielfeld")
	void testzeigeZelle() {
		Zelle zelle = new Zelle();
		assertEquals(" ", zelle.zeichen);
	}

	@Test
	@DisplayName("Test Spielfeld anzeigen")
	void testZeigeSpielfeld() {
		String erwartet = 
				"     0  1  2  3  4  5  6  7\n" +
						"  0  "+"!  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
						"  1  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
						"  2  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
						"  3  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
						"  4  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
						"  5  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
						"  6  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
						"  7  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n";
		Kommando kommando = new Kommando("M", 0, 0);
		kommando.ausfuehren(spielfeld);
		assertEquals(erwartet, benutzerschnittstelle.zeigeSpielfeld(spielfeld));
	}

	@Test
	@DisplayName("Test zeigeEingabeaufforderung")
	void testZeigeEingabeaufforderung() {
		String erwartet =
				"Geben Sie ein Kommando ein:\n" + 
						"T x y (z.B. T 2 3 testet Feld Zeile 2, Spalte 3 auf Mine)\n" +
						"M x y (z.B. M 6 1 kehrt Markierung Feld Zeile 6, Spalte 1)\n";
		assertEquals(erwartet, benutzerschnittstelle.zeigeEingabeaufforderung());
	}

	@Test
	@Disabled
	@DisplayName("Test liesEingabe() bis Umwandlung in Kommando bei gültiger Eingabe")
	void testLiesEingabe() {
		//XXX Fake methode liesEingabe(String testString) erstellt. Dies verstoesst gegen keine Codeteile 2x vorhanden!!
		//FIXME Fake methode und dieser Test nicht zum laufen gebracht, ein Problem ist dieser Test deck bereits zuviele vorgänge ab und scheint eher ein 
		//Integrationstest zu sein. konsequenz Fake methode erst mal wieder gelöscht!

		/*String testString = "M 0 0";
		Kommando testKommando = benutzerschnittstelle.liesEingabe(testString);
		Kommando testObj = new Kommando("M",0,0);
		assertEquals(testObj., testKommando);
		 */
	}

	@Test
	@Disabled
	@DisplayName("Test ErstelleSpielfeld?")
	// TODO erstelle einen Test bzw. bedenke dass das die methode erstelleSpielfeld() erst ein Spielfeld erstellen muss!
	void testErstelleSpielfeld() {}

	@Test
	@DisplayName("Test markiere Zelle[0] via Kommando")
	void testMarkiereZelle0() {
		Kommando kommando = new Kommando("M", 0, 0);
		kommando.ausfuehren(spielfeld);
		assertEquals("!", spielfeld.zellenArray[0].zeichen);
	}

	@Test
	@DisplayName("Test markiere Zelle[9] via Kommando")
	void testMarkiereZelle9() {
		Kommando kommando = new Kommando("M", 1, 1);
		kommando.ausfuehren(spielfeld);
		assertEquals("!", spielfeld.zellenArray[9].zeichen);
	}

	@Test
	@DisplayName("Test markiere Zelle[17] via Kommando")
	void testMarkiereZelle17() {
		Kommando kommando = new Kommando("M", 2, 1);
		kommando.ausfuehren(spielfeld);
		assertEquals("!", spielfeld.zellenArray[17].zeichen);
	}

	@Test
	@DisplayName("Test aufdecken Bombe Zelle[0], Spiel endet")
	void testBombeAufdeckenZelle0() {
		spielfeld.zellenArray[0].setzeBombe();
		Kommando kommando = new Kommando("T", 0, 0);
		//TODO switch to spielEnde() implementieren bei aufdecken
		kommando.ausfuehren(spielfeld);
		assertEquals("*", spielfeld.zellenArray[0].zeichen);
	}

	@Test
	@DisplayName("Test Bombenfelder zufällig auswählen")
	void testBombenfelderAuswaehlen() {
		int gewuenschteBomben = spielfeld.bomben;
		KuenstlicheIntelligenz computer = new KuenstlicheIntelligenz();
		computer.verteileBomben(spielfeld, gewuenschteBomben);
		int verteilteBomben = computer.zaehleVerteilteBomben(spielfeld); 
		assertEquals(gewuenschteBomben, verteilteBomben);
		}
}
