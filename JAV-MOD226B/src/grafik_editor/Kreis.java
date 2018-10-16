package grafik_editor;

public class Kreis extends Figur{
	private int radius;

	public Kreis(int x, int y, int radius) {
		super(x, y);
		this.setRadius(radius);
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

}
