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
		Text t = new Text(100, 100, "Hello World!");
		Bogen b = new Bogen(200, 200, 50, 90, 45, 180);
		Ellipse e = new Ellipse(20, 220, 50, 90);
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

		// Test strecken() gem. Zusatzaufgaben aus Kapitel 3
		Linie l7 = new Linie(300, 10, 400, 10);
		Linie l8 = new Linie(300, 20, 400, 20);
		l8.strecken(.75);

		display.hinzufuegen(l7);
		display.hinzufuegen(l8);

		// Test strecken() Kreis, Rechteck, Bogen, Ellipse, Rechteckgefuellt, Text
		k4.strecken(2);
		display.hinzufuegen(k4);
		r2.strecken(1.5);
		display.hinzufuegen(r2);
		Bogen b2 = new Bogen(200, 200, 50, 90, 45, 180);
		b2.strecken(2);
		display.hinzufuegen(b2);
		e.strecken(2);
		display.hinzufuegen(e);
		Rechteckgefuellt rg = new Rechteckgefuellt(30, 320, 40, 90);
		Rechteckgefuellt rg2 = new Rechteckgefuellt(200, 320, 20, 30);
		rg2.strecken(2);
		Rechteckgefuellt rg3 = new Rechteckgefuellt(40, 330, Color.CYAN, 40, 90);		
		display.hinzufuegen(rg);
		display.hinzufuegen(rg2);
		display.hinzufuegen(rg3);
		Text t2 = new Text(400, 50, "Hello World!");
		t2.strecken(4);
		display.hinzufuegen(t2);

		// spiegeln tests, Linie, Bogen	
		Text spiegeln = new Text(400, 80, "Spiegeln tests:");
		Linie l9 = new Linie(400, 100, 450, 130);
		Linie l10 = new Linie(400, 140, 450, 170);
		Linie l11 = new Linie(400, 140, Color.RED, 450, 170);
		display.hinzufuegen(spiegeln);
		display.hinzufuegen(l9);
		l10.spiegeln(true);
		display.hinzufuegen(l10);
		display.hinzufuegen(l11);
		Bogen b3 = new Bogen(500, 100, 50, 90, 5, 80);
		Bogen b4 = new Bogen(500, 100, Color.RED, 50, 90, 5, 80);
		Bogen b5 = new Bogen(500, 100, Color.ORANGE, 50, 90, 5, 80);
		b4.spiegeln(true);
		b5.spiegeln(false);
		display.hinzufuegen(b3);
		display.hinzufuegen(b4);
		display.hinzufuegen(b5);

		// drehen tests, Linie, Rechteck, Ellipse, Bogen
		Text drehen = new Text(400, 190, "Drehen 90° tests:");
		Linie l12 = new Linie(400, 200, 450, 220);
		Linie l13 = new Linie(400, 200, Color.ORANGE, 450, 220);
		l13.drehen();
		display.hinzufuegen(drehen);
		display.hinzufuegen(l12);
		display.hinzufuegen(l13);
		Rechteck r3 = new Rechteck(400, 230, 30, 20);
		Rechteck r4 = new Rechteckgefuellt(400, 230, Color.ORANGE, 30, 20);
		r4.drehen();
		display.hinzufuegen(r3);
		display.hinzufuegen(r4);
		Ellipse e5 = new Ellipse(400, 270, 20, 40);
		Ellipse e6 = new Ellipse(400, 270, Color.ORANGE, 20, 40);
		e6.drehen();
		display.hinzufuegen(e5);
		display.hinzufuegen(e6);
		Bogen b6 = new Bogen(470, 200, 25, 50, 5, 80);
		Bogen b7 = new Bogen(470, 200, Color.ORANGE, 25, 50, 5, 80);
		b7.drehen();
		b7.drehen();
		display.hinzufuegen(b6);
		display.hinzufuegen(b7);

		// drehen tests 2, Linie, Rechteck, Ellipse, Bogen
		Text drehen2 = new Text(400, 330, "Drehen einzelne Grad tests:");
		display.hinzufuegen(drehen2);
		Rechteck r5 = new Rechteck(400, 350, 30, 20);
		Rechteck r6 = new Rechteck(400, 350, Color.ORANGE, 30, 20);
		r6.drehen();
		display.hinzufuegen(r5);
		display.hinzufuegen(r6);
	}


	/**
	 * @return the display
	 */
	public static Display getDisplay() {
		return display;
	}

}
