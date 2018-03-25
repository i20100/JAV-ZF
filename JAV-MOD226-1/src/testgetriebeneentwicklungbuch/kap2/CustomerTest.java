package testgetriebeneentwicklungbuch.kap2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class CustomerTest {
	private Customer customer;
	
	@BeforeEach
	public void setUp() {
	customer = new Customer();  //Instanz mit Customerkonstruktor erstellen
	}
	
	@Test
	void testRentingNoMovie() {
		assertEquals(new Euro(0).getAmount(), customer.getTotalCharge().getAmount());
		// 0.001 ist die Toleranz bei Fliesskommazahlen
	}

	@Test
	void testRentingOneMovie() {
		customer.rentMovie(1); // Ausleihe ein Tag
		assertEquals(new Euro(2).getAmount(), customer.getTotalCharge().getAmount(), 0.001);
	}


	@Test
	void testRentingThreeMovies()  {
		customer.rentMovie(2); // Ausleihe zwei Tage
		customer.rentMovie(3); // Asuleihe drei Tage
		customer.rentMovie(4); // Ausleihe vier Tage
		assertEquals(new Euro(11.25).getAmount(), customer.getTotalCharge().getAmount());
	}

}
