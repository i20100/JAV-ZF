package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JUnit5TestCase {

	@Test
	@DisplayName (value = "JUnit5TestCase Method 1")
	void test() {
		assertTrue(2 == 1+1);
	}
	
}
