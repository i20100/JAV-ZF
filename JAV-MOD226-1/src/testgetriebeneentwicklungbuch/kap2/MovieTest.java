package testgetriebeneentwicklungbuch.kap2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovieTest {

	@Test
	@DisplayName("testBasePrice")
	void testBasePrice() {
		assertEquals(2.00, Movie.getCharge(1).getAmount(), 0.001);
		assertEquals(2.00, Movie.getCharge(2).getAmount(), 0.001);
	}

	@Test
	@DisplayName("testPricePerDay")
	void testPricePerDay() {
		assertEquals(3.75, Movie.getCharge(3).getAmount(), 0.001);
		assertEquals(5.50, Movie.getCharge(4).getAmount(), 0.001);
	}
}
