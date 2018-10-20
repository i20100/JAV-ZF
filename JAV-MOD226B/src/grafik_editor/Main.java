package grafik_editor;

import java.awt.Color;

public class Main {
	private static final Display display = new Display();


	public static void main(String[] args) {
		Rechteck r = new Rechteck(20, 20, 100, 20);
		Rechteck r2 = new Rechteck(40, 30, 100, 20);
		Linie l = new Linie(50, 30, 100, 20);
		Linie l2 = new Linie(70, 60, 50, 30);
		Linie l3 = new Linie(70, 60, Color.GREEN, 50, 30);
		Kreis k = new Kreis(70, 60, 20);
		Kreis k2 = new Kreis(50, 50, 30);
		Text t = new Text(100, 100, 10, "Font?", "Hello World!");
		Bogen b = new Bogen(20, 200, 50, 90, 45, 180);
		Ellipse e = new Ellipse(20, 220, 50, 90);
		Rechteckgefuellt rg = new Rechteckgefuellt(30, 320, 40, 90);
		Rechteckgefuellt rg2 = new Rechteckgefuellt(40, 330, Color.CYAN, 40, 90);
		Kreis k3 = new Kreis(50, 40, Color.CYAN, 30, true); // gefuellter Kreis
		Kreis k4 = new Kreis(60, 40, Color.RED, 30); // farbiger Kreis ohne Fuellung
		Ellipse e2 = new Ellipse(30, 230, Color.RED, 50, 90);
		Ellipse e3 = new Ellipse(40, 240, Color.ORANGE, 50, 90, true);
		Ellipse e4 = new Ellipse(50, 250, null, 50, 90, true);

		display.hinzufuegen(r);
		display.hinzufuegen(r2);
		display.hinzufuegen(l);
		display.hinzufuegen(l2);
		display.hinzufuegen(l3);
		display.hinzufuegen(k);
		display.hinzufuegen(k2);
		display.hinzufuegen(t);
		display.hinzufuegen(b);
		display.hinzufuegen(e);
		display.hinzufuegen(rg);
		display.hinzufuegen(rg2);
		display.hinzufuegen(k3);
		display.hinzufuegen(k4);
		display.hinzufuegen(e2);
		display.hinzufuegen(e3);
		display.hinzufuegen(e4);

		// Initialize Composite class 
		CompositeGruppe cg = new CompositeGruppe();

		// Composes the Leafs
		cg.add(l);
		cg.add(l2);
		cg.add(t);

		// call the Composie method for all elements in the list
		cg.gruppenCompositeAktion();

		display.hinzufuegen(l);
		display.hinzufuegen(l2);
		display.hinzufuegen(t);

		r.move(50, 50);
		display.hinzufuegen(r);
		Linie l4 = new Linie(100, 400, 300, 400);
		Linie l5 = new Linie(200, 350, 400, 350);
		l4.move(100, 50);
		display.hinzufuegen(l4);
		display.hinzufuegen(l5);

		// Test gem. Aufgabe 3, Kapitel 3, zeigt das bei beiden die move Methode von der Klasse Linie angewendet wird.
		Linie l6 = new Linie(10, 20, 30, 40);
		l6.move(10, 10);
		Figur f = new Linie(10, 20, 30, 40);
		f.move(10, 10);
	}


	/**
	 * @return the display
	 */
	public static Display getDisplay() {
		return display;
	}

}
