package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.org.glassfish.gmbal.Description;

import mod226_08.Euro;

class CustomerTest {
	private Customer customer;
	private Movie buffalo66, jungleBook, pulpFiction;
	
	@BeforeEach
	public void setUp() {
	customer = new Customer();  //Instanz mit Customerkonstruktor erstellen
	buffalo66 = new Movie("Buffalo 66", Price.NEWRELEASE);
	jungleBook = new Movie("Jungle Book", Price.REGULAR);
	pulpFiction = new Movie("Pulp Fiction", Price.NEWRELEASE);
	}
	
	@Test
	@Description("testPrintingStatement")
	public void testPrintingStatement() {
		customer.rentMovie(buffalo66, 4);
		customer.rentMovie(jungleBook, 1);
		customer.rentMovie(pulpFiction, 4);
		
		buffalo66.setPrice(Price.REGULAR);
		
		String actual = customer.printStatement();
		String expected = "\tBuffalo 66\t3.00\n"
				+ "\tJungle Book\t1.50\n"
				+ "\tPulp Fiction\t5.50\n"
				+ "Gesamt: 10.00\n";
		assertEquals(expected, actual);
	}
	
	@Test
	@Description("testRentingNoMovie")
	void testRentingNoMovie() {
		assertEquals(new Euro(0).getAmount(), customer.getTotalCharge().getAmount());
		// 0.001 ist die Toleranz bei Fliesskommazahlen
	}

	@Test
	@Description("testRentingOneMovie")
	void testRentingOneMovie() {
		customer.rentMovie(pulpFiction, 1); // Ausleihe ein Tag
		assertEquals(new Euro(2).getAmount(), customer.getTotalCharge().getAmount(), 0.001);
	}


	@Test
	@Description("testRentingThreeMovies")
	void testRentingThreeMovies()  {
		customer.rentMovie(pulpFiction, 2); // Ausleihe zwei Tage
		customer.rentMovie(pulpFiction, 3); // Asuleihe drei Tage
		customer.rentMovie(pulpFiction, 4); // Ausleihe vier Tage
		assertEquals(new Euro(11.25).getAmount(), customer.getTotalCharge().getAmount());
	}

}
