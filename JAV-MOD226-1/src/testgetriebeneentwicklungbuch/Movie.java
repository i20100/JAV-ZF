package testgetriebeneentwicklungbuch;

import mod226_08.Euro;

public class Movie {

	public static double getCharge_OLD(int daysRented) {
		return getCharge(daysRented).getAmount();
	}

	public static Euro getCharge(int daysRented) {
		return new NewReleasePrice().getCharge(daysRented);
	}
}
