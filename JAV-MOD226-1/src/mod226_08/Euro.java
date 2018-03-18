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

	public Euro plus(Euro other) {
		return new Euro(this.cents + other.cents);
	}

	public Euro times(int factor) {
		return new Euro(cents * factor);
	}

}
