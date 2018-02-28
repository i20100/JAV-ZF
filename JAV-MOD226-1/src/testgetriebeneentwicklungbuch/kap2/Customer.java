package testgetriebeneentwicklungbuch.kap2;

public class Customer {
	private double totalCharge = 0;
	private static final double BASE_PRICE = 2.00; // Euro
	private static final double PRICE_PER_DAY = 1.75; // Euro
	private static final int DAYS_DISCOUNTED = 2;

	public void rentMovie(int daysRented) {
		totalCharge = totalCharge + BASE_PRICE;
		if (daysRented > DAYS_DISCOUNTED) {
			totalCharge = totalCharge + (daysRented - DAYS_DISCOUNTED) * 1.75;
		}
	}

	public double getTotalCharge() {
		return totalCharge;
	}

}
