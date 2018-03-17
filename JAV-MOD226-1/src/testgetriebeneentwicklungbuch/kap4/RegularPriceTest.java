package testgetriebeneentwicklungbuch.kap4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class RegularPriceTest {
	private RegularPrice price;

	@BeforeEach
	void SetUp() {
		price = new RegularPrice();
	}


	@Test
	@DisplayName(value = "GetCharge for One Day")
	// rewritten the test from the book cause it does not work the same way with JUnit5
	void testGetChargeOneDay() {
		Euro euro = new Euro(1.50);
		Euro euro2 = price.getCharge(1);
		System.out.println(euro);
		System.out.println(price.getCharge(1));
		assertEquals(euro.getAmount(), euro2.getAmount(), 0.001);
	}

	@Test
	@DisplayName(value = "GetCharge for One Day")
	void testChargingThreeDaysRental() {
		Euro euro3 = new Euro(1.50);
		Euro euro4 = price.getCharge(3);
		assertEquals(euro3.getAmount(), euro4.getAmount(), 0.001);
	}



	@Test
	@Disabled
	@DisplayName(value = "Disabled, Old Test GetCharge for One Day")
	void testGetChargeOneDay2() {
		RegularPrice price = new RegularPrice();
		Euro euro = new Euro(1.50);
		System.out.println(euro);
		System.out.println(price.getCharge(1));
		assertEquals(new Euro(1.50), price.getCharge(1)); // Old way told in the book, does not work
	}

	@Test
	@Disabled
	@DisplayName("Disabled, Test 1 to 1 as in the book")
	public void testChargingOneDayRental() {
		RegularPrice price = new RegularPrice();
		assertEquals(new Euro(1.50), price.getCharge(1));
	}
}
