package mod226B_02.aufgabenausbuch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Zeichnen_10_2 extends JFrame{
	public Zeichnen_10_2() {
		super("Grafik");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// DONE Add 2nd Panel, what will happen? Will the windows size adjust? -> No now the panel will be overwritten.
		add(new MyPanel2());  
		add(new MyPanel());  
		pack();
		setVisible(true);
	}

	private static class MyPanel2 extends JPanel {
		public MyPanel2() {
			setBackground(Color.black);
			setPreferredSize(new Dimension(150, 300));
		}
	}

	private static class MyPanel extends JPanel {
		public MyPanel() {
			setBackground(Color.orange);
			setPreferredSize(new Dimension(300, 200));
		}

		/* DONE when exactly is this code executed? I could not figure it out just by analyzing it! So find out with debugger!
		 * Even with the debugger it wont show me because in the debugger the program ends, but then the screen is not drawn 
		 * properly and the text will not show? How strange why? The debugger can not go to the end only with step over (F6). 
		 * You might have to go on with the resume (F8) button. So as seen in the debugger the lines from the paintComponent(Grafics g)
		 * will be done after all my program has been done. Aka they are stored to be processed in another thread as far as I see.
		 * Why I know, because it will be executed after the main method is done! In the debugger you can still see active threads.
		 * Sidenote: The book says the g comes directly form the JVM-runtime, this is still a bit vague, but remeber this, the important part here is
		 * the Graphics g argument in the method! Graphics g exists because you have a Window and a Panel aka a component.
		 * */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.fillRoundRect(30, 30, 240, 140, 30, 30);
			g.setColor(Color.gray);
			g.setFont(new Font("Monospaced", Font.BOLD, 48));
			g.drawString("Hallo! Was wenn ich mehr Text habe?", 65, 110);
		}

		@SuppressWarnings("unused")
		public static void main(String[] args) {
			new Zeichnen_10_2();
		}
	}
}
