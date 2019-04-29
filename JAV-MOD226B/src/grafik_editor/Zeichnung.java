package grafik_editor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Vector;


/*
 * TODO Klasse Zeichnung
 * Doch die Klasse Zeichnung macht Sinn. Nennt man diese Klasse das Interface zwischen Display und Figur?
 */

/**
 * Die Klasse Zeichnung ist das ??Interface?? zwischen Display und Figur
 * 
 * Die Klasse Zeichnung zeichent alle Figuren. Die Figuren werden im 'Vector-array' figuren gesammelt.
 * 
 * @author vinma
 *
 */
@SuppressWarnings("serial")
public class Zeichnung implements Serializable {
	private Vector<Figur> figuren;

	/* TODO why do I need both of these constructors, if I uncomment one the program will not work anymore.
	Explain as soon as you can why both are needed.
	 */
	/*	Ohne diesen Konstruktor geht es nicht. Wieso?
	 * Fehlermeldung ohne diesen Konstruktor bei Figur.java; public Figur(int x, int y):
	 * Implicit super constructor Zeichnung() is undefined. Must explicitly invoke another constructor
	 */
	public Zeichnung() {
		figuren = new Vector<Figur>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 4033941516558890772L;
		};
	}

	// Dieser Konstruktor wird von Display aufgerufen
	public Zeichnung(Vector<Figur> vector) {
		figuren = vector;
	}

	/**
	 * Zeichnet alle Figuren.
	 * 
	 * @param g Referenz auf das Graphics-Objekt zum Zeichnen.
	 */
	public void zeichneFiguren(Graphics g) {

		// TODO Um die Aufgabe 3: Polymorphismus und Delegation im Programm Grafikeditor, zu loesen:
		// Finde den besten Weg, dies so einfach und automatisiert zu erledigen mit Eclipse Hilfsfunktionen!
		// z.B. mit Refactor um das Array als ein neues Interface 'Zeichnung' herauszuloesen, damit moeglichst aller Code 
		//		automatisch angpasst wird durch das IDE.


		// XXX remove the color code before and after f.zeichne(g) with some better code to draw color if needed
		// once I learned how to do it better, cause now 28.2.2019 I don't know a better way.
		for (Figur f : figuren) {
			Color current = g.getColor();
			g.setColor(f.c);
			f.zeichne(g); // main draw action, rest is just for Color selection see XXX above
			g.setColor(current); // reset Color to current aka Reset Color selection to default
		}

		// XXX old part of code, the part for text might not work in new part above so here you can see how I did it in the old part
		for (Figur f : figuren) {
			/*  DONE Problem, da nun Rechteckgefuellt ein Kind von Rechteck ist, 
			 *  erhalte ich unerwuenschte zusaetzliche Rechteke im Editor -> Loesung:
			 *  'if Rechteckgefuellt do, elseif Rechteck do for Rechteck only'
			 */
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
		}
	}

	/**
	 * Fuegt eine weitere Figur hinzu und loest die Auffrischung des Fensterinhaltes aus.
	 * @param figur Referenz auf das weitere Figur-Objekt.
	 */
	public void hinzufuegen(Figur figur) {
		figuren.add(figur);
//				repaint();
	}

	/**
	 * Loescht alle Figuren und loest die Auffrischung des Fensterinhaltes aus.
	 */
	public void allesLoeschen() {
		figuren.clear();
		//		repaint();
	}

}
