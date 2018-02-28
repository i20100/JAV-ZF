package testgetriebeneentwicklungbuch.kap2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	private Customer customer;
	
	@BeforeEach
	public void setUp() {
	customer = new Customer();  //Instanz mit Customerkonstruktor erstellen
	}
	
	@Test
	void testRentingNoMovie() {
		assertEquals(0, customer.getTotalCharge(), 0.001);
		// 0.001 ist die Toleranz bei Fliesskommazahlen
	}

	@Test
	void testRentingOneMovie() {
		customer.rentMovie(1); // Ausleihe ein Tag
		assertEquals(2, customer.getTotalCharge(), 0.001);
	}


	@Test
	void testRentingThreeMovies()  {
		customer.rentMovie(2); // Ausleihe zwei Tage
		customer.rentMovie(3); // Asuleihe drei Tage
		customer.rentMovie(4); // Ausleihe vier Tage
		assertEquals(11.25, customer.getTotalCharge(), 0.001);
	}

}
