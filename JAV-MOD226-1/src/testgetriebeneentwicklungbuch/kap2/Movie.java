package testgetriebeneentwicklungbuch.kap2;

import mod226_08.Euro;

public class Movie {
	private static final Euro BASE_PRICE = new Euro(2.00); // Euro
	private static final Euro PRICE_PER_DAY = new Euro(1.75); // Euro
	//	private static final double BASE_PRICE = 2.00; // Euro
	//	private static final double PRICE_PER_DAY = 1.75; // Euro
	private static final int DAYS_DISCOUNTED = 2;

	public static double getCharge(int daysRented) {
		Euro result = BASE_PRICE;
		if (daysRented > DAYS_DISCOUNTED) {
			int additionalDays = daysRented - DAYS_DISCOUNTED;
			result = result.plus(PRICE_PER_DAY.times(additionalDays));
		}
		return result.getAmount();
	}
}
