package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class MovieTest {

	@Test
	@DisplayName("testUsingNewReleasePrice")
	void testPricePerDay() {
		Movie movie = new Movie("Fight Club", Price.NEWRELEASE);
		assertEquals(new Euro(3.75).getAmount(), movie.getCharge(3).getAmount(), 0.001);
	}

	@Test
	@DisplayName("testUsingRegularPrice")
	void testFalseIfNotRightPrice() {
		Movie movie = new Movie("Brazil", Price.REGULAR);
		assertEquals(new Euro(1.50).getAmount(), movie.getCharge(3).getAmount(), 0.001);
	}
	
	@Test
	@DisplayName("testSettingNewPrice")
	void testSettingNewPrice() {
		Movie movie = new Movie("Brazil", Price.NEWRELEASE);
		movie.setPrice(Price.REGULAR);
		assertEquals(new Euro(1.50).getAmount(), movie.getCharge(3).getAmount(), 0.001);
	}
	
}
