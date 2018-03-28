package testgetriebeneentwicklungbuch;

import mod226_08.Euro;

public class Price {

	private static Euro basePrice;
	private static Euro pricePerDay;
	private static int  daysDiscounted;

	public Price(Euro basePrice, Euro pricePerDay, int  daysDiscounted) {
		this.basePrice = basePrice;
		this.pricePerDay = pricePerDay;
		this.daysDiscounted = daysDiscounted;
	}

	public static Euro getCharge(int daysRented) {
		if (daysRented <= daysDiscounted) return basePrice;

		int additionalDays = daysRented - daysDiscounted;
		return basePrice.plus(pricePerDay.times(additionalDays));
	}

	public Price() {
		super();
	}

}