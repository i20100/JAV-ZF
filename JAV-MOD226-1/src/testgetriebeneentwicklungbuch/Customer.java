package testgetriebeneentwicklungbuch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mod226_08.Euro;

public class Customer {
	@SuppressWarnings("rawtypes")
	private List rentals = new ArrayList();
	private Euro totalCharge = new Euro(0);

	@SuppressWarnings("unchecked")
	public void rentMovie(Movie movie, int daysRented) {
		totalCharge = totalCharge.plus(movie.getCharge(daysRented));
		rentals.add(new Rental(movie, daysRented));
	}

	public Euro getTotalCharge() {
		Euro result = new Euro(0);
		for (@SuppressWarnings("rawtypes")
		Iterator i = rentals.iterator(); i.hasNext();) {
			Rental rental = (Rental) i.next();
			result = result.plus(rental.getCharge());
		}
		return result;
	}

	public String printStatement() {
		String result = "";
		for (@SuppressWarnings("rawtypes")
		Iterator i = rentals.iterator(); i.hasNext();) {
			Rental rental = (Rental) i.next();
			result += "\t" + rental.getMovieTitle()
			+ "\t" + rental.getCharge().format() + "\n";
		}
		result += "Gesamt: " + getTotalCharge().format() + "\n";
		return result;
	}

}
