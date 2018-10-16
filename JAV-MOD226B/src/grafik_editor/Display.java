package grafik_editor;

import java.awt.Dimension;
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
	private void zeichneFiguren(Graphics g) {
		for (Figur f : figuren) {
			if (f instanceof Rechteck) {
				Rechteck r = (Rechteck)f;
				//        g.drawRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe()); // Original code
				g.drawRect(r.y, r.x, r.getBreite(), r.getHoehe()); // adapted code, since x, y are super but only protected attributes
			}
			if (f instanceof Linie) {
				Linie l = (Linie) f;
				g.drawLine(l.x, l.y, l.getEndX(), l.getEndY());
			}
			if (f instanceof Kreis) {
				Kreis k = (Kreis) f;
				g.drawOval(k.x, k.y, k.getRadius(), k.getRadius());
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
