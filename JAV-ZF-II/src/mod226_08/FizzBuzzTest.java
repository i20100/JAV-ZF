package mod226_08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** FizzBuzz Problem
 * @author Vincent
 *
 * FizzBuzz Spiel als kleine Programmieruebung
 * Erstelle ein Programm welches eine Zahlenreihenfolge von 1 bis Endzahl ausgibt.
 * Erhöhe die Zahl jeweils um 1.
 * Ist die Zahl durch drei teilbar, schreibe anstatt die Zahl, Fizz.
 * Ist die Zahl durch fuenf teilbar, schreibe anstatt die Zahl, Buzz.
 * Ist die Zahl durch beide teilbar, schreibe Fizz Buzz.
 * 
 * Bsp. (1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,...)
 *
 */
class FizzBuzzTest {

	@Test
	void testZahlenreihe() {
		Zahlenreihe init = new Zahlenreihe();
		assertTrue(1 == init.getZahl());
		assertTrue(2 == init.getZahl());
	}


	class PrueferTest {
	}

	@Test
	void testTeilbarDrei() {
		Pruefer eins = new Pruefer(1);
		assertTrue(false == eins.teilbarDrei());

		Pruefer zwei = new Pruefer(2);
		assertTrue(false == zwei.teilbarDrei());

		Pruefer drei = new Pruefer(3);
		assertTrue(true == drei.teilbarDrei());
	}
	
	@Test
	void testTeilbarFuenf() {
		Pruefer eins = new Pruefer(1);
		assertTrue(false == eins.teilbarFuenf());

		Pruefer drei = new Pruefer(3);
		assertTrue(false == drei.teilbarFuenf());

		Pruefer fuenf = new Pruefer(5);
		assertTrue(true == fuenf.teilbarFuenf());
	}
	
	@Test
	void testAntwort() {
		Pruefer eins = new Pruefer(1);
		assertEquals("1", eins.Antwort());
			

		Pruefer drei = new Pruefer(3);
		assertEquals("Fizz", drei.Antwort());

		Pruefer fuenf = new Pruefer(5);
		assertEquals("Buzz", fuenf.Antwort());
		
		Pruefer fuenfzehn = new Pruefer(15);
		assertEquals("Fizz Buzz", fuenfzehn.Antwort());
	}
	

}
