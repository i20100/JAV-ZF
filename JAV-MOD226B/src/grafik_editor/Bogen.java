package grafik_editor;

public class Bogen extends Figur implements Gruppe{
	private int hoehe;
	private int breite;
	private int startWinkel;
	private int bogenWinkel;

	public Bogen(int x, int y, int h, int b, int sw, int bw) {
		super(x, y);
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
}
