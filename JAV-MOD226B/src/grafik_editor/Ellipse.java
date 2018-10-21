package grafik_editor;

import java.awt.Color;

public class Ellipse extends Figur implements Gruppe{
	private int breite;
	private int hoehe;
	private boolean gefuellt;

	public Ellipse(int x, int y, int b, int h) {
		super(x, y);
		setHoehe(h);
		setBreite(b);
	}

	public Ellipse(int x, int y, Color c, int b, int h) {
		super(x, y, c);
		setHoehe(h);
		setBreite(b);
	}

	public Ellipse(int x, int y, Color c, int b, int h, boolean gefuellt) {
		super(x, y, c);
		setHoehe(h);
		setBreite(b);
		setGefuellt(true);
	}

	/**
	 * @return the hoehe
	 */
	int getHoehe() {
		return hoehe;
	}
	/**
	 * @param hoehe the hoehe to set
	 */
	void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	/**
	 * @return the breite
	 */
	int getBreite() {
		return breite;
	}

	/**
	 * @param breite the breite to set
	 */
	void setBreite(int breite) {
		this.breite = breite;
	}

	/**
	 * @return the gefuellt
	 */
	public boolean isGefuellt() {
		return gefuellt;
	}

	/**
	 * @param gefuellt the gefuellt to set
	 */
	public void setGefuellt(boolean gefuellt) {
		this.gefuellt = gefuellt;
	}

	@Override
	public void gruppenCompositeAktion() {
		
	}

	@Override
	void strecken(double faktor) {
		setBreite((int) (breite*faktor));
		setHoehe((int) (hoehe*faktor));
	}




}
