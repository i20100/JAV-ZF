package mod226_07_aufg1_code_to_uml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KontoTest {
	/* Erstellen Sie mit Hilfe von eclipse in Ihrem Projekt Bank
	 *  aus Lektion 6 und 7 ein Testklasse und testen Sie in dieser 
	 *  die Methoden einzahlen und verzinsen der Klasse Konto .
	 */

	private Kunde inhaber = new Kunde ("Hugo Hungerbühler", new Adresse("Bahnhofplatz 4", "3000 Bern"));
	private Konto konto;
	
	@BeforeEach
	public void setUp() {
		konto = new Konto(inhaber, 0.02);
	}
		
	@Test
	void testSaldo()  {
		assertEquals(0.0, konto.saldo());
	}

	@Test
	void testEinzahlen() {
		konto.einzahlen(100.00);
		assertEquals(100.00, konto.saldo());
		konto.einzahlen(100.00);
		assertEquals(200.00, konto.saldo());
	}


	@Test
	void testVerzinsen() {
		konto.einzahlen(100.00);
		konto.verzinsen(360);
		assertEquals(102.00, konto.saldo());
	}

}
