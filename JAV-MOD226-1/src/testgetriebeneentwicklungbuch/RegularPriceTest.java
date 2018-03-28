package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class RegularPriceTest {
	private Price price;

	@BeforeEach
	void SetUp() {
		price = new RegularPrice();
	}

	@Test
	@DisplayName(value = "GetCharge for One Day")
	// rewritten the test from the book cause it does not work the same way with JUnit5
	void testGetChargeOneDay() {
		Euro euro = new Euro(1.50);
		Euro euro2 = Price.getCharge(1);
		System.out.println(euro.getAmount());
		System.out.println(euro2.getAmount());
		assertEquals(1.5, euro2.getAmount(), 0.001);
	}

	@Test
	@DisplayName(value = "GetCharge for Three Days")
	void testChargingThreeDaysRental() {
		Euro euro3 = new Euro(1.50);
		Euro euro4 = Price.getCharge(3);
		System.out.println(euro3.getAmount());
		System.out.println(euro4.getAmount());
		assertEquals(1.5, euro4.getAmount(), 0.001);
	}

	@Test
	@DisplayName(value = "GetCharge for Four Days")
	void testChargingFourDaysRental() {
		Euro euro = new Euro(1.50);
		Euro euro2 = Price.getCharge(4);
		System.out.println(euro.getAmount());
		System.out.println(euro2.getAmount());
		assertEquals(3, euro2.getAmount(), 0.001);
	}

	@Test
	@DisplayName(value = "GetCharge for Five Days")
	void testChargingFiveDaysRental() {
		Euro euro = new Euro(1.50);
		Euro euro2 = Price.getCharge(5);
		System.out.println(euro.getAmount());
		System.out.println(euro2.getAmount());
		assertEquals(4.5, euro2.getAmount(), 0.001);
	}
	
	@Test
	@Disabled
	@DisplayName("Disabled, Test 1 to 1 as in the book")
	public void testChargingOneDayRental() {
		Price price = new RegularPrice();
		assertEquals(new Euro(1.50), Price.getCharge(1));
	}
}
