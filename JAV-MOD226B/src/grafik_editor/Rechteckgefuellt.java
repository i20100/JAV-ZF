package grafik_editor;

import java.awt.Color;

public class Rechteckgefuellt extends Figur implements Gruppe{
	private int breite, hoehe;

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
	public Rechteckgefuellt(int x, int y, int breite, int hoehe) {
		super(x, y);
		this.setBreite(breite);
		this.setHoehe(hoehe);	
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
		super(x, y, c);
		setBreite(b);
		setHoehe(h);	
	}


	/**
	 * @return the breite
	 */
	public int getBreite() {
		return breite;
	}

	/**
	 * @param breite the breite to set
	 */
	public void setBreite(int breite) {
		this.breite = breite;
	}

	/**
	 * @return the hoehe
	 */
	public int getHoehe() {
		return hoehe;
	}

	/**
	 * @param hoehe the hoehe to set
	 */
	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	@Override
	public void gruppenCompositeAktion() {
		// TODO Auto-generated method stub
		
	}
}
