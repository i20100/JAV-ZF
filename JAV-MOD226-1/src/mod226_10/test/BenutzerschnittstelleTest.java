package mod226_10.test;

import mod226_10.mineswepfinal.Benutzerschnittstelle;
import mod226_10.mineswepfinal.Kommando;
import mod226_10.mineswepfinal.KuenstlicheIntelligenz;
import mod226_10.mineswepfinal.Spielfeld;
import mod226_10.mineswepfinal.Zelle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("class BenutzerschnittstelleTest")
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


	@Test
	@DisplayName("Test zaehleZellen")
	void testzaehleZellen() {
		int erwartet = Spielfeld.zeilen*Spielfeld.spalten;

		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		int zellen = kI.zaehleZellen(spielfeld);
		assertEquals(erwartet, zellen);
	}


	@Test
	@DisplayName("Test verteileBomben zuf�llig verteilen")
	void testverteileBomben() {
		int gewuenschteBomben = spielfeld.gewuenschteBomben;
		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		kI.verteileBomben(spielfeld, gewuenschteBomben);
		int verteilteBomben = kI.zaehleVerteilteBomben(spielfeld); 
		assertEquals(gewuenschteBomben, verteilteBomben);
	}


	@Test
	@DisplayName("?? Teste gew�nschte = verteilte Bomben")
	void testverteilteBomben() {
		int gewuenschteBomben = spielfeld.gewuenschteBomben;
		KuenstlicheIntelligenz kI = new KuenstlicheIntelligenz();
		kI.verteileBomben(spielfeld, gewuenschteBomben);
		spielfeld.erstelleBombenListe();
		assertEquals(gewuenschteBomben, spielfeld.listeBombenOrte.size());

		int zeileBombenliste = spielfeld.listeBombenOrte.get(0).yKoordinate;
		int spalteBombenliste = spielfeld.listeBombenOrte.get(0).xKoordinate;
		spielfeld.aufdecken(zeileBombenliste, spalteBombenliste);
		String zeichenReferenz = Spielfeld.zellenArray[zeileBombenliste][spalteBombenliste].zeichen;
		assertEquals("*", zeichenReferenz);
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


	@Nested
	@DisplayName("class TestSpielfeld")
	class TestSpielfeld {

		@Test
		@DisplayName("Test zellenArray enth�lt Zellen Objekte, d.h. Befehl erstelleSpielfeld() erstellt Array mit Objekten, nicht 'leeres' Array")
		void testzeigeZellenArray() {
			assertNotNull(Spielfeld.zellenArray[0]);
		}


		@Test
		@DisplayName("Test initialisiereZellenInArray")
		void testinitialisiereZellenInArray() {
			assertNotNull(Spielfeld.zellenArray[0][0]);
			assertEquals(Spielfeld.zeilen, Spielfeld.zellenArray.length);
			assertEquals(Spielfeld.spalten, Spielfeld.zellenArray[0].length);
		}


		@Test
		@DisplayName("Test erstelleBombenListe")
		void testerstelleBombenListe() {
			Spielfeld.zellenArray[0][3].setzeBombe();
			spielfeld.erstelleBombenListe();
			assertEquals(0, spielfeld.listeBombenOrte.get(0).yKoordinate);
			assertEquals(3, spielfeld.listeBombenOrte.get(0).xKoordinate);
		}


		@Test
		@DisplayName("Test erstelleBombenListe mehrere Eintr�ge")
		void testerstelleBombenListeMulti() {
			Spielfeld.zellenArray[0][3].setzeBombe();
			Spielfeld.zellenArray[1][3].setzeBombe();
			spielfeld.erstelleBombenListe();
			assertEquals(0, spielfeld.listeBombenOrte.get(0).yKoordinate);
			assertEquals(3, spielfeld.listeBombenOrte.get(0).xKoordinate);
			assertEquals(1, spielfeld.listeBombenOrte.get(1).yKoordinate);
			assertEquals(3, spielfeld.listeBombenOrte.get(1).xKoordinate);
		}


		@Test
		@Disabled
		@DisplayName("Test ErstelleSpielfeld?")
		void testErstelleSpielfeld() {
		}

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
							"T x y (z.B. T 2 3 testet Feld Zeile 2, Spalte 3 auf Mine)\n" +
							"M x y (z.B. M 6 1 kehrt Markierung Feld Zeile 6, Spalte 1)\n";
			assertEquals(erwartet, benutzerschnittstelle.zeigeEingabeaufforderung());
		}


		@Test
		@Disabled
		@DisplayName("Test liesEingabe() bis Umwandlung in Kommando bei g�ltiger Eingabe")
		void testLiesEingabe() {
			//XXX Fake methode liesEingabe(String testString) erstellt. Dies verstoesst gegen keine Codeteile 2x vorhanden!!
			//FIXME Fake methode und dieser Test nicht zum laufen gebracht, ein Problem ist dieser Test deck bereits zuviele vorg�nge ab und scheint eher ein 
			//Integrationstest zu sein. konsequenz Fake methode erst mal wieder gel�scht!

			/*String testString = "M 0 0";
                    Kommando testKommando = benutzerschnittstelle.liesEingabe(testString);
                    Kommando testObj = new Kommando("M",0,0);
                    assertEquals(testObj., testKommando);
			 */
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
			//TODO switch to spielEnde() implementieren bei aufdecken
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
		@DisplayName("Test aufdecken Zelle[0][2] welche Nachbar zu Bombe[0][1] ist, R�ckmeldung BombenAnzahl")
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
			//TODO bevor hier weitergemacht wird, test erstellen alle NachbarNullZellen in Listen speichern! Siehe KI.
			Kommando kommando = new Kommando("T", 2, 3);
			kommando.ausfuehren(spielfeld);

			assertEquals("0", Spielfeld.zellenArray[2][3].zeichen);
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
	@DisplayName("class KI")
	class KI {

		private int endeSpalte;


		private int endeZeile;


		@BeforeEach
		void setUp() throws Exception {
			spielfeld = new Spielfeld();
			spielfeld.initialisiereZellenInArray();
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

		// TODO Tests in eigene Klasse verpacken

		@Nested
		@DisplayName("TestWaehleVariante, testet die kI.waehleVariante()")
		class TestWaehleVariante {

			@Test
			@DisplayName("Test waehleVariante Bombe oben links")
			void testwaehleVarianteBOL() {
				Spielfeld.zellenArray[0][0].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[0][0].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(1, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante Bombe oben rechts")
			void testwaehleVarianteBOR() {
				Spielfeld.zellenArray[0][endeSpalte].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[0][endeSpalte].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(3, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante Bombe oben mitte")
			void testwaehleVarianteBOM() {
				Spielfeld.zellenArray[0][5].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[0][5].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(2, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante Bombe unten links")
			void testwaehleVarianteBUL() {
				Spielfeld.zellenArray[endeZeile][0].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[endeZeile][0].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(7, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante Bombe unten rechts")
			void testwaehleVarianteBUR() {
				Spielfeld.zellenArray[endeZeile][endeSpalte].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[endeZeile][endeSpalte].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(9, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante Bombe unten mitte")
			void testwaehleVarianteBUM() {
				Spielfeld.zellenArray[endeZeile][6].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[endeZeile][6].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(8, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante Bombe mitte links")
			void testwaehleVarianteBML() {
				Spielfeld.zellenArray[3][0].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[3][0].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(4, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante Bombe mitte rechts")
			void testwaehleVarianteBMR() {
				Spielfeld.zellenArray[4][endeSpalte].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[4][endeSpalte].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(6, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante Bombe mitte mitte")
			void testwaehleVarianteBMM() {
				Spielfeld.zellenArray[5][6].setzeBombe();
				assertEquals(true, Spielfeld.zellenArray[5][6].bombe);

				spielfeld.erstelleBombenListe();

				Zelle ersteBombe = spielfeld.listeBombenOrte.get(0);

				assertEquals(5, kI.waehleVariante(ersteBombe));
			}


			@Test
			@DisplayName("Test waehleVariante mehrere Bomben aka beschrifteNachbarzellenZuBomben")
			void testbeschrifteNachbarzellenZuBomben() {
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

				// TODO muss genau soviele Bomben setzen wie spielfeld.gewueschteBomben sonst kann es zu Fehlern kommen
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
		class TestNullAufdecken {

			@BeforeEach
			void setUp() throws Exception {
				//Spielfeld wie GIMP Beispiel erstellen, bzw. Bsp. aus den Unterlagen

				spielfeld.gewuenschteBomben = 4;

				Spielfeld.zellenArray[3][0].setzeBombe(); // Voraussetzung f�r beschrifteNachbarzellenZuBomben
				Spielfeld.zellenArray[7][1].setzeBombe(); // Voraussetzung f�r beschrifteNachbarzellenZuBomben
				Spielfeld.zellenArray[7][3].setzeBombe(); // Voraussetzung f�r beschrifteNachbarzellenZuBomben
				Spielfeld.zellenArray[0][5].setzeBombe(); // Voraussetzung f�r beschrifteNachbarzellenZuBomben

				spielfeld.erstelleBombenListe();
				kI.beschrifteNachbarzellenZuBomben(spielfeld); // Voraussetzung f�r findeNullen
			}


			@Test
			@DisplayName("testfindeNullenReiheEins, solve5")
			void testfindeNullenReiheEins() {
				kI.findeNullen(3, 4); // 3,4 ist Aufdeckort gem�ss Beispiel, siehe GIMP Datei wenn unklar

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
				kI.findeNullen(3, 4); // 3,4 ist Aufdeckort gem�ss Beispiel, siehe GIMP Datei wenn unklar

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
				kI.findeNullen(3, 4); // 3,4 ist Aufdeckort gem�ss Beispiel, siehe GIMP Datei wenn unklar

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

	}

}
