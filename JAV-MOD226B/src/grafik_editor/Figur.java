package grafik_editor;

import java.awt.Color;

public class Figur implements Gruppe{
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
	
	public void move(int deltaX, int deltaY) {
		x += deltaX;
		y += deltaY;
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

	/* (non-Javadoc)
	 * XXX fix this and the .md file
	 * Note: I tried to make the Composite class a child of the Superclass of the leafes, so I could access the super class commands in directly in the interface so I did not need to have every leaf have the same code but have the code only in the interface method. This way it does not work extending the interface with a super class is not allowed. 'The type MySuperClass cannot be a superinterface of MyInterface; a superinterface must be an interface	MyInterface.java'. The other way round would be to have the super class be part of the interface aka implements MyInterface, then if the method you wanna use on all elements is in the super class make it a composite method, then you can maybe call it for the composite elements? This would still need a link form the leaf method to the super class method. Like if my method is empty use super class method instead. I don't know how to do this but is should be explained in the book which atm I dont have at hand.
	 * 
	 * @see #oopd-composite-design-pattern.md
	 * @see grafik_editor.Gruppe#gruppenCompositeAktion()
	 */
	@Override
	public void gruppenCompositeAktion() {
		setX(x+50);
		setY(y+500);
	}
}
