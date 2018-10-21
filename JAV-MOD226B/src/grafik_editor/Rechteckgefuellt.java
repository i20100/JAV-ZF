package grafik_editor;

import java.awt.Color;

public class Rechteckgefuellt extends Rechteck implements Gruppe{

	/**
	 * Erstellt ein ausgefuelltes Rechteck mit der Standardfarbe
	 * 
	 * @param x
	 * @param y
	 * @param breite
	 * @param hoehe
	 * 
	 * @see     java.awt.Graphics#fillRect(int, int, int, int) for x,y and breite, hoehe explanaition
	 */
	public Rechteckgefuellt(int x, int y, int b, int h) {
		super(x, y, b, h);
	}

	/**
 	 * Erstellt ein ausgefuelltes Rechteck mit einer gewaehlten Farbe
	 * 
	 * @param x
	 * @param y
	 * @param c Farbauswahl, Bsp. 'Color.RED'
	 * @param b
	 * @param h
	 * 
 	 * @see     java.awt.Graphics#fillRect(int, int, int, int) for 'x, y, breite, hoehe' explanaition
	 * @see		java.awt.Color for more on color object usage and possibilties
	 */
	public Rechteckgefuellt(int x, int y, Color c, int b, int h) {
		super(x, y, c, b, h);
	}

	@Override
	public void gruppenCompositeAktion() {
	}

	@Override
	void strecken(double faktor) {
		super.strecken(faktor);
	}
}
