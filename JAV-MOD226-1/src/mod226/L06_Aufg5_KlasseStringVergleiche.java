package mod226;

public class L06_Aufg5_KlasseStringVergleiche {

	public static void main(String[] args) {
//		Test aus Aufgabe 5:
		System.out.println("Test Aufgabe 5:");
		String x = new String("hallo");
		String y = new String("hallo");
		System.out.println( x == y); // Referenz (Speicher) ungleich = false
		System.out.println(x.equals(y)); // Inhalt identisch = true
	}

}
