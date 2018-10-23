package grafik_editor;

import java.awt.Color;

public class Rechteck extends Figur implements Gruppe {
	private int breite, hoehe;

	public Rechteck(int x, int y, int breite, int hoehe) {
		super(x, y);
		this.setBreite(breite);
		this.setHoehe(hoehe);
	}


	public Rechteck(int x, int y, Color c, int breite, int hoehe) {
		super(x, y, c);
		this.setBreite(breite);
		this.setHoehe(hoehe);
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

	}


	@Override
	void strecken(double faktor) {
		setBreite((int) (breite*faktor));
		setHoehe((int) (hoehe*faktor));
	}


	@Override
	void spiegeln(boolean vertikal) {
		// not implemented, cause no effect!		
	}


	@Override
	public void drehen() {
		// hoehe und breite werden vertauscht
		int oldHoehe = getHoehe();
		setHoehe(getBreite());
		setBreite(oldHoehe);
	}
}
