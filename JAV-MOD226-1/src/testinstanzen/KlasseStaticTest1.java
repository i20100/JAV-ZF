package testinstanzen;

public class KlasseStaticTest1 {

	private static int number1;
	private int number2;

	private static KlasseStaticTest1 value1 = new KlasseStaticTest1(1);
	private static KlasseStaticTest1 value2 = new KlasseStaticTest1(2);

	private static final KlasseStaticTest1 VALUE3 = new KlasseStaticTest1(3);
	private static final KlasseStaticTest1 VALUE4 = new KlasseStaticTest1(4);


	public KlasseStaticTest1(int value) {
		//		this.number1 = value; // Vorschlag war 'change access to static' siehe nächste Zeile
		KlasseStaticTest1.number1 = value;
		this.number2 = value;
	}

	public void printNumbers() {
		System.out.println(number1 + " " + number2);
	}

	public static void main(String[] args) {

		System.out.println("Teste verhalten von Klasseninstanzen welche direkt via Klassenreferenzen erstellt werden:");
		System.out.println(value1);
		System.out.println(value2);
		value1.printNumbers();
		value2.printNumbers();

		System.out.println(VALUE3);
		System.out.println(VALUE4);
		VALUE3.printNumbers();
		VALUE4.printNumbers();
	}

}
