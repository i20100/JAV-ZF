package mod226_08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EuroTest {

	@Test
	public void testAmount() {
		Euro two = new Euro(2.00);
		assertTrue(2.00 == two.getAmount());
	}

}
