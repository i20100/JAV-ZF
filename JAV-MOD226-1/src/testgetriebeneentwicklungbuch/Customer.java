package testgetriebeneentwicklungbuch;

import mod226_08.Euro;

public class Customer {
	private Euro totalCharge = new Euro(0);

	public void rentMovie(int daysRented) {
		totalCharge = totalCharge.plus(Movie.getCharge(daysRented));
	}

	public Euro getTotalCharge() {
		return totalCharge;
	}

}
