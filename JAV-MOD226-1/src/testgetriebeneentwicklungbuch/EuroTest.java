package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import mod226_08.Euro;

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
	@DisplayName("test adding new plus")
	void testsAdding() {
		Euro sum = two.plus(two);
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
	@DisplayName("testGetAmount")
	void testGetAmount() {
		assertEquals(2.00, two.getAmount(), 0.001);
	}

	@Test
	@DisplayName("testRoundingUP")
	public void testRoundingUP() {
		Euro rounded = new Euro(1.995);
		assertEquals(2.00, rounded.getAmount(), 0.001);
	}

	@Test
	@DisplayName("testRoundingDOWN")
	public void testRoundingDOWN() {
		Euro rounded = new Euro(1.994);
		assertEquals(1.99, rounded.getAmount(), 0.001);
	}
	
	@Test
	@DisplayName("testFormatting")
	public void testFormatting() {
		assertEquals("2.00", two.format());
	}


}
