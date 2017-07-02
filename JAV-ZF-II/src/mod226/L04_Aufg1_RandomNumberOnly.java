package mod226;

public class L04_Aufg1_RandomNumberOnly {
	public static void main(String[] args) {

		//	Get Random Number from 1-50
		//	https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
		double random = Math.random() * 50 + 1;		
		System.out.println(random); // Prints random as double
		System.out.println((int)random); // Prints random as int, Note the downcast

	}
}
