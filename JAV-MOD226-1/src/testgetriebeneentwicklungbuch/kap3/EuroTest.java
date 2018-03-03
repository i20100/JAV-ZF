package testgetriebeneentwicklungbuch.kap3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import static org.junit.Assert.assertEquals; // This is from an older JUnit
//import static org.junit.jupiter.api.Assertions.assertEquals; // This is JUnit5
// JUnit 5 hat versteht den Kommentar bei den assert Methoden nicht!! Siehe Bsp. unten


import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class EuroTest {

	@Test
	void testGetAmount() {
		Euro twoEuro = new Euro(2);
//		assertEquals("getAmount wrong", 2.00, twoEuro.getAmount(), 0.001); // Bsp. geht nicht mit JUnit5 import!
//		assertEquals(2.00, twoEuro.getAmount(), 0.001); //Dieses Bsp. geht mit JUnit5 import!
		assertEquals("getAmount wrong", 2.00, twoEuro.getAmount(), 0.001);
	}

	@Test
	public void testRounding() {
		Euro rounded = new Euro(1.995);
		assertTrue("Rounding getAmount wrong", 2.00 == rounded.getAmount());
	}


}
