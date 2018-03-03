package testgetriebeneentwicklungbuch.kap3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

//import static org.junit.Assert.assertEquals; // This is from an older JUnit
//import static org.junit.jupiter.api.Assertions.assertEquals; // This is JUnit5
// JUnit 5 hat versteht den Kommentar bei den assert Methoden nicht!! Siehe Bsp. unten


import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class EuroTest {
	// TODO prüfe add() mit Minusbeträgen, => Name .add unzutreffend?
	// TODO testRounding...() refaktorisieren, da keine Verwendung von 'Euro two = new Euro(2.00);'
	private Euro two;
	
	@BeforeEach
	protected void setUp() {
		two = new Euro(2.00);
	}
	
	
	@Test
	public void testAdding() {
		Euro sum = two.add(two);
		assertEquals("sum", 4.00, sum.getAmount(), 0.001);
		assertEquals("two", 2.00, two.getAmount(), 0.001);
	}

	@Test
	void testGetAmount() {
		//		assertEquals("getAmount wrong", 2.00, twoEuro.getAmount(), 0.001); // Bsp. geht nicht mit JUnit5 import!
		//		assertEquals(2.00, twoEuro.getAmount(), 0.001); //Dieses Bsp. geht mit JUnit5 import!
		assertEquals("getAmount wrong", 2.00, two.getAmount(), 0.001);
	}

	@Test
	public void testRoundingUP() {
		Euro rounded = new Euro(1.995);
		assertEquals("RoundingUP getAmount wrong", 2.00, rounded.getAmount(), 0.001);
	}

	@Test
	public void testRoundingDOWN() {
		Euro rounded = new Euro(1.994);
		assertEquals("RoundingDOWN getAmount wrong", 1.99, rounded.getAmount(), 0.001);
	}


}
