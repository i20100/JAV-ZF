package grafik_editor;

import java.awt.Color;

public class Linie extends Figur implements Gruppe{
	private int endX, endY;

	public Linie(int x, int y, int endX, int endY) {
		super(x, y);
		this.setEndX(endX);
		this.setEndY(endY);
	}

	public Linie(int x, int y, Color c, int endX, int endY) {
		super(x, y, c);
		this.setEndX(endX);
		this.setEndY(endY);
	}

	/**
	 * @return the endX
	 */
	public int getEndX() {
		return endX;
	}

	/**
	 * @param endX the endX to set
	 */
	public void setEndX(int endX) {
		this.endX = endX;
	}

	/**
	 * @return the endY
	 */
	public int getEndY() {
		return endY;
	}

	/**
	 * @param endY the endY to set
	 */
	public void setEndY(int endY) {
		this.endY = endY;
	}

//	@Override
//	public void gruppenCompositeAktion() {
//		super.setX(x+50);
//		super.setY(y+50);
//	}
	public void gruppenCompositeAktion() {
		super.gruppenCompositeAktion();
	}

}
