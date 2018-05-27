package mod226_10.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import mod226_10.mineswepfinal.Benutzerschnittstelle;
import mod226_10.mineswepfinal.Kommando;
import mod226_10.mineswepfinal.Spielfeld;
import mod226_10.mineswepfinal.Zelle;
import mod226_10.mineswepfinal.KuenstlicheIntelligenz;

class BenutzerschnittstelleTest {

	private Benutzerschnittstelle benutzerschnittstelle;
	private Spielfeld spielfeld;
	private KuenstlicheIntelligenz kI;

	@BeforeEach
	void setUp() throws Exception {
		spielfeld = new Spielfeld();
		spielfeld.initialisiereZellenInArray();
		benutzerschnittstelle = new Benutzerschnittstelle();
	}

	@Nested
	@DisplayName("Zelle Tests")
	class TestZelle {

		@Test
		@DisplayName("Test Standard Zellenrepraesentation auf dem Spielfeld")
		void testzeigeZelle() {
			Zelle zelle = new Zelle();
			assertEquals(" ", zelle.zeichen);
		}
	}

	@Nested
	@DisplayName("Spielfeld Tests")
	class TestSpielfeld {

		@Test
		@DisplayName("Test zellenArray enthält Zellen Objekte, d.h. Befehl erstelleSpielfeld() erstellt Array mit Objekten, nicht 'leeres' Array")
		void testzeigeZellenArray() {
			assertNotNull(spielfeld.zellenArray[0]);
		}
		
		@Test
		@DisplayName("Test initialisiereZellenInArray")
		void testinitialisiereZellenInArray() {
			assertNotNull(spielfeld.zellenArray[0][0]);
		}
		
		@Test
		@DisplayName("Test erstelleBombenListe")
		void testerstelleBombenListe() {
			spielfeld.zellenArray[0][3].setzeBombe();
			spielfeld.erstelleBombenListe();
			assertEquals(0, spielfeld.listeBombenOrte[0][0]);
			assertEquals(3, spielfeld.listeBombenOrte[0][1]);
		}
		
		@Test
		@Disabled
		@DisplayName("Test ErstelleSpielfeld?")
		// TODO erstelle einen Test bzw. bedenke dass das die methode erstelleSpielfeld() erst ein Spielfeld erstellen muss!
		void testErstelleSpielfeld() {}
		
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

	@Nested
	@DisplayName("Kommando Tests")
	class TestKommando {

		@Test
		@DisplayName("Test markiere Zelle[0][0] via Kommando")
		void testMarkiereZelle00() {
			Kommando kommando = new Kommando("M", 0, 0);
			kommando.ausfuehren(spielfeld);
			assertEquals("!", spielfeld.zellenArray[0][0].zeichen);
		}

		@Test
		@DisplayName("Test markiere Zelle[2][1] via Kommando")
		void testMarkiereZelle21() {
			Kommando kommando = new Kommando("M", 2, 1);
			kommando.ausfuehren(spielfeld);
			assertEquals("!", spielfeld.zellenArray[2][1].zeichen);
		}

		@Test
		@DisplayName("Test aufdecken Bombe Zelle[0][0], Spiel endet")
		void testBombeAufdeckenZelle00() {
			spielfeld.zellenArray[0][0].setzeBombe();
			Kommando kommando = new Kommando("T", 0, 0);
			//TODO switch to spielEnde() implementieren bei aufdecken
			kommando.ausfuehren(spielfeld);
			assertEquals("*", spielfeld.zellenArray[0][0].zeichen);
		}

		@Test
		@DisplayName("Test aufdecken Bombe Zelle[2][3], Spiel endet")
		void testBombeAufdeckenZelle23() {
			spielfeld.zellenArray[2][3].setzeBombe();
			Kommando kommando = new Kommando("T", 2, 3);
			kommando.ausfuehren(spielfeld);
			assertEquals("*", spielfeld.zellenArray[2][3].zeichen);
		}

		@Test
		@Disabled
		@DisplayName("@Disabled bis Methode aufdecken mit  Variante läuft!"
				+ "Test aufdecken Zelle[0][2] welche Nachbar zu Bombe[0][1] ist, Rückmeldung BombenAnzahl")
		void testNachbarzelleZuBombeAufdecken() {
			spielfeld.zellenArray[0][1].setzeBombe();
			KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
			spielfeld.erstelleBombenListe();
			kI.beschrifteNachbarzellenZuBomben(spielfeld);
			Kommando kommando = new Kommando("T", 0, 2);
			kommando.ausfuehren(spielfeld);
			System.out.println("Test aufdecken Zelle[0][2] zu Bombe[0][1]");
			System.out.println(benutzerschnittstelle.zeigeSpielfeld(spielfeld));
			assertEquals("1", spielfeld.zellenArray[0][2].zeichen);
		}
	}

	@Nested
	@DisplayName("Variante Nachbarzellenbeschriften beschrifteNachbarzellenZuBomben")
	class TestbeschrifteNachbarzellenZuBomben {

		@BeforeEach
		void setUp() throws Exception {
			spielfeld = new Spielfeld();
			spielfeld.initialisiereZellenInArray();
			benutzerschnittstelle = new Benutzerschnittstelle();
			kI = new KuenstlicheIntelligenz();
		}

		@Test
		@DisplayName("Test bombeObenLinks, NOTE: Return is int not String!")
		void testbombeObenLinks() {
			spielfeld.zellenArray[0][0].setzeBombe();
			kI.bombeObenLinks(spielfeld);

			assertEquals(true, spielfeld.zellenArray[0][0].bombe);
			assertEquals(1, spielfeld.zellenArray[0][1].bombenInNachbarschaft);
			assertEquals(1, spielfeld.zellenArray[1][0].bombenInNachbarschaft);
			assertEquals(1, spielfeld.zellenArray[1][1].bombenInNachbarschaft);
		}

		@Test
		@DisplayName("Test bombeObenMitte")
		void testbombeObenMitte() {
			spielfeld.zellenArray[0][1].setzeBombe();
			kI.bombeObenMitte(spielfeld, 0, 1);

			assertEquals(true, spielfeld.zellenArray[0][1].bombe);
			assertEquals(1, spielfeld.zellenArray[0][0].bombenInNachbarschaft);
			assertEquals(1, spielfeld.zellenArray[0][2].bombenInNachbarschaft);
			assertEquals(1, spielfeld.zellenArray[1][1].bombenInNachbarschaft);
			assertEquals(1, spielfeld.zellenArray[1][0].bombenInNachbarschaft);
			assertEquals(1, spielfeld.zellenArray[1][2].bombenInNachbarschaft);
		}
		
		@Test
		@DisplayName("Test bombeObenRechts")
		void testbombeObenRechts() {
//			spielfeld.zellenArray[0][spielfeld.zellenArray[0].length].setzeBombe();
			spielfeld.zellenArray[0][7].setzeBombe();
//			kI.bombeObenRechts(spielfeld);
			
			System.out.println("actual value of spielfeld.zellenArray[0].length: "+ spielfeld.zellenArray[0].length);

//			assertEquals(true, spielfeld.zellenArray[0][spielfeld.zellenArray[0].length].bombe);
			assertEquals(true, spielfeld.zellenArray[0][7].bombe);
//			assertEquals(1, spielfeld.zellenArray[0][spielfeld.zellenArray[0].length-1].bombenInNachbarschaft);
//			assertEquals(1, spielfeld.zellenArray[1][spielfeld.zellenArray[0].length].bombenInNachbarschaft);
//			assertEquals(1, spielfeld.zellenArray[1][spielfeld.zellenArray[0].length].bombenInNachbarschaft);
		}
		
		
	}

	@Test
	@DisplayName("Test Bomben zufällig verteilen")
	void testBombenVerteilen() {
		int gewuenschteBomben = spielfeld.gewuenschteBomben;
		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		kI.bombenVerteilen(spielfeld, gewuenschteBomben);
		int verteilteBomben = kI.zaehleVerteilteBomben(spielfeld); 
		assertEquals(gewuenschteBomben, verteilteBomben);
	}

	@Test
	@DisplayName("?? Teste gewünschte = verteilte Bomben")
	// TODO evlt. muss noch ein Test erstellt werden für bombenVerteilen
	void testverteilteBomben() {
		int gewuenschteBomben = spielfeld.gewuenschteBomben;
		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		kI.bombenVerteilen(spielfeld, gewuenschteBomben);
		spielfeld.erstelleBombenListe();
		assertEquals(gewuenschteBomben, spielfeld.listeBombenOrte.length);
		assertEquals(2, spielfeld.listeBombenOrte[0].length);

		int zeileBombenliste = spielfeld.listeBombenOrte[0][0];
		int spalteBombenliste = spielfeld.listeBombenOrte[0][1];
		spielfeld.aufdecken(zeileBombenliste, spalteBombenliste);
		String zeichenReferenz =spielfeld.zellenArray[zeileBombenliste][spalteBombenliste].zeichen;
		assertEquals("*", zeichenReferenz);
	}

}
