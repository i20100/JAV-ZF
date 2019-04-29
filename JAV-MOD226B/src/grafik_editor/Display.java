package grafik_editor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Vector;

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
	//	Changed form local List to Vector in another Class
	Zeichnung zeichnung = new Zeichnung(new Vector<Figur>());

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
				zeichnung.zeichneFiguren(g);
			}
		});
	}
	
	public Zeichnung getZeichnung() {
		return zeichnung;
	}

	/* TODO wird in der Aufgabe 3 Kaptiel 4 vorgeschlagen, es brauche eine setZeichnungsmethode.
	 * Der Grund bzw. Nutzen ist mir unbekannt.
	 * Das Programm laeuft auch ohne diesen Zusatzcode.
	 * 
	 * Muss das Feld 'zeichung' private sein? Nicht sicher da kein UML dazu...
	 * Und deshalb der Zugriff ueber setZeichnung erfolgen??? 
	 * 
	 * 'In der Klasse braucht es neu eine Methode zum Setzen des zugehoerigen Zeichnungs-Objekt'
	 * 
	 * 'Das Testprogramm muss so ergaenzt werden, dass ein Zeichnungsobjekt 
	 * mit einigen Figuren erzeugt wird. Dieses muss dem Display mit der 
	 * setZeichnung()-Methode zur Anzeige uebergeben werden.'
	 * 
	 */
	/**
	 * Aufgabe setZeichnung noch unklar
	 * 
	 * Wurde aber in Kapitel 4, Aufgabe 3 vorgeschlagen und deshalb mal eingebaut aber
	 * ohne Funktion bzw. Code.
	 * 
	 * @param zeichnung
	 */
	public void setZeichnung(Zeichnung zeichnung) {
		this.zeichnung = zeichnung;
	}

}
