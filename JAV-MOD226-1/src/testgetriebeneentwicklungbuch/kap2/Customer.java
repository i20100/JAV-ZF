package testgetriebeneentwicklungbuch.kap2;

public class Customer {
	private double totalCharge = 0;

	public void rentMovie(int daysRented) {
		totalCharge = totalCharge + Movie.getCharge(daysRented).getAmount();
	}

	public double getTotalCharge() {
		return totalCharge;
	}

}
