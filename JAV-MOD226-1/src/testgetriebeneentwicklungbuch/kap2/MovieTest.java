package testgetriebeneentwicklungbuch.kap2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class MovieTest {

	@Test
	@DisplayName("testBasePrice")
	void testBasePrice() {
		assertEquals(new Euro(2.00).getAmount(), Movie.getCharge(1).getAmount());
		assertEquals(new Euro(2.00).getAmount(), Movie.getCharge(2).getAmount());
	}

	@Test
	@DisplayName("testPricePerDay")
	void testPricePerDay() {
		assertEquals(new Euro(3.75).getAmount(), Movie.getCharge(3).getAmount(), 0.001);
		assertEquals(new Euro(5.50).getAmount(), Movie.getCharge(4).getAmount(), 0.001);
	}
}
