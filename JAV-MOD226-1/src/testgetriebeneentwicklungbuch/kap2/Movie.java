package testgetriebeneentwicklungbuch.kap2;

public class Movie {
	private static final double BASE_PRICE = 2.00; // Euro
	private static final double PRICE_PER_DAY = 1.75; // Euro
	private static final int DAYS_DISCOUNTED = 2;

	public static double getCharge(int daysRented) {
		double result = 0;
		result = result + BASE_PRICE;
		if (daysRented > DAYS_DISCOUNTED) {
			result = result + (daysRented - DAYS_DISCOUNTED) * PRICE_PER_DAY;
		}
		return result;
	}

}
