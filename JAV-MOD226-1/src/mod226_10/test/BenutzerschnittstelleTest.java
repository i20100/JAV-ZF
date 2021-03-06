package mod226_10.test;

import mod226_10.mineswepfinal.Benutzerschnittstelle;
import mod226_10.mineswepfinal.Kommando;
import mod226_10.mineswepfinal.KuenstlicheIntelligenz;
import mod226_10.mineswepfinal.Minesweeper;
import mod226_10.mineswepfinal.PositionImSpielfeld;
import mod226_10.mineswepfinal.Spielfeld;
import mod226_10.mineswepfinal.Validator;
import mod226_10.mineswepfinal.Zelle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BenutzerschnittstelleTest {


	private Benutzerschnittstelle benutzerschnittstelle;
	private Spielfeld spielfeld;
	private KuenstlicheIntelligenz kI;
	private Validator validator;


	@BeforeEach
	void setUp() throws Exception {
		spielfeld = new Spielfeld(); // 1st Spielfeld -> 1st ZellenArray
		//		spielfeld.initialisiereZellenInArray();
		benutzerschnittstelle = new Benutzerschnittstelle();
	}

	@Nested
	class MinesweeperTest {
		//		private Minesweeper ms = new Minesweeper(); // // 2nd Spielfeld -> 2nd ZellenArray
		Minesweeper ms = new Minesweeper(); // // 2nd Spielfeld -> 2nd ZellenArray

		@BeforeEach
		void setUp() throws Exception {
			Spielfeld.listeAllerZellen.clear(); // N�tig, weil initialisiereZellenInArray mehrmals laeuft. Nur bei Testklasse der Fall.
			spielfeld.initialisiereZellenInArray();
		}

		@Test
		void testSpielfeldListeAllerZellen() {
			assertEquals(64, Spielfeld.listeAllerZellen.size());
		}

		@Test
		void testSpielLaeuftGewonnen() {
			Spielfeld.zellenArray[4][4].setzeBombe();
			Kommando kommando = new Kommando("T", 0, 0);
			kommando.ausfuehren(spielfeld);

			assertEquals("0", Spielfeld.zellenArray[0][0].zeichen);

			kommando = new Kommando("M", 4, 4);
			kommando.ausfuehren(spielfeld);
			assertEquals("!", Spielfeld.zellenArray[4][4].zeichen);

			// DONE erstelleBombenListe() zu static Methode wechseln
			// DONE alle verweise zu erstelleBombenListe() aendern zu static
			// TODO alle Verweise zu ListeAllerBomben bei tear down loeschen, d.h
			// if not null set clear Liste

			spielfeld.erstelleBombenListe();
			assertEquals(1, Spielfeld.listeBomben.size());
			assertEquals(64, Spielfeld.listeAllerZellen.size());

			// TODO teste alle Felder nicht mehr " " als Zeichen. -> entspricht Spiel gewonnen
			// in Minesweeper angepasst -> nichtAufgedeckteFelder == 0 -> spielLaeuft false
			System.out.println("Spielfeld.listeAllerZellen.size():");
			System.out.println(Spielfeld.listeAllerZellen.size());
			for (Zelle zelle : Spielfeld.listeAllerZellen) {
				if (zelle.zeichen != " ") {
					System.out.println("zeichen ! \" \":");
					System.out.println(zelle.zeichen);
					System.out.println("y, x koord: "+ zelle.yKoordinate + ", " + zelle.xKoordinate );
				}
				if (zelle.zeichen == " ") {
					System.out.println("zeichen ist \" \":");
					System.out.println(zelle.zeichen);
					System.out.println("y, x koord: "+ zelle.yKoordinate + ", " + zelle.xKoordinate );
				}
			}

			ms.spielLaeuft();
			assertFalse(ms.spielLaeuft());
		}

		@Test
		void testSpielLaeuftVerloren() {
			Spielfeld.zellenArray[2][3].setzeBombe();
			Kommando kommando = new Kommando("T", 2, 3);
			kommando.ausfuehren(spielfeld);

			assertEquals("*", Spielfeld.zellenArray[2][3].zeichen);

			// test oben nur kopie von woanders!
			// zweiter Schritt

			// DONE Problem die Bombe wird gar nie gefunden bei ms.spielLaeuft()
			// verdacht, problem mit Liste, Problem geloest indem  
			// alt, noch ohne Static bei spielfeld
			//			for (Zelle zelle : spielfeld.listeAllerZellen) {
			// Loesung -> 
			// 				for (Zelle zelle : Spielfeld.listeAllerZellen) {
			//			bedingt bei Spielfeld: 
			//			public static List<Zelle> listeAllerZellen = new ArrayList<Zelle>();

			spielfeld.erstelleBombenListe();
			assertEquals(64, Spielfeld.listeAllerZellen.size());

			ms.spielLaeuft();
			assertFalse(ms.spielLaeuft());
		}

	}


	@Nested
	@DisplayName("class TestSpielfeld")
	class TestSpielfeld {

		@Test
		@DisplayName("Test zellenArray enthaelt Zellen Objekte, d.h. Befehl erstelleSpielfeld() erstellt Array mit Objekten, nicht 'leeres' Array")
		void testzeigeZellenArray() {
			assertNotNull(Spielfeld.zellenArray[0]);
		}


		@Test
		void testInitialisiereZellenInArray() {
			assertNotNull(Spielfeld.zellenArray[0][0]);
			assertEquals(Spielfeld.zeilen, Spielfeld.zellenArray.length);
			assertEquals(Spielfeld.spalten, Spielfeld.zellenArray[0].length);
		}

		@Test
		void testPositionImSpielfeldGesetztNachInitialisiereZellenInArray() {
			assertEquals(PositionImSpielfeld.OBENLINKS, Spielfeld.zellenArray[0][0].positionImSpielfeld);
		}

		@Test
		void testInitialisiereListeAllerZellen() {
			assertNotNull(Spielfeld.zellenArray[0][0]);
			assertEquals(64, Spielfeld.listeAllerZellen.size());

			// alt war es nicht static -> neu gibt es ueber 8000 Eintraege in der Liste!
			// DONE erstelle fuer jeden Test breakdown, via clear Liste geloest
			//assertEquals(64, spielfeld.listeAllerZellen.size());
		}


		@Test
		@DisplayName("Test erstelleBombenListe")
		void testerstelleBombenListe() {
			Spielfeld.zellenArray[0][3].setzeBombe();
			spielfeld.erstelleBombenListe();
			assertEquals(0, Spielfeld.listeBomben.get(0).yKoordinate);
			assertEquals(3, Spielfeld.listeBomben.get(0).xKoordinate);
		}


		@Test
		@DisplayName("Test erstelleBombenListe mehrere Eintraege")
		void testerstelleBombenListeMulti() {
			Spielfeld.zellenArray[0][3].setzeBombe();
			Spielfeld.zellenArray[1][3].setzeBombe();
			spielfeld.erstelleBombenListe();
			assertEquals(0, Spielfeld.listeBomben.get(0).yKoordinate);
			assertEquals(3, Spielfeld.listeBomben.get(0).xKoordinate);
			assertEquals(1, Spielfeld.listeBomben.get(1).yKoordinate);
			assertEquals(3, Spielfeld.listeBomben.get(1).xKoordinate);
		}


		@Test
		void testErstelleSpielfeld() {
			String erwartet = 
					"     0  1  2  3  4  5  6  7\n" +
							"  0  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  1  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  2  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  3  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  4  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  5  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  6  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  7  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n";
			assertEquals(erwartet, benutzerschnittstelle.zeigeSpielfeld(spielfeld));
		}

		@Test
		void testZeigeSpielfeld() {
			// TODO schreibe test welcher sicherstellt das zeigeSpielfeld auch ein Spielfeld 
			// ausgibt! nicht nur das Objekt als return wert!
			String erwartet = 
					"     0  1  2  3  4  5  6  7\n" +
							"  0  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  1  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  2  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  3  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  4  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  5  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  6  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
							"  7  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n";
			assertEquals(erwartet, benutzerschnittstelle.zeigeSpielfeld(spielfeld));
		}

		@Nested
		@DisplayName("class EingabeAusgabe")
		class EingabeAusgabe {

			@Test
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
			void testZeigeEingabeaufforderung() {
				String erwartet =
						"Geben Sie ein Kommando ein:\n" + 
								"T y x (z.B. T 2 3 testet Feld Zeile 2, Spalte 3 auf Mine)\n" +
								"M y x (z.B. M 6 1 kehrt Markierung Feld Zeile 6, Spalte 1)\n";
				assertEquals(erwartet, benutzerschnittstelle.zeigeEingabeaufforderung());
			}

			@Test
			void testZeigeSpielabbruch() {
				String erwartet =
						"Um das Spiel zu Beenden, schliesse dieses Fenster oder druecke Enter.";
				// TODO Problem nun erwartet zeigeSpielabbruch ein Enter als Eingabe.. wie soll dies getestet werden? Test haengt sich selber hier auf...
				assertEquals(erwartet, benutzerschnittstelle.zeigeSpielabbruch());
			}

			@Test
			@Disabled
			@DisplayName("Test liesEingabe() bis Umwandlung in Kommando bei gueltiger Eingabe")
			void testLiesEingabe() {
				//XXX Fake methode liesEingabe(String testString) erstellt. Dies verstoesst gegen keine Codeteile 2x vorhanden!!
				//FIXME Fake methode und dieser Test nicht zum laufen gebracht, ein Problem ist dieser Test deck bereits zuviele vorgaenge ab und scheint eher ein 
				//Integrationstest zu sein. konsequenz Fake methode erst mal wieder geloescht!

				//			
				//			String testString = "M 0 0";
				//                    Kommando testKommando = benutzerschnittstelle.liesEingabe(testString);
				//                    Kommando testObj = new Kommando("M",0,0);
				//                    assertEquals(testObj., testKommando);
				//			
			}

			@Test
			void testZeigeSpielfeldSpielEnde() {
				Spielfeld.zellenArray[0][1].setzeBombe();
				String erwartetesSpielfeld = 
						"     0  1  2  3  4  5  6  7\n" +
								"  0  "+"   "+"*  "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
								"  1  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
								"  2  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
								"  3  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
								"  4  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
								"  5  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
								"  6  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n" + 
								"  7  "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"\n";
				String erwarteteSchlussmeldung = "Mine explodiert, Spiel beendet.";

				Kommando kommando = new Kommando("T", 0, 1);
				kommando.ausfuehren(spielfeld);

				assertEquals(2, Spielfeld.schlussmeldungsNummer);
				assertEquals(erwartetesSpielfeld, benutzerschnittstelle.zeigeSpielfeld(spielfeld));
				assertEquals(erwarteteSchlussmeldung, benutzerschnittstelle.zeigeSchlussmeldung());
				// XXX Eigentlich wird nicht die Textausgabe auf der Konsole gepfrueft,
				// sondern nur erwarteteSchlussmeldung Objekt == String Text
				// es wird aber nicht der Return Wert in der Konsole ausgegeben
				// sondern in der Methode wird der Text via syso ausgegeben. Dies wird 
				// aber hier nirgends gepr�ft. Anders ausgedrueckt wird die Ausgabe syso aufgehoben,
				// der Text erscheint bei Spielende also nicht, laeuft dieser Test trotzdem erfolgreich!
				// Er sollte aber scheitern. Aber wie sollte dies gepr�ft werden?

			}

		}

	}


	@Nested
	@DisplayName("class KI")
	class TestKI {
		private int endeSpalte;
		private int endeZeile;

		@BeforeEach
		void setUp() throws Exception {
			spielfeld = new Spielfeld();
			spielfeld.initialisiereZellenInArray();
			spielfeld.initialisiereZellenPositionImSpielfeld();
			benutzerschnittstelle = new Benutzerschnittstelle();
			kI = new KuenstlicheIntelligenz();
			endeSpalte = Spielfeld.zellenArray[0].length-1; // merke, array.length Zahl wenn als Referenz verwendet = outofbound!! 
			endeZeile = Spielfeld.zellenArray.length-1;
		}


		@Nested
		class TestBeschrifteNachbarzellen {

			@Nested
			class TestBombenInNachbarschaft {

				@Test
				@DisplayName("Test bombeObenLinks, NOTE: Return is int not String!")
				void testbombeObenLinks() {
					Spielfeld.zellenArray[0][0].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[0][0].bombe);

					kI.bombeObenLinks(spielfeld);
					assertEquals(1, Spielfeld.zellenArray[0][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][0].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][1].bombenInNachbarschaft);
				}


				@Test
				void testbombeObenMitte() {
					Spielfeld.zellenArray[0][1].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[0][1].bombe);

					kI.bombeObenMitte(spielfeld, 1);
					assertEquals(1, Spielfeld.zellenArray[0][0].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[0][2].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][0].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][2].bombenInNachbarschaft);
				}


				@Test
				void testbombeObenRechts() {
					Spielfeld.zellenArray[0][endeSpalte].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[0][endeSpalte].bombe);

					kI.bombeObenRechts(spielfeld);
					assertEquals(1, Spielfeld.zellenArray[0][endeSpalte-1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][endeSpalte].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][endeSpalte-1].bombenInNachbarschaft);
				}


				@Test
				void testbombeUntenLinks() {
					Spielfeld.zellenArray[endeZeile][0].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[endeZeile][0].bombe);

					kI.bombeUntenLinks(spielfeld);
					assertEquals(1, Spielfeld.zellenArray[endeZeile][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile-1][0].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile-1][1].bombenInNachbarschaft);
				}


				@Test
				void testbombeUntenMitte() {
					Spielfeld.zellenArray[endeZeile][2].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[endeZeile][2].bombe);

					kI.bombeUntenMitte(spielfeld, 0, 2);
					assertEquals(1, Spielfeld.zellenArray[endeZeile][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile][3].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile-1][2].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile-1][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile-1][3].bombenInNachbarschaft);
				}


				@Test
				void testbombeUntenRechts() {
					Spielfeld.zellenArray[endeZeile][endeSpalte].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[endeZeile][endeSpalte].bombe);

					kI.bombeUntenRechts(spielfeld);
					assertEquals(1, Spielfeld.zellenArray[endeZeile][endeSpalte-1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile-1][endeSpalte].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile-1][endeSpalte-1].bombenInNachbarschaft);
				}


				@Test
				void testbombeMitteLinks() {
					Spielfeld.zellenArray[2][0].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[2][0].bombe);

					kI.bombeMitteLinks(spielfeld, 2);
					assertEquals(1, Spielfeld.zellenArray[2][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][0].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[3][0].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[3][1].bombenInNachbarschaft);
				}


				@Test
				void testbombeMitteMitte() {
					Spielfeld.zellenArray[2][2].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[2][2].bombe);

					kI.bombeMitteMitte(spielfeld, 2, 2);
					assertEquals(1, Spielfeld.zellenArray[2][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[2][3].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][2].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[3][2].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][3].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[3][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[3][3].bombenInNachbarschaft);
				}


				@Test
				void testbombeMitteRechts() {
					Spielfeld.zellenArray[4][endeSpalte].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[4][endeSpalte].bombe);

					kI.bombeMitteRechts(spielfeld, 4);
					assertEquals(1, Spielfeld.zellenArray[4][endeSpalte-1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[3][endeSpalte].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[5][endeSpalte].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[3][endeSpalte-1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[5][endeSpalte-1].bombenInNachbarschaft);
				}


				@Test
				void testbeschrifteNachbarzellenZuBomben() {
					// XXX muss genau soviele Bomben setzen wie spielfeld.gewueschteBomben sonst kann es zu Fehlern kommen
					Spielfeld.zellenArray[0][0].setzeBombe();
					Spielfeld.zellenArray[5][3].setzeBombe();
					Spielfeld.zellenArray[5][4].setzeBombe();
					Spielfeld.zellenArray[5][5].setzeBombe();
					Spielfeld.zellenArray[5][6].setzeBombe();
					Spielfeld.zellenArray[6][3].setzeBombe();
					Spielfeld.zellenArray[6][4].setzeBombe();
					Spielfeld.zellenArray[6][5].setzeBombe();
					Spielfeld.zellenArray[6][6].setzeBombe();
					Spielfeld.zellenArray[endeZeile][0].setzeBombe();

					assertEquals(spielfeld.gewuenschteBomben, kI.zaehleVerteilteBomben(spielfeld));

					spielfeld.erstelleBombenListe();

					kI.beschrifteNachbarzellenZuBomben(spielfeld);

					assertEquals(1, Spielfeld.zellenArray[0][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[1][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile][1].bombenInNachbarschaft);
					assertEquals(1, Spielfeld.zellenArray[endeZeile-1][0].bombenInNachbarschaft);
				}

			}

			@Nested
			class TestBeschrifteZellenZwischenNullUndBombe {

				@Test
				void testNullMitteLinks() {
					Spielfeld.zellenArray[3][0].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[3][0].bombe);

					kI.bombeMitteLinks(spielfeld, 3);
					Zelle zelle = Spielfeld.zellenArray[1][0];

					kI.NullMitteLinks(zelle);
					assertEquals("1", Spielfeld.zellenArray[2][0].zeichen);
					assertEquals("1", Spielfeld.zellenArray[2][1].zeichen);

					assertNotEquals("1", Spielfeld.zellenArray[3][1].zeichen);
				}

				@Test
				void testNullMitteMitte() {
					Spielfeld.zellenArray[3][0].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[3][0].bombe);

					kI.bombeMitteLinks(spielfeld, 3);
					Zelle zelle = Spielfeld.zellenArray[1][1];

					kI.NullMitteMitte(zelle);
					assertEquals("1", Spielfeld.zellenArray[2][0].zeichen);
					assertEquals("1", Spielfeld.zellenArray[2][1].zeichen);

					assertNotEquals("1", Spielfeld.zellenArray[3][1].zeichen);
					assertNotEquals("1", Spielfeld.zellenArray[2][2].zeichen);
				}

				@Test
				void testNullObenMitte() {
					Spielfeld.zellenArray[0][5].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[0][5].bombe);

					kI.bombeObenMitte(spielfeld, 5);
					Zelle zelle = Spielfeld.zellenArray[0][3];

					kI.NullObenMitte(zelle);
					assertEquals("1", Spielfeld.zellenArray[0][4].zeichen);
					assertEquals("1", Spielfeld.zellenArray[1][4].zeichen);

					assertEquals("0", Spielfeld.zellenArray[0][2].zeichen);
					assertEquals("0", Spielfeld.zellenArray[1][2].zeichen);
					assertEquals("0", Spielfeld.zellenArray[1][3].zeichen);
				}

				@Test
				void testNullObenRechts() {
					Spielfeld.zellenArray[0][5].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[0][5].bombe);

					kI.bombeObenMitte(spielfeld, 5);
					Zelle zelle = Spielfeld.zellenArray[0][7];

					kI.NullObenRechts(zelle);
					assertEquals("1", Spielfeld.zellenArray[0][6].zeichen);
					assertEquals("1", Spielfeld.zellenArray[1][6].zeichen);

					assertEquals("0", Spielfeld.zellenArray[1][7].zeichen);
				}

				@Test
				void testNullMitteRechts() {
					Spielfeld.zellenArray[0][5].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[0][5].bombe);

					kI.bombeObenMitte(spielfeld, 5);
					Zelle zelle = Spielfeld.zellenArray[1][7];

					kI.NullMitteRechts(zelle);
					assertEquals("1", Spielfeld.zellenArray[0][6].zeichen);
					assertEquals("1", Spielfeld.zellenArray[1][6].zeichen);

					assertEquals("0", Spielfeld.zellenArray[0][7].zeichen);
					assertEquals("0", Spielfeld.zellenArray[2][7].zeichen);
					assertEquals("0", Spielfeld.zellenArray[2][6].zeichen);
				}

				@Test
				void testNullUntenRechts() {
					Spielfeld.zellenArray[6][5].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[6][5].bombe);

					kI.bombeMitteMitte(spielfeld, 6, 5);
					Zelle zelle = Spielfeld.zellenArray[7][7];

					kI.NullUntenRechts(zelle);
					assertEquals("1", Spielfeld.zellenArray[6][6].zeichen);
					assertEquals("1", Spielfeld.zellenArray[7][6].zeichen);

					assertEquals("0", Spielfeld.zellenArray[6][7].zeichen);
				}

				@Test
				void testNullUntenMitte() {
					Spielfeld.zellenArray[5][2].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[5][2].bombe);

					kI.bombeMitteMitte(spielfeld, 5, 2);
					Zelle zelle = Spielfeld.zellenArray[7][3];

					kI.NullUntenMitte(zelle);
					assertEquals("1", Spielfeld.zellenArray[6][2].zeichen);
					assertEquals("1", Spielfeld.zellenArray[6][3].zeichen);

					assertEquals("0", Spielfeld.zellenArray[6][4].zeichen);
					assertEquals("0", Spielfeld.zellenArray[7][2].zeichen);
					assertEquals("0", Spielfeld.zellenArray[7][4].zeichen);
				}

				@Test
				void testNullUntenLinks() {
					Spielfeld.zellenArray[5][2].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[5][2].bombe);

					kI.bombeMitteMitte(spielfeld, 5, 2);
					Zelle zelle = Spielfeld.zellenArray[7][0];

					kI.NullUntenLinks(zelle);
					assertEquals("1", Spielfeld.zellenArray[6][1].zeichen);

					assertEquals("0", Spielfeld.zellenArray[6][0].zeichen);
					assertEquals("0", Spielfeld.zellenArray[7][1].zeichen);
				}


				@Test
				void testNullObenLinks() {
					Spielfeld.zellenArray[2][1].setzeBombe();
					assertEquals(true, Spielfeld.zellenArray[2][1].bombe);

					kI.bombeMitteMitte(spielfeld, 2, 1);
					Zelle zelle = Spielfeld.zellenArray[0][0];

					kI.NullObenLinks(zelle);
					assertEquals("1", Spielfeld.zellenArray[1][0].zeichen);
					assertEquals("1", Spielfeld.zellenArray[1][1].zeichen);

					assertEquals("0", Spielfeld.zellenArray[0][1].zeichen);
				}

			}

		}


		@Nested
		class TestPositionImSpielfeld  {

			@Nested
			class TestBestimmePositionImSpielfeld {

				// Tests umbenennen in bestimmePositionImSpielfeld bzw. neuer Test hinzu, alter Test bleibt erhalten!
				@Test
				void testbestimmePositionImSpielfeldOBENLINKS() {
					Zelle zelleOBENLINKS = Spielfeld.zellenArray[0][0];

					kI.bestimmePositionImSpielfeld(zelleOBENLINKS);

					assertEquals(PositionImSpielfeld.OBENLINKS, zelleOBENLINKS.positionImSpielfeld);
				}
				@Test
				void testbestimmePositionImSpielfeldOBEN() {
					Zelle zelleOBEN = Spielfeld.zellenArray[0][3];

					kI.bestimmePositionImSpielfeld(zelleOBEN);

					assertEquals(PositionImSpielfeld.OBEN, zelleOBEN.positionImSpielfeld);
				}
				@Test
				void testbestimmePositionImSpielfeldOBENRECHTS() {
					Zelle zelleOBENRECHTS = Spielfeld.zellenArray[0][endeSpalte];

					kI.bestimmePositionImSpielfeld(zelleOBENRECHTS);

					assertEquals(PositionImSpielfeld.OBENRECHTS, zelleOBENRECHTS.positionImSpielfeld);
				}
				@Test
				void testbestimmePositionImSpielfeldLINKS() {
					Zelle zelleLINKS = Spielfeld.zellenArray[3][0];

					kI.bestimmePositionImSpielfeld(zelleLINKS);

					assertEquals(PositionImSpielfeld.LINKS, zelleLINKS.positionImSpielfeld);
				}
				@Test
				void testbestimmePositionImSpielfeldMITTE() {
					Zelle zelleMITTE = Spielfeld.zellenArray[3][4];

					kI.bestimmePositionImSpielfeld(zelleMITTE);

					assertEquals(PositionImSpielfeld.MITTE, zelleMITTE.positionImSpielfeld);
				}
				@Test
				void testbestimmePositionImSpielfeldRECHTS() {
					Zelle zelleRECHTS = Spielfeld.zellenArray[3][endeSpalte];

					kI.bestimmePositionImSpielfeld(zelleRECHTS);

					assertEquals(PositionImSpielfeld.RECHTS, zelleRECHTS.positionImSpielfeld);
				}
				@Test
				void testbestimmePositionImSpielfeldUNTENLINKS() {
					Zelle zelleUNTENLINKS = Spielfeld.zellenArray[endeZeile][0];

					kI.bestimmePositionImSpielfeld(zelleUNTENLINKS);

					assertEquals(PositionImSpielfeld.UNTENLINKS, zelleUNTENLINKS.positionImSpielfeld);
				}
				@Test
				void testbestimmePositionImSpielfeldUNTEN() {
					Zelle zelleUNTEN = Spielfeld.zellenArray[endeZeile][4];

					kI.bestimmePositionImSpielfeld(zelleUNTEN);

					assertEquals(PositionImSpielfeld.UNTEN, zelleUNTEN.positionImSpielfeld);
				}
				@Test
				void testbestimmePositionImSpielfeldUNTENRECHTS() {
					Zelle zelleUNTENRECHTS = Spielfeld.zellenArray[endeZeile][endeSpalte];

					kI.bestimmePositionImSpielfeld(zelleUNTENRECHTS);

					assertEquals(PositionImSpielfeld.UNTENRECHTS, zelleUNTENRECHTS.positionImSpielfeld);
				}

			}

		}


		@Nested
		//Spielfeld wie GIMP Beispiel, bzw. Bsp. aus den Unterlagen
		class TestNullAufdecken {

			@BeforeEach
			void setUp() throws Exception {

				spielfeld.gewuenschteBomben = 4;

				Spielfeld.zellenArray[3][0].setzeBombe(); // Voraussetzung fuer beschrifteNachbarzellenZuBomben
				Spielfeld.zellenArray[7][1].setzeBombe(); // Voraussetzung fuer beschrifteNachbarzellenZuBomben
				Spielfeld.zellenArray[7][3].setzeBombe(); // Voraussetzung fuer beschrifteNachbarzellenZuBomben
				Spielfeld.zellenArray[0][5].setzeBombe(); // Voraussetzung fuer beschrifteNachbarzellenZuBomben

				spielfeld.erstelleBombenListe();
				kI.beschrifteNachbarzellenZuBomben(spielfeld); // Voraussetzung fuer findeNullen
			}


			@Test
			@DisplayName("testfindeNullenReiheEins, solve5")
			void testfindeNullenReiheEins() {
				kI.findeNullen(3, 4); // 3,4 ist Aufdeckort gemaess Beispiel, siehe GIMP Datei wenn unklar

				//Test0 finde nur die Nullen
				assertEquals("0", Spielfeld.zellenArray[0][0].zeichen);
				assertEquals("0", Spielfeld.zellenArray[1][0].zeichen);
				assertEquals(" ", Spielfeld.zellenArray[3][0].zeichen); // Bombe! Zeichen erwartet?
				assertEquals("0", Spielfeld.zellenArray[5][0].zeichen);
				assertEquals(" ", Spielfeld.zellenArray[7][0].zeichen); // Bombe! Zeichen erwartet?
			}


			@Test
			@DisplayName("testfindeNullenAlleNULLEN, finde alle Nullen auf dem Spielfeld, solve5")
			void testfindeNullenAlleNULLEN() {
				kI.findeNullen(3, 4); // 3,4 ist Aufdeckort gemaess Beispiel, siehe GIMP Datei wenn unklar

				//Test alle Nullen
				// anzahl sichtbare Zellen mit Nullen 33, jeder Block enstpricht einer Spalte.
				assertEquals("0", Spielfeld.zellenArray[0][0].zeichen);
				assertEquals("0", Spielfeld.zellenArray[1][0].zeichen);
				assertEquals("0", Spielfeld.zellenArray[5][0].zeichen);

				assertEquals("0", Spielfeld.zellenArray[0][1].zeichen);
				assertEquals("0", Spielfeld.zellenArray[1][1].zeichen);
				assertEquals("0", Spielfeld.zellenArray[5][1].zeichen);

				assertEquals("0", Spielfeld.zellenArray[0][2].zeichen);
				assertEquals("0", Spielfeld.zellenArray[1][2].zeichen);
				assertEquals("0", Spielfeld.zellenArray[2][2].zeichen);
				assertEquals("0", Spielfeld.zellenArray[3][2].zeichen);
				assertEquals("0", Spielfeld.zellenArray[4][2].zeichen);
				assertEquals("0", Spielfeld.zellenArray[5][2].zeichen);

				assertEquals("0", Spielfeld.zellenArray[0][3].zeichen);
				assertEquals("0", Spielfeld.zellenArray[1][3].zeichen);
				assertEquals("0", Spielfeld.zellenArray[2][3].zeichen);
				assertEquals("0", Spielfeld.zellenArray[3][3].zeichen); 
				assertEquals("0", Spielfeld.zellenArray[4][3].zeichen); 
				assertEquals("0", Spielfeld.zellenArray[5][3].zeichen);

				assertEquals("0", Spielfeld.zellenArray[2][4].zeichen);
				assertEquals("0", Spielfeld.zellenArray[3][4].zeichen); 
				assertEquals("0", Spielfeld.zellenArray[4][4].zeichen); 
				assertEquals("0", Spielfeld.zellenArray[5][4].zeichen);

				assertEquals("0", Spielfeld.zellenArray[2][5].zeichen);
				assertEquals("0", Spielfeld.zellenArray[3][5].zeichen); 
				assertEquals("0", Spielfeld.zellenArray[4][5].zeichen); 

				assertEquals("0", Spielfeld.zellenArray[2][6].zeichen);
				assertEquals("0", Spielfeld.zellenArray[3][6].zeichen); 
				assertEquals("0", Spielfeld.zellenArray[4][6].zeichen); 

				assertEquals("0", Spielfeld.zellenArray[0][7].zeichen);
				assertEquals("0", Spielfeld.zellenArray[1][7].zeichen);
				assertEquals("0", Spielfeld.zellenArray[2][7].zeichen);
				assertEquals("0", Spielfeld.zellenArray[3][7].zeichen); 
				assertEquals("0", Spielfeld.zellenArray[4][7].zeichen);
			}


			@Test
			@DisplayName("testfindeNullenReiheEinsInklNachbarzellen")
			void testfindeNullenReiheEinsInklNachbarzellen() {
				kI.findeNullen(3, 4); // 3,4 ist Aufdeckort gemaess Beispiel, siehe GIMP Datei wenn unklar

				//Test1 finde auch NachbarmitBombe angrenzend an die Nullen
				assertEquals("0", Spielfeld.zellenArray[0][0].zeichen);
				assertEquals("0", Spielfeld.zellenArray[1][0].zeichen);
				assertEquals("1", Spielfeld.zellenArray[2][0].zeichen);
				assertEquals(" ", Spielfeld.zellenArray[3][0].zeichen); // Bombe! Zeichen erwartet?
				assertEquals("1", Spielfeld.zellenArray[4][0].zeichen);
				assertEquals("0", Spielfeld.zellenArray[5][0].zeichen);
				assertEquals("1", Spielfeld.zellenArray[6][0].zeichen);
				assertEquals(" ", Spielfeld.zellenArray[7][0].zeichen);

				assertEquals("1", Spielfeld.zellenArray[2][1].zeichen);
				assertEquals("1", Spielfeld.zellenArray[3][1].zeichen);
				assertEquals("1", Spielfeld.zellenArray[4][1].zeichen);
			}

		}

		@Nested
		class TestKreuzSuche {
			@BeforeEach
			void setUp() throws Exception {
				// Spielfeld mit Bomben so erstellt dass Nullen hinter Bomben versteckt sein muessen
				// die ganze Spalte 4 mit Bomben besetzen, d.h. 0-2 sind drei leere Spalten,
				// sowie die letzte Spalte ist auch leer.

				spielfeld.gewuenschteBomben=8;
				for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
					Spielfeld.zellenArray[i][4].setzeBombe(); 
				}

				spielfeld.erstelleBombenListe();
				kI.beschrifteNachbarzellenZuBomben(spielfeld);
			}

			@Test
			void testSetUp() {
				assertEquals(2, Spielfeld.zellenArray[0][3].bombenInNachbarschaft);
				assertEquals(3, Spielfeld.zellenArray[1][3].bombenInNachbarschaft);
				assertEquals(3, Spielfeld.zellenArray[6][3].bombenInNachbarschaft);
			}

			@Test
			void testKreuzSucheEinfach() {
				//Starte Kreuzsuche wie unten bei Zeile4, Spalte1
				Zelle zelle = Spielfeld.zellenArray[4][1];
				kI.kreuzSuche(zelle);

				assertEquals("0", zelle.zeichen); // zeichen wird bei Methode aufdecken bereits einmal geschreiben
				assertEquals("0", zelle.zelleLinks().zeichen);
				assertEquals("0", zelle.zelleOben().zeichen);
				assertEquals("0", zelle.zelleRechts().zeichen);
				assertEquals("0", zelle.zelleUnten().zeichen);
				assertEquals(true, zelle.nullenBehandeltFlag);
			}

			@Test
			void testKreuzSucheOBENLINKS() {
				//Starte Kreuzsuche wie unten bei Zeile4, Spalte1
				Zelle zelle = Spielfeld.zellenArray[4][1];
				kI.kreuzSuche(zelle);

				assertEquals(0, Spielfeld.zellenArray[3][0].bombenInNachbarschaft);
				assertEquals("0", Spielfeld.zellenArray[3][0].zeichen);
			}

			@Test
			void testKreuzSucheErweitert() {
				//Starte Kreuzsuche wie unten bei Zeile4, Spalte1
				Zelle zelle = Spielfeld.zellenArray[4][1];
				kI.kreuzSuche(zelle);

				assertEquals("2", Spielfeld.zellenArray[0][3].zeichen);
				assertEquals("3", Spielfeld.zellenArray[1][3].zeichen);
				assertEquals("2", Spielfeld.zellenArray[7][3].zeichen);

				//				assertEquals(false, zelle.zelleLinks().nullenBehandeltFlag);
			}

			@Test
			void testFindeNurSichtbareNullen() {
				Zelle zelle = Spielfeld.zellenArray[4][1];
				kI.kreuzSuche(zelle);

				assertEquals("0", Spielfeld.zellenArray[0][0].zeichen); // "sichtbare Null!"
				assertEquals(" ", Spielfeld.zellenArray[0][7].zeichen); // "versteckte Null!"
				assertEquals("3", Spielfeld.zellenArray[4][3].zeichen);
			}
		}


		@Nested
		class TestZellenManipulation {

			@Test
			@DisplayName("Test zaehleZellen")
			void testzaehleZellen() {
				int erwartet = Spielfeld.zeilen*Spielfeld.spalten;

				KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
				int zellen = kI.zaehleZellen(spielfeld);
				assertEquals(erwartet, zellen);
			}


			@Test
			@DisplayName("Test verteileBomben zufaellig verteilen")
			void testverteileBomben() {
				int gewuenschteBomben = spielfeld.gewuenschteBomben;
				KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
				kI.verteileBomben(spielfeld, gewuenschteBomben);
				int verteilteBomben = kI.zaehleVerteilteBomben(spielfeld); 
				assertEquals(gewuenschteBomben, verteilteBomben);
			}


			@Test
			@DisplayName("?? Teste gewuenschte = verteilte Bomben")
			void testverteilteBomben() {
				int gewuenschteBomben = spielfeld.gewuenschteBomben;
				KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
				kI.verteileBomben(spielfeld, gewuenschteBomben);
				spielfeld.erstelleBombenListe();
				assertEquals(gewuenschteBomben, Spielfeld.listeBomben.size());

				int zeileBombenliste = Spielfeld.listeBomben.get(0).yKoordinate;
				int spalteBombenliste = Spielfeld.listeBomben.get(0).xKoordinate;
				spielfeld.aufdecken(zeileBombenliste, spalteBombenliste);
				String zeichenReferenz = Spielfeld.zellenArray[zeileBombenliste][spalteBombenliste].zeichen;
				assertEquals("*", zeichenReferenz);
			}
		}
	}


	@Nested
	@DisplayName("class TestKommando")
	class TestKommando {

		@Test
		@DisplayName("Test markiere Zelle[0][0] via Kommando")
		void testMarkiereZelle00() {
			Kommando kommando = new Kommando("M", 0, 0);
			kommando.ausfuehren(spielfeld);
			assertEquals("!", Spielfeld.zellenArray[0][0].zeichen);
		}


		@Test
		@DisplayName("Test markiere Zelle[2][1] via Kommando")
		void testMarkiereZelle21() {
			Kommando kommando = new Kommando("M", 2, 1);
			kommando.ausfuehren(spielfeld);
			assertEquals("!", Spielfeld.zellenArray[2][1].zeichen);
		}


		@Test
		@DisplayName("Test aufdecken Bombe Zelle[0][0], Spiel endet")
		void testBombeAufdeckenZelle00() {
			Spielfeld.zellenArray[0][0].setzeBombe();
			Kommando kommando = new Kommando("T", 0, 0);
			//DONE switch to spielEnde() implementieren bei aufdecken
			kommando.ausfuehren(spielfeld);
			assertEquals("*", Spielfeld.zellenArray[0][0].zeichen);
		}


		@Test
		@DisplayName("Test aufdecken Bombe Zelle[2][3], Spiel endet")
		void testBombeAufdeckenZelle23() {
			Spielfeld.zellenArray[2][3].setzeBombe();
			Kommando kommando = new Kommando("T", 2, 3);
			kommando.ausfuehren(spielfeld);
			assertEquals("*", Spielfeld.zellenArray[2][3].zeichen);
		}

		@Test
		void testBombeAufdeckenSpielEndetSpielfeldWirdKomplettAngezeigt() {
			Spielfeld.zellenArray[2][3].setzeBombe();
			Kommando kommando = new Kommando("T", 2, 3);
			kommando.ausfuehren(spielfeld);

			// TODO einsetzen eines Test loops f�r alle Spielfelder:
			// pr�fe ob beim aufdecken einer Bombe das Spiel richtig endet!
			// Richtig Enden heisst, aktuelles Spielfeld anzeigen + explodierte Bombe als "*" darstellen!
			assertEquals("*", Spielfeld.zellenArray[2][3].zeichen);

		}


		@Test
		@DisplayName("Test aufdecken Zelle[0][2] welche Nachbar zu Bombe[0][1] ist, Rueckmeldung BombenAnzahl")
		void testNachbarzelleZuBombeAufdecken() {
			Spielfeld.zellenArray[0][1].setzeBombe();
			KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
			spielfeld.erstelleBombenListe();
			kI.beschrifteNachbarzellenZuBomben(spielfeld);
			Kommando kommando = new Kommando("T", 0, 2);

			kommando.ausfuehren(spielfeld);
			assertEquals("1", Spielfeld.zellenArray[0][2].zeichen);
		}


		@Test
		void testAufdeckenLeeresFeld() {
			Spielfeld.zellenArray[0][1].setzeBombe();
			Spielfeld.zellenArray[1][1].setzeBombe();
			KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
			spielfeld.erstelleBombenListe();
			kI.beschrifteNachbarzellenZuBomben(spielfeld);

			Kommando kommando = new Kommando("T", 2, 3);
			kommando.ausfuehren(spielfeld);

			assertEquals("0", Spielfeld.zellenArray[2][3].zeichen);
			assertEquals("2", Spielfeld.zellenArray[1][2].zeichen);
			assertEquals("1", Spielfeld.zellenArray[2][2].zeichen);
			assertEquals(" ", Spielfeld.zellenArray[0][1].zeichen);
		}


		@Test
		void testAufdeckenLeeresFeldPlusNachbarnNull() {
			Kommando kommando = new Kommando("T", 2, 3);
			kommando.ausfuehren(spielfeld);

			assertEquals("0", Spielfeld.zellenArray[2][3].zeichen);
			assertEquals("0", Spielfeld.zellenArray[2][2].zeichen);
			assertEquals("0", Spielfeld.zellenArray[2][4].zeichen);
			assertEquals("0", Spielfeld.zellenArray[1][3].zeichen);
			assertEquals("0", Spielfeld.zellenArray[3][3].zeichen);
			assertEquals("0", Spielfeld.zellenArray[1][2].zeichen);
			assertEquals("0", Spielfeld.zellenArray[1][4].zeichen);
			assertEquals("0", Spielfeld.zellenArray[3][2].zeichen);
			assertEquals("0", Spielfeld.zellenArray[3][4].zeichen);
		}

	}

	@Nested
	class TestValidator {
		// DONE schreibe alle noetigen Test welche der Validator abfangen soll.
		// DONE teste Eingabe T 0 2
		// DONE teste Eingabe M 0 2
		// DONE teste Eingabe 'T 0'
		// DONE teste Eingabe 'M 0  '
		// DONE teste Eingabe T T 2, Resultat in Minesweeper? -> Eingabe Fehler.
		// DONE teste Eingabe t 2 3, Resultat in Minesweeper? -> Eingabe Fehler.
		// DONE teste Eingabe M 2 33, ausserhalb Spielfeld, in Minesweeper = ArrayIndexOutOfBoundsException
		// DONE teste Eingabe M 44 3, ausserhalb Spielfeld, in Minesweeper = ArrayIndexOutOfBoundsException
		// DONE teste Eingabe Q 2 3, Resultat in Minesweeper? -> Eingabe Fehler.
		// TODO teste Eingabe T11

		@Test
		void testEingabeT02() {
			validator = new Validator("T 0 2");
			assertTrue(validator.istGueltig());
		}

		@Test
		void testEingabeM02() {
			validator = new Validator("M 0 2");
			assertTrue(validator.istGueltig());
		}

		@Test
		void testEingabeT0() {
			validator = new Validator("T 0");
			assertFalse(validator.istGueltig());
		}

		@Test
		void testEingabeM0_() {
			validator = new Validator("M 0  ");
			assertFalse(validator.istGueltig());
		}

		@Test
		void testEingabeTT2() {
			validator = new Validator("T T 2");
			assertFalse(validator.istGueltig());
		}

		@Test
		void testEingabet23() {
			validator = new Validator("t 2 3");
			assertFalse(validator.istGueltig());
		}

		@Test
		void testEingabeM233() {
			// DONE in Minesweeper main, Benutzereingabe M 2 33 -> ArrayIndexOutOfBoundsException
			// aber erst wenn auf zellenArray zugegriffen wird.
			// Diese ArrayIndexOutOfBoundsException nicht in der Klasse Validator abfangen?
			// Vor- Nachteile?
			// Vorteile Validator abfangen
			// - Validator Klasse soll ja die Eingabe pr�fen
			// - eine Loesung fuer beide Varianten aufdecken und markieren, d.h.
			// nicht bei jedem zugriff auf zellenArray wird eine Exception geworfen
			// Nachteile
			// - andere falsche Zugriffe auf zellenArray werden nicht behandelt

			// Erster Versuch findet ArrayIndexOutOfBoundsException aus Minesweeper nicht da erst
			// auf zellenArray der ArrayIndexOutOfBoundsException stattfindet.
			//			ArrayIndexOutOfBoundsException exception = assertThrows(
			//					ArrayIndexOutOfBoundsException.class, () -> validator = new Validator("M 2 33"));
			validator = new Validator("M 2 33");
			assertFalse(validator.istGueltig());
		}

		@Test
		void testEingabeM443() {
			validator = new Validator("M 44 3");
			assertFalse(validator.istGueltig());
		}


		@Test
		void testEingabeQ23() {
			validator = new Validator("Q 2 3");
			assertFalse(validator.istGueltig());
		}

		@Test
		void testNumberFormatException() {
			// eingabe = T T 2
			//			NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {validator = new Validator("T T 2");
			//			});

			// Vermutung, dieser Test lauft nur nicht weil dies bereits abgefangen wird mit den if-
			// Pruefungen in der Validator Klasse -> Test dies, ausklammern bringt keinen erfolgreichen Test!
			// Vermutung nicht bestaetigt.

			validator = new Validator("T T 2");
			assertFalse(validator.istGueltig());
		}

		@Test
		// Dieser Test laeuft, wenn Validator noch ohne catch ArrayIndexOutOfBoundsException
		// ausgestatted ist. Merke Validator ArrayIndexOutOfBoundsException bezieht sich nicht
		// auf das zellenArray nur auf Integer.valueOf(eingabeTeile[1]); und
		// Integer.valueOf(eingabeTeile[2]);
		void testArrayIndexOutOfBoundsException() {
			validator = new Validator("T 2");
			assertFalse(validator.istGueltig());

			validator = new Validator("M 0  ");
			assertFalse(validator.istGueltig());			
			// alter Test ohne catch ArrayIndexOutOfBoundsException in Validator 
			//			ArrayIndexOutOfBoundsException exception = assertThrows(
			//					ArrayIndexOutOfBoundsException.class, () -> {validator = new Validator("T 2");
			//					});
		}

		@Test
		void testEingabeT11() {
			validator = new Validator("T11");
			assertFalse(validator.istGueltig());
		}

	}

	@Nested
	@DisplayName("class TestZelle")
	class TestZelle {

		@Test
		@DisplayName("Test Standard Zellenrepraesentation auf dem Spielfeld")
		void testzeigeZelle() {
			Zelle zelle = new Zelle(0, 1);
			assertEquals(" ", zelle.zeichen);
			assertEquals(0, zelle.yKoordinate);
			assertEquals(1, zelle.xKoordinate);
		}


		@Nested
		class TestZelleNurNachbarzellenAlsRueckgabe {

			@Test
			@DisplayName("Test zelleRechts")
			void testzelleRechts() {
				assertNotNull(Spielfeld.zellenArray[0][0]);

				assertEquals(Spielfeld.zellenArray[0][1], Spielfeld.zellenArray[0][0].zelleRechts());

				Zelle ursprung = Spielfeld.zellenArray[0][0];
				ursprung.zeichen = "%";
				Spielfeld.zellenArray[0][0].zelleRechts().zeichen = ursprung.zeichen;
				assertEquals("%", Spielfeld.zellenArray[0][1].zeichen);
			}


			@Test
			@DisplayName("Test zelleLinks")
			void testzelleLinks() {
				assertNotNull(Spielfeld.zellenArray[0][7]);
				assertEquals(Spielfeld.zellenArray[0][6], Spielfeld.zellenArray[0][7].zelleLinks());
			}


			@Test
			@DisplayName("Test zelleObenLinks")
			void testzelleObenLinks() {
				assertNotNull(Spielfeld.zellenArray[4][4]);
				assertEquals(Spielfeld.zellenArray[3][3], Spielfeld.zellenArray[4][4].zelleObenLinks());
			}


			@Test
			@DisplayName("Test zelleUntenLinks")
			void testzelleUntenLinks() {
				assertNotNull(Spielfeld.zellenArray[4][4]);
				assertEquals(Spielfeld.zellenArray[5][3], Spielfeld.zellenArray[4][4].zelleUntenLinks());
			}


			@Test
			@DisplayName("Test zelleObenRechts")
			void testzelleObenRechts() {
				assertNotNull(Spielfeld.zellenArray[4][4]);
				assertEquals(Spielfeld.zellenArray[3][5], Spielfeld.zellenArray[4][4].zelleObenRechts());
			}


			@Test
			@DisplayName("Test zelleUntenRechts")
			void testzelleUntenRechts() {
				assertNotNull(Spielfeld.zellenArray[4][4]);
				assertEquals(Spielfeld.zellenArray[5][5], Spielfeld.zellenArray[4][4].zelleUntenRechts());
			}


			@Test
			@DisplayName("Test Oben")
			void testOben() {
				assertNotNull(Spielfeld.zellenArray[4][4]);
				assertEquals(Spielfeld.zellenArray[3][4], Spielfeld.zellenArray[4][4].zelleOben());
			}


			@Test
			@DisplayName("Test Unten")
			void testUnten() {
				assertNotNull(Spielfeld.zellenArray[4][4]);
				assertEquals(Spielfeld.zellenArray[5][4], Spielfeld.zellenArray[4][4].zelleUnten());
			}

		}

	}

	@AfterEach
	void tearDown() {
		spielfeld = null;
		Spielfeld.listeAllerZellen.clear();
		benutzerschnittstelle = null;
	}

}
