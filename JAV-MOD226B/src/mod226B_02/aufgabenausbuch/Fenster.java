package mod226B_02.aufgabenausbuch;

import java.awt.Cursor;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenster extends JFrame {
	public Fenster() {
		super("Einfaches Fenster");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {

		Fenster frame = new Fenster();

		int[] types = {Cursor.CROSSHAIR_CURSOR, Cursor.HAND_CURSOR, 
				Cursor.MOVE_CURSOR, Cursor.TEXT_CURSOR, Cursor.WAIT_CURSOR, 
				Cursor.DEFAULT_CURSOR};

		for (int type : types) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}

			Cursor c = Cursor.getPredefinedCursor(type);
			frame.setCursor(c);
			frame.setTitle(c.getName());
		}
	}
}
