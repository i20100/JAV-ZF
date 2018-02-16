package mod226_08;

public class Zahlenreihe {

	private int zahl = 0;
	private int endzahl;

	public int getZahl() {
		zahl = zahl+1;
		return zahl;
	}

	/**
	 * @return the endzahl
	 */
	public int getEndzahl() {
		return endzahl;
	}

	/**
	 * @param endzahl the endzahl to set
	 */
	public void setEndzahl(int endzahl) {
		this.endzahl = endzahl;
	}

}
