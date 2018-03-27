package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class MovieTest {

	@Test
	@DisplayName("testUsingNewReleasePrice extracted Class aka old test")
	void testUsingNewReleasePrice() {
		assertEquals(new Euro(3.75).getAmount(), Movie.getCharge(3).getAmount(), 0.001);
	}
}
