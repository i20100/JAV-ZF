package testgetriebeneentwicklungbuch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mod226_08.Euro;

class PriceTest {

	@Test
	@DisplayName("testNEWRELEASEPricePerDay NEWRELEASE")
	public void testNEWRELEASEPricePerDay() {
		assertEquals(new Euro(2.00).getAmount(), Price.NEWRELEASE.getCharge(1).getAmount());
	}

	@Test
	@DisplayName("testNEWRELEASEPricePerTwoDays NEWRELEASE")
	public void testNEWRELEASEPricePerTwoDays() {
		assertEquals(new Euro(2.00).getAmount(), Price.NEWRELEASE.getCharge(2).getAmount());
	}

	@Test
	@DisplayName("testNEWRELEASEPriceWithExtraDays NEWRELEASE")
	public void testNEWRELEASEPriceWithExtraDays() {
		assertEquals(new Euro(3.75).getAmount(), Price.NEWRELEASE.getCharge(3).getAmount());
		assertEquals(new Euro(5.50).getAmount(), Price.NEWRELEASE.getCharge(4).getAmount());
	}
	
	@Test
	@DisplayName("Own tests One Day")
	public void testPriceNEWRELEASEOneDay() {
//		Price newPrice = Price.NEWRELEASE;
		Price newPrice = new Price(new Euro(2.00), new Euro(1.75), 2);
		
//		Irgendwo ist hier noch der Wurm drin, mit einer neuen Instanz von Price 
//		erhalte ich die zwei Euro als Antwort sonst aber die 1.50 aus dem REGULAR Klassenattribut
//		Vermutung die REGULAR nach NEWRELEASE kommt wird NEWRELEASE mit REGULAR überschrieben..
//		Vermutung bestätigt wenn ich in Klasse Price die Zeile Price REGULAR auskommentiere laufen alle tests!
		System.out.println(newPrice.getCharge(1).getAmount());
		assertEquals(new Euro(2.00).getAmount(), newPrice.getCharge(1).getAmount());
	}

}
