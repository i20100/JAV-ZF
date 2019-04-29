package mod226B_02.aufgabenausbuch;


// partial representation of program 5.20
public class MathTest_5_20 {
	public static String myString = "Hi";
	public static void horn() {
		System.out.println("Beep");
	}

	public static void main(String[] args) {
		double x = 3.5, y = 2;
		double abstand = Math.hypot(x, y);
		System.out.println("Abstand: "+ abstand);

		System.out.println(Math.PI);
		System.out.println(Math.sqrt(9));

		System.out.println(MathTest_5_20.myString);
		MathTest_5_20.horn();
	}

}
