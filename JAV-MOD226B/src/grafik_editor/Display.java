package grafik_editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Die Klasse Display stellt ein Fenster auf dem Bildschirm zur Verfuegung, in welchem
 * Figur-Objekte dargestellt werden koennen.
 * Siehe auch Java-Grundkurs Abschnitt 10.2 und 10.3.
 * 
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Display extends JFrame {
	/** Die Liste der dargestellten Figur-Objekte */
	private List<Figur> figuren = new ArrayList<Figur>();

	/**
	 * Konstruktor. Initialisiert das Fenster in der Mitte des Bildschirms und erzeugt ein
	 * JFrame-Objekt, auf welchem die Figuren gezeichnet werden.
	 */
	public Display() {
		Dimension windowSize = new Dimension(800, 600);
		setSize(windowSize);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int windowPositionX = (screenSize.width - windowSize.width) / 2;
		int windowPositionY = (screenSize.height - windowSize.height) / 2;
		Point windowPosition = new Point(windowPositionX, windowPositionY);
		setLocation(windowPosition);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createAndAddDrawingPanel();
		setVisible(true);
	}

	private void createAndAddDrawingPanel() {
		// Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
		// Siehe Java-Grundkurs Abschnitt 3.9
		add(new JPanel() {
			// Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
			// Methode beim Display aufruft.
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				zeichneFiguren(g);
			}
		});
	}

	/**
	 * Zeichnet alle Figuren.
	 * @param g Referenz auf das Graphics-Objekt zum Zeichnen.
	 */
	/**
	 * @param g
	 */
	private void zeichneFiguren(Graphics g) {
		for (Figur f : figuren) {
			/*  DONE Problem, da nun Rechteckgefuellt ein Kind von Rechteck ist, 
			 *  erhalte ich unerwuenschte zusaetzliche Rechteke im Editor -> Loesung:
			 *  'if Rechteckgefuellt do, elseif Rechteck do for Rechteck only'
			 */
			if (f instanceof Rechteckgefuellt) {
				Rechteckgefuellt rg = (Rechteckgefuellt) f;
				if (f.c == null) {// if Color not set, fill rectangle with Standardcolor
					g.fillRect(rg.x, rg.y, rg.getBreite(), rg.getHoehe());
				} 
				Color current = g.getColor();
				g.setColor(f.c); //else fill with set Color
				g.fillRect(rg.x, rg.y, rg.getBreite(), rg.getHoehe());
				g.setColor(current); // reset Color to current aka Reset Color selection to default
			}
			else if (f instanceof Rechteck) {
				Rechteck r = (Rechteck)f;
				//        g.drawRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe()); // Original code
				g.drawRect(r.y, r.x, r.getBreite(), r.getHoehe()); // adapted code, since x, y are super but only protected attributes
			}
			if (f instanceof Linie) {
				Linie l = (Linie) f;
				Color current = g.getColor();
				g.setColor(f.c);
				g.drawLine(l.x, l.y, l.getEndX(), l.getEndY());
				g.setColor(current); // reset Color to current aka Reset Color selection to default
			}
			if (f instanceof Kreis) {
				Kreis k = (Kreis) f;
				if (k.isGefuellt() == true) {
					if (f.c == null) {
						g.fillOval(k.x, k.y, k.getRadius(), k.getRadius());
					}
					Color current = g.getColor();
					g.setColor(f.c);
					g.fillOval(k.x, k.y, k.getRadius(), k.getRadius());
					g.setColor(current); // reset Color to current aka Reset Color selection to default
				}
				if (f.c == null) {
					g.drawOval(k.x, k.y, k.getRadius(), k.getRadius());
				}
				Color current = g.getColor();
				g.setColor(f.c);
				g.drawOval(k.x, k.y, k.getRadius(), k.getRadius());
				g.setColor(current); // reset Color to current aka Reset Color selection to default

				//				if (k.gefuellt == false) { // if fill is false drawOval else draw fillOval
				//					if (f.c != null) { // if no color is set draw black oval
				//					g.drawOval(k.x, k.y, k.getRadius(), k.getRadius());
				//				} // else draw colored oval
				//					Color current = g.getColor();
				//					g.setColor(f.c);
				//					g.drawOval(k.x, k.y, k.getRadius(), k.getRadius());
				//					g.setColor(current); // reset Color to current aka Reset Color selection to default
				//				}
				//				// else
				//				Color current = g.getColor();
				//				g.setColor(f.c);
				//				g.fillOval(k.x, k.y, k.getRadius(), k.getRadius());
				//				g.setColor(current); // reset Color to current aka Reset Color selection to default
			}
			if (f instanceof Text) {
				//g.setFont(new Font(null, 0, 20)); // Tester for Fontsize
				Text t = (Text) f;
				// if strecken() shall be applied do:
				if (t.getStrecken() != 0) {
					Font originalFont = g.getFont(); // save current font
					if (t.getSchriftgroesse() == 0) {
						t.setSchriftgroesse(12);
					}
					g.setFont(new Font(null, 0, (int) (t.getSchriftgroesse()*t.getStrecken())));
					g.drawString(t.getText(), t.x, t.y);
					g.setFont(originalFont); // re apply current font
				}
				// if strecken() shall not be applied do:
				else if (t.getStrecken() == 0) {
					g.drawString(t.getText(), t.x, t.y);
				}
			}
			if (f instanceof Bogen) {
				Bogen b = (Bogen) f;
				g.drawArc(b.x, b.y, b.getBreite(), b.getHoehe(), b.getStartWinkel(), b.getBogenWinkel());
			}
			if (f instanceof Ellipse) {
				Ellipse e = (Ellipse) f;
				if (e.isGefuellt() == true) {
					if (f.c == null) {
						g.fillOval(e.x, e.y, e.getBreite(), e.getHoehe());
					}
					Color current = g.getColor();
					g.setColor(f.c);
					g.fillOval(e.x, e.y, e.getBreite(), e.getHoehe());
					g.setColor(current); // reset Color to current aka Reset Color selection to default
				}
				if (f.c == null) {
					g.drawOval(e.x, e.y, e.getBreite(), e.getHoehe());
				}
				Color current = g.getColor();
				g.setColor(f.c);
				g.drawOval(e.x, e.y, e.getBreite(), e.getHoehe());
				g.setColor(current); // reset Color to current aka Reset Color selection to default
			}

		}
	}

	/**
	 * Fuegt eine weitere Figur hinzu und loest die Auffrischung des Fensterinhaltes aus.
	 * @param figur Referenz auf das weitere Figur-Objekt.
	 */
	public void hinzufuegen(Figur figur) {
		figuren.add(figur);
		repaint();
	}

	/**
	 * Loescht alle Figuren und loest die Auffrischung des Fensterinhaltes aus.
	 */
	public void allesLoeschen() {
		figuren.clear();
		repaint();
	}
}
