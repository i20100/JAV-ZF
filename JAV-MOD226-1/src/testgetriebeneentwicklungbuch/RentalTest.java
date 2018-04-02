package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sun.org.glassfish.gmbal.Description;

import mod226_08.Euro;

class RentalTest {

	@Test
	@Description("testUsingMovie")
	void testUsingMovie() {
		Movie movie = new Movie("Blow-UP", Price.NEWRELEASE);
		Rental rental = new Rental(movie, 2);
		assertEquals(new Euro(2.00).getAmount(), rental.getCharge().getAmount());
	}

}
