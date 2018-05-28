package testgetriebeneentwicklungbuch;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AssertKommentarTest {

	@Test
	void testRichtig() {
		assertEquals("amount not same", 2.00, 1.99, 0.1);
	}

	@Test
	@Disabled
	void testFalsch() {
		assertEquals("amount not same", 2.00, 1.99, 0.001);
	}

}
