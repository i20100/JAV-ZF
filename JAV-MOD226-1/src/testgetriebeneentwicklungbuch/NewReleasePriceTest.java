package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class NewReleasePriceTest {

	@Test
	@DisplayName("testBasePrice")
	void testBasePrice() {
		assertEquals(new Euro(2.00).getAmount(), NewReleasePrice.getCharge(1).getAmount());
		assertEquals(new Euro(2.00).getAmount(), NewReleasePrice.getCharge(2).getAmount());
	}

	@Test
	@DisplayName("testPricePerDay")
	void testPricePerDay() {
		assertEquals(new Euro(3.75).getAmount(), NewReleasePrice.getCharge(3).getAmount(), 0.001);
		assertEquals(new Euro(5.50).getAmount(), NewReleasePrice.getCharge(4).getAmount(), 0.001);
	}
}
