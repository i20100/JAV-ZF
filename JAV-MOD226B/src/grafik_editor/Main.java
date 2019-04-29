package grafik_editor;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	private static final Display display = new Display();
	
	// save file path
	private static String path = new String("src/grafik_editor/figurObjekte.m226");

	public static void main(String[] args) {
		Text textForTestSet1 = new Text(10, 10, "Rechtecke, Linien, Ellipsen und Kreise Test:");
		Rechteck r = new Rechteck(10, 20, 10, 10);
		Rechteck r2 = new Rechteck(10, 20, 15, 10);
		Linie l = new Linie(40, 20, Color.RED, 40, 30);
		Linie l2 = new Linie(40, 20, Color.GREEN, 50, 30);
		Linie l3 = new Linie(40, 20, Color.BLUE, 50, 20);
		Kreis k = new Kreis(60, 20, 10);
		Kreis k2 = new Kreis(75, 20, Color.RED, 10);
		Kreis k3 = new Kreis(90, 20, Color.GREEN, 10);
		Kreis k4 = new Kreis(105, 20, Color.BLUE, 10); // farbiger Kreis ohne Fuellung
		Kreis k5 = new Kreis(120, 20, Color.BLACK, 10, true); // Kreis mit Fuellung
		Text t = new Text(140, 30, "Hello World!");
		Bogen b = new Bogen(10, 40, 50, 90, 45, 180);
		Ellipse e = new Ellipse(140, 40, null, 10, 20, true);
		Ellipse e2 = new Ellipse(150, 40, Color.RED, 10, 20);
		Ellipse e3 = new Ellipse(160, 40, Color.GREEN, 10, 20);
		Ellipse e4 = new Ellipse(170, 40, Color.BLUE, 10, 20);

		display.zeichnung.hinzufuegen(textForTestSet1);
		display.zeichnung.hinzufuegen(r);
		display.zeichnung.hinzufuegen(r2);
		display.zeichnung.hinzufuegen(l);
		display.zeichnung.hinzufuegen(l2);
		display.zeichnung.hinzufuegen(l3);
		display.zeichnung.hinzufuegen(k);
		display.zeichnung.hinzufuegen(k2);
		display.zeichnung.hinzufuegen(t);
		display.zeichnung.hinzufuegen(b);
		display.zeichnung.hinzufuegen(e);
		display.zeichnung.hinzufuegen(k3);
		display.zeichnung.hinzufuegen(k4);
		display.zeichnung.hinzufuegen(k5);
		display.zeichnung.hinzufuegen(e2);
		display.zeichnung.hinzufuegen(e3);
		display.zeichnung.hinzufuegen(e4);

		//TODO Composite class breaks intended x, y of above tests.
		//		1. But why does it break the code?
		//		2. Why did I use this composite anyway?
		// to 1. -> see composite class it has a x+50, y+500 method!
		//		solve 2.
		
		/*
		 * // Initialize Composite class CompositeGruppe cg = new CompositeGruppe();
		 * 
		 * // Composes the Leafs cg.add(l); cg.add(l2); cg.add(t);
		 * 
		 * // call the Composie method for all elements in the list
		 * cg.gruppenCompositeAktion();
		 * 
		 * display.data.hinzufuegen(l); display.data.hinzufuegen(l2); display.data.hinzufuegen(t);
		 */

		Text moveTestText = new Text(10, 100, "Move Line Test:");
		display.zeichnung.hinzufuegen(moveTestText);

		r.move(50, 50);
		display.zeichnung.hinzufuegen(r);
		Linie l4 = new Linie(10, 110, Color.BLUE, 300, 110);
		Linie l5 = new Linie(10, 110, Color.RED, 300, 110);
		l4.move(0, -5);
		display.zeichnung.hinzufuegen(l4);
		display.zeichnung.hinzufuegen(l5);

		// Test gem. Aufgabe 3, Kapitel 3, zeigt das bei beiden die move Methode von der Klasse Linie angewendet wird.
		Text moveTestText2 = new Text(10, 140, "Move Line Test2:");
		display.zeichnung.hinzufuegen(moveTestText2);
		Linie referenzLinie = new Linie(10, 150, 300, 150);
		Linie l6 = new Linie(10, 150, Color.RED, 300, 150);
		l6.move(5, 5);

		Linie referenzLinie2 = new Linie(10, 160, 300, 160);
		Figur f = new Linie(10, 160, Color.GREEN, 300, 160);
		f.move(5, 10);

		display.zeichnung.hinzufuegen(referenzLinie);
		display.zeichnung.hinzufuegen(referenzLinie2);
		display.zeichnung.hinzufuegen(l6);
		display.zeichnung.hinzufuegen(f);


		// Test strecken() gem. Zusatzaufgaben aus Kapitel 3
		Text streckenTest = new Text(10, 190, "Strecke Line Test:");
		display.zeichnung.hinzufuegen(streckenTest);
		Linie l7 = new Linie(10, 200, 200, 200);
		Linie l8 = new Linie(10, 205, 200, 205);
		l8.strecken(.75);

		display.zeichnung.hinzufuegen(l7);
		display.zeichnung.hinzufuegen(l8);

		//Symetrie Test, dies ist nur zur Darstellung und muss nicht erfuellt werden
		Text symetrie = new Text(10, 230, "Test der aktuellen Symetrie der Figuren:");
		display.zeichnung.hinzufuegen(symetrie);

		Rechteck rgs1 = new Rechteckgefuellt(10, 240, null, 10, 20);
		Kreis kst1 = new Kreis(10, 240, Color.red, 10);
		display.zeichnung.hinzufuegen(rgs1);
		display.zeichnung.hinzufuegen(kst1);

		Rechteck rgs2 = new Rechteckgefuellt(40, 240, null, 20, 20);
		Kreis kst2 = new Kreis(40, 240, Color.red, 20);
		display.zeichnung.hinzufuegen(rgs2);
		display.zeichnung.hinzufuegen(kst2);

		Rechteck rgs3 = new Rechteckgefuellt(80, 240, null, 40, 20);
		Kreis kst3 = new Kreis(80, 240, Color.red, 40);
		display.zeichnung.hinzufuegen(rgs3);
		display.zeichnung.hinzufuegen(kst3);

		Rechteck rgs4 = new Rechteckgefuellt(140, 240, null, 50, 50);
		Kreis kst4 = new Kreis(140, 240, Color.red, 50);
		Kreis k2st4 = new Kreis(140, 240, Color.GREEN, 10);
		Kreis k3st4 = new Kreis(140, 240, Color.BLUE, 75);
		display.zeichnung.hinzufuegen(rgs4);
		display.zeichnung.hinzufuegen(kst4);
		display.zeichnung.hinzufuegen(k2st4);
		display.zeichnung.hinzufuegen(k3st4);

		// Test strecken() Kreis, Rechteck, Bogen, Ellipse, Rechteckgefuellt, Text
		Text streckenTest2 = new Text(10, 340, "Strecke restliche Figuren Test:");
		display.zeichnung.hinzufuegen(streckenTest2);

		Kreis ks1 = new Kreis(10, 350, 10);
		Kreis ks2 = new Kreis(10, 350, Color.RED, 10);
		ks2.strecken(2);
		display.zeichnung.hinzufuegen(ks1);
		display.zeichnung.hinzufuegen(ks2);

		Rechteck rs1 = new Rechteck(40, 350, 10, 10);
		Rechteck rs2 = new Rechteck(40, 350, Color.RED, 10, 10);
		rs2.strecken(2);
		display.zeichnung.hinzufuegen(rs1);
		display.zeichnung.hinzufuegen(rs2);

		Bogen bs1 = new Bogen(80, 350, 10, 10, 45, 180);
		Bogen bs2 = new Bogen(80, 350, Color.RED, 10, 10, 45, 180);
		bs2.strecken(2);
		display.zeichnung.hinzufuegen(bs1);
		display.zeichnung.hinzufuegen(bs2);

		Ellipse es1 = new Ellipse(120, 350, 15, 5);
		Ellipse es2 = new Ellipse(120, 350, Color.RED, 15, 5);
		es2.strecken(2);
		display.zeichnung.hinzufuegen(es1);
		display.zeichnung.hinzufuegen(es2);


		Rechteckgefuellt rg = new Rechteckgefuellt(160, 350, 5, 20);
		Rechteckgefuellt rg2 = new Rechteckgefuellt(170, 350, Color.RED, 5, 20);
		rg2.strecken(2);
		display.zeichnung.hinzufuegen(rg);
		display.zeichnung.hinzufuegen(rg2);


		Text tn1 = new Text(10, 400, "Normaler Text");
		Text tgs1 = new Text(10, 420, "Normaler Text gestreckt 2x");
		tgs1.strecken(2);
		display.zeichnung.hinzufuegen(tn1);
		display.zeichnung.hinzufuegen(tgs1);

		// spiegeln tests, Linie, Bogen	
		Text spiegeln = new Text(400, 80, "Spiegeln tests:");
		Linie l9 = new Linie(400, 100, 450, 130);
		Linie l10 = new Linie(400, 140, 450, 170);
		Linie l11 = new Linie(400, 140, Color.RED, 450, 170);
		display.zeichnung.hinzufuegen(spiegeln);
		display.zeichnung.hinzufuegen(l9);
		l10.spiegeln(true);
		display.zeichnung.hinzufuegen(l10);
		display.zeichnung.hinzufuegen(l11);
		Bogen b3 = new Bogen(500, 100, 50, 90, 5, 80);
		Bogen b4 = new Bogen(500, 100, Color.RED, 50, 90, 5, 80);
		Bogen b5 = new Bogen(500, 100, Color.ORANGE, 50, 90, 5, 80);
		b4.spiegeln(true);
		b5.spiegeln(false);
		display.zeichnung.hinzufuegen(b3);
		display.zeichnung.hinzufuegen(b4);
		display.zeichnung.hinzufuegen(b5);

		// drehen tests, Linie, Rechteck, Ellipse, Bogen
		Text drehen = new Text(400, 190, "Drehen 90° tests:");
		Linie l12 = new Linie(400, 200, 450, 220);
		Linie l13 = new Linie(400, 200, Color.ORANGE, 450, 220);
		l13.drehen();
		display.zeichnung.hinzufuegen(drehen);
		display.zeichnung.hinzufuegen(l12);
		display.zeichnung.hinzufuegen(l13);
		Rechteck r3 = new Rechteck(400, 230, 30, 20);
		Rechteck r4 = new Rechteckgefuellt(400, 230, Color.ORANGE, 30, 20);
		r4.drehen();
		display.zeichnung.hinzufuegen(r3);
		display.zeichnung.hinzufuegen(r4);
		Ellipse e5 = new Ellipse(400, 270, 20, 40);
		Ellipse e6 = new Ellipse(400, 270, Color.ORANGE, 20, 40);
		e6.drehen();
		display.zeichnung.hinzufuegen(e5);
		display.zeichnung.hinzufuegen(e6);
		Bogen b6 = new Bogen(470, 200, 25, 50, 5, 80);
		Bogen b7 = new Bogen(470, 200, Color.ORANGE, 25, 50, 5, 80);
		b7.drehen();
		b7.drehen();
		display.zeichnung.hinzufuegen(b6);
		display.zeichnung.hinzufuegen(b7);

		// drehen tests 2, Linie, Rechteck, Ellipse, Bogen
		Text drehen2 = new Text(400, 330, "Drehen einzelne Grad tests: CODE fehlt!");
		display.zeichnung.hinzufuegen(drehen2);
		Rechteck r5 = new Rechteck(400, 350, 30, 20);
		Rechteck r6 = new Rechteck(400, 350, Color.ORANGE, 30, 20);
		r6.drehen();
		display.zeichnung.hinzufuegen(r5);
		display.zeichnung.hinzufuegen(r6);
		
		// Speichere die Figuren-Objekte:

		// erstelle Figur save file
		// DONE remember to delete this file when done! Delete in FigurLoader
		File file = new File(path);
		
		// Display.zeichnung ergo speichere aktuelles 'display' Object
		try {
			FigurSaver.save(display, file);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
		// Loesche alle Figuren
		display.zeichnung.allesLoeschen();
		System.out.println("Figuren geloescht.");
		
		// Wait 3 seconds
		waitX(3_000);
		
		// DONE refreshe die Ausgabe
		System.out.println("Refreshing!");
		// DONE how to refresh the display?
		/* TODO document the repaint() method
		 * 
		 * repaint() works because Display extends JFrame!
		 * First check out Display then JFrame!
		 */
		// TODO git commit repaint() separate from save_and_load!
		display.repaint();
		
		// Wait 3 seconds
		waitX(3_000);

		System.out.println("Reloading objects!");
		
		// DONE reload objects from File with FigurLoader
		try {
			display.zeichnung = FigurLoader.load(display, file);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		// repaint() display with reloaded objects
		display.repaint();
	}


	/**
	 * Waits inserted time in milliseconds
	 * 
	 * @param x time in milliseconds
	 */
	private static void waitX(int x) {
		// DONE wait 'time' in milliseconds
		int time = x; // time in milliseconds

		System.out.println("Waiting "+time/1000+" seconds to continue.");
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}


	/**
	 * @return the display
	 */
	public static Display getDisplay() {
		return display;
	}

}
