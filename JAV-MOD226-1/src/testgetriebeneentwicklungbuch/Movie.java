package testgetriebeneentwicklungbuch;

import mod226_08.Euro;

public class Movie {
	
	private Price price = Price.NEWRELEASE;
	private String title;

	public Movie(String title, Price price) {
		this.title = title;
		this.price = price;
	}

	public double getCharge_OLD(int daysRented) {
		return getCharge(daysRented).getAmount();
	}

	public Euro getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

}
