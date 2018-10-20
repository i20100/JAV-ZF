package grafik_editor;

import java.awt.Color;

public class Figur {
	protected int x, y;
	protected Color c;

	public Figur(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Figur(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


}
