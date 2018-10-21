package grafik_editor;

import java.awt.Color;

public class Kreis extends Figur implements Gruppe{
	private int radius;
	private boolean gefuellt;

	/**
	 * Erstellt Standard Kreis
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Kreis(int x, int y, int radius) {
		super(x, y);
		this.setRadius(radius);
	}

	/** 
	 * Erstellt Kreis mit gewaehlter Farbe
	 * @param x
	 * @param y
	 * @param c
	 * @param radius
	 */
	public Kreis(int x, int y, Color c, int radius) {
		super(x, y, c);
		this.setRadius(radius);
	}
	/**
	 * Erstellet einen ausgefuellten Kreis mit einer gewaehlten Farbe
	 * 
	 * @param x
	 * @param y
	 * @param c
	 * @param radius
	 * @param gefuellt
	 */
	public Kreis(int x, int y, Color c, int radius, boolean gefuellt) {
		super(x, y, c);
		this.setRadius(radius);
		this.setGefuellt(true);
	}
	
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @return the gefuellt
	 */
	boolean isGefuellt() {
		return gefuellt;
	}

	/**
	 * @param gefuellt the gefuellt to set
	 */
	void setGefuellt(boolean gefuellt) {
		this.gefuellt = gefuellt;
	}

	@Override
	public void gruppenCompositeAktion() {
		
	}

	@Override
	void strecken(double faktor) {
		setRadius((int) (radius*faktor));
	}

}
