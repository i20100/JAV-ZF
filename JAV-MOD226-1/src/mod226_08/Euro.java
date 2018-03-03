package mod226_08;

public class Euro {
	//	private final long cents;
	private long cents;

	public Euro(double euro) {
		cents = Math.round(euro * 100.0);
	}

	private Euro(long cents) {
		this.cents = cents;
	}

	public double getAmount() {
		return cents / 100.0;
	}

	public Euro add(Euro other) {
//				cents = this.cents + other.cents; // those two make old and new Euro the same object
//				return other;*/
		return new Euro(this.cents + other.cents);
	}

}
