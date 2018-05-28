package test;

import java.util.Scanner;

/**
 * @author Vincent
 *
 *Example from: https://stackoverflow.com/questions/19063001/extracting-digits-of-int-in-java
 *
 *int num = 128;
 *String number = String.valueOf(num);
 *for(int i = 0; i < number.length(); i++) {
 *    int j = Character.digit(number.charAt(i), 10);
 *        System.out.println("digit: " + j);
 *        }
 *        Output:
 *
 *        digit: 1
 *        digit: 2w
 *        digit: 8
 *
 */
public class ScannerIntToSingleInt {

	public static void main(String[] args) {
		System.out.println("Give me a Number larger than 9:");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println(number);

		String number1 = String.valueOf(number);
		for(int i = 0; i < number1.length(); i++) {
			int j = Character.digit(number1.charAt(i), 10);
			System.out.println("digit: " + j);
		}
	}

}
