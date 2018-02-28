package testgetriebeneentwicklungbuch.kap2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void testRentingOneMovie() {
		Customer customer = new Customer(); //Instanz mit Customerkonstruktor erstellen
		customer.rentMovie(1); // Ausleihe ein Tag
		assertTrue(customer.getTotalCharge() == 2.00);
	}

	@Test
	void testRentingTwoMovies() {
		Customer customer = new Customer(); //Instanz mit Customerkonstruktor erstellen
		customer.rentMovie(1); // Ausleihe ein Tag
		customer.rentMovie(2); // Ausleihe zwei Tage
		assertEquals(4.00, customer.getTotalCharge(), 0.001);
	}

	@Test
	void testRentingThreeMoviesMoreThanTwoDays() {
		Customer customer = new Customer(); //Instanz mit Customerkonstruktor erstellen
		customer.rentMovie(1); // Ausleihe ein Tag
		customer.rentMovie(2); // Ausleihe zwei Tage
		customer.rentMovie(3); // Ausleihe drei Tage (2+1.75=3.75)
		assertEquals(7.75, customer.getTotalCharge(), 0.001);
		// 0.001 ist die Toleranz bei Fliesskommazahlen
	}

	@Test
	void testRentingFourMovies()  {
		Customer customer = new Customer();
		customer.rentMovie(1); // Ausleihe ein Tag
		customer.rentMovie(2); // Ausleihe zwei Tage
		customer.rentMovie(3);
		customer.rentMovie(4); // Ausleihe vier Tage
		assertEquals(13.25, customer.getTotalCharge(), 0.001);
	}


}
