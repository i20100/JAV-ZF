package mod226_06_bank;

public class TestKonstruktor {

	public static void main(String[] args) {
		// Test des neuen Konstruktors für Zinssatz setzen
		Konto k1 =  new Konto(2);
		System.out.println(k1.getSaldo());
		k1.einzahlen(100);
		System.out.println(k1.getSaldo());
		k1.verzinsen(365);
		System.out.println(k1.getSaldo());
	}
}
