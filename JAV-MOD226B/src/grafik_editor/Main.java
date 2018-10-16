package grafik_editor;

public class Main {
	private static final Display display = new Display();


	public static void main(String[] args) {
		Rechteck r = new Rechteck(20, 20, 100, 20);
		Rechteck r2 = new Rechteck(40, 30, 100, 20);
		Linie l = new Linie(50, 30, 100, 20);
		Linie l2 = new Linie(70, 60, 50, 30);
		Kreis k = new Kreis(70, 60, 20);
		Kreis k2 = new Kreis(50, 50, 30);
		
		display.hinzufuegen(r);
		display.hinzufuegen(r2);
		display.hinzufuegen(l);
		display.hinzufuegen(l2);
		display.hinzufuegen(k);
		display.hinzufuegen(k2);
	}


	/**
	 * @return the display
	 */
	public static Display getDisplay() {
		return display;
	}

}
