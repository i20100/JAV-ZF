package grafik_editor;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Zeichent einen Bogen gemaess {@link java.awt.Graphics#drawArc(int, int, int, int, int, int)}
 * @see java.awt.Graphics#drawArc(int, int, int, int, int, int)
 * 
 * @author Vincent
 *
 */
public class Bogen extends Figur implements Gruppe{
	private int hoehe;
	private int breite;
	private int startWinkel;
	private int bogenWinkel;

	/**
	 * Gemaess Erklaerung, ist 0° bei drei Uhr, negative Werte sind gegen den Uhrzeigersinn, positive mit.
	 * 
	 * @see java.awt.Graphics#drawArc(int, int, int, int, int, int)
	 * @param x
	 * @param y
	 * @param h
	 * @param b
	 * @param sw
	 * @param bw
	 */
	public Bogen(int x, int y, int h, int b, int sw, int bw) {
		super(x, y);
		setHoehe(h);
		setBreite(b);
		setStartWinkel(sw);
		setBogenWinkel(bw);
	}

	public Bogen(int x, int y, Color c, int h, int b, int sw, int bw) {
		super(x, y, c);
		setHoehe(h);
		setBreite(b);
		setStartWinkel(sw);
		setBogenWinkel(bw);
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
	 * @return the startWinkel
	 */
	public int getStartWinkel() {
		return startWinkel;
	}

	/**
	 * @param startWinkel the startWinkel to set
	 */
	public void setStartWinkel(int startWinkel) {
		this.startWinkel = startWinkel;
	}

	/**
	 * @return the bogenWinkel
	 */
	public int getBogenWinkel() {
		return bogenWinkel;
	}

	/**
	 * @param bogenWinkel the bogenWinkel to set
	 */
	public void setBogenWinkel(int bogenWinkel) {
		this.bogenWinkel = bogenWinkel;
	}

	@Override
	public void gruppenCompositeAktion() {
		super.setX(x+50);
		super.setY(y+50);
	}

	@Override
	void strecken(double faktor) {
		setBreite((int) (breite*faktor));
		setHoehe((int) (hoehe*faktor));
	}

	@Override
	void spiegeln(boolean vertikal) {
		//vertikal
		if (vertikal) {
			setStartWinkel(-startWinkel);
			setBogenWinkel(-bogenWinkel);
		}
		// else horizontal
		else {
			setStartWinkel(180-bogenWinkel);
		}
	}

	@Override
	public void drehen() {
		setStartWinkel(startWinkel+270);
	}

	@Override
	protected void zeichne(Graphics g) {
		g.drawArc(x, y, getBreite(), getHoehe(), getStartWinkel(), getBogenWinkel());
	}
}
