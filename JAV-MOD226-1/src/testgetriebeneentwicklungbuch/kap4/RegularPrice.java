package testgetriebeneentwicklungbuch.kap4;

import mod226_08.Euro;

public class RegularPrice {

	private static final Euro BASERPICE = new Euro(1.50);
	private static final Euro PRICE_PER_DAY = new Euro(1.50);
	private static final int DAYS_DISCOUNTED = 3;

	public Euro getCharge(int daysRented) {
		//		new Code fails from book
		//		Euro result = new Euro(1.50);
		//		if (daysRented == 4) result.add(new Euro(1.50));
		//		return result;

		////		this is not considered good, cause it does not represent the complexity
		////		of having a base price and an increment
		////		so in the example it gets changed with code further below
		//		if (daysRented <= 3) return new Euro(1.50);
		//		return new Euro(3.00);

		//		if (daysRented <= 3) return new Euro(1.50);
		//		return new Euro(1.50).add(new Euro(1.50));

		// Good code needs good names
		//		if (daysRented <= DAYS_DISCOUNTED) return BASERPICE;
		//		return BASERPICE.add(PRICE_PER_DAY);

		if (daysRented <= DAYS_DISCOUNTED) return BASERPICE;

		int additionalDays = daysRented - DAYS_DISCOUNTED;
		return BASERPICE.add(PRICE_PER_DAY.times(additionalDays));
	}

}
