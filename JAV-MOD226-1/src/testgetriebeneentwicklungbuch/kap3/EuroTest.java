package testgetriebeneentwicklungbuch.kap3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import mod226_08.Euro;

//import static org.junit.Assert.assertEquals; // This is from an older JUnit
//import static org.junit.jupiter.api.Assertions.assertEquals; // This is JUnit5
// JUnit 5 hat versteht den Kommentar bei den assert Methoden nicht!! Siehe Bsp. unten

@DisplayName("EuroTest class")
class EuroTest {
	// TODO prüfe add() mit Minusbeträgen, => Name .add unzutreffend?
	// TODO testRounding...() refaktorisieren, da keine Verwendung von 'Euro two = new Euro(2.00);'
	private Euro two;
	
	@BeforeEach
	protected void setUp() {
		two = new Euro(2.00);
	}
	
	@Test
	@DisplayName("testAdding, test the add Method")
	void testsAdding() {
		Euro sum = two.add(two);
		assertEquals(4.00, sum.getAmount(), 0.001);
		assertEquals(2.00, two.getAmount(), 0.001);
	}
	
	@Test
	@DisplayName("test multiply")
	void testMultiplying() {
		Euro result = two.times(7);
		assertEquals(14, result.getAmount());
		assertEquals(2, two.getAmount());
	}

	@Test
	void testGetAmount() {
		//		assertEquals("getAmount wrong", 2.00, twoEuro.getAmount(), 0.001); // Bsp. geht nicht mit JUnit5 import!
		//		assertEquals(2.00, twoEuro.getAmount(), 0.001); //Dieses Bsp. geht mit JUnit5 import!
		assertEquals(2.00, two.getAmount(), 0.001);
	}

	@Test
	public void testRoundingUP() {
		Euro rounded = new Euro(1.995);
		assertEquals(2.00, rounded.getAmount(), 0.001);
	}

	@Test
	public void testRoundingDOWN() {
		Euro rounded = new Euro(1.994);
		assertEquals(1.99, rounded.getAmount(), 0.001);
	}


}
