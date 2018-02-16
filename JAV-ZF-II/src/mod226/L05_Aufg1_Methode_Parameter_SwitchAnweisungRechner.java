package mod226;

import java.lang.reflect.Method;

public class L05_Aufg1_Methode_Parameter_SwitchAnweisungRechner {

	private static int result;

	public static void main(String[] args) {
		/*DONE At this stage I need to know more about methods in general 
		 * => consulting book "Grundlagen JAVA" Chapter Methods p.40-44
		 * This could be solved with only adding Text for invalid entries,
		 * but then I can also learn how to write own Exceptions and
		 * throw one of these...
		 */
		//XXX add return? operand1 is the result aka return value but this should not be printed always!
		// if there is an invalid operator aka not int or 5 < operator < 1
		//=> needs exception handling first
		//DONE learn exception handling
		//DONE therefore add custom exception handling
		//DONE add try and catch
		//DONE add throwing
		//FUNNY it still does finish the operation or give out the invalid result!
		//XXX fix this if you can, its not a bug but a problem I didn't think about.

		System.out.println(result); // No value given to result, still it will give back 0!

		// Normal Method call
		calc(1,1,1);
		System.out.println(result);

		// special Method call
		calc(1,1,6);
		System.out.println(result);

		// activate this method to test all cases
		testAllCases();
	}


	/**
	 * Computes operand1 with operand2 with chosen operator
	 * 
	 * @param operand1
	 * @param operand2
	 * @param operator -> see switch below
	 * @return
	 * @throws IllegalArgumentException
	 * 
	 * Swtich:
	 * 1	add operand1 and operand2
	 * 2	substract operand2 from operand1
	 * 3	multiply operand1 with operand2
	 * 4	whole number division of operand1 with operand2
	 * 5	leftover of division from operand1 with operand2
	 */
	private static int calc(int operand1, int operand2, int operator) throws IllegalArgumentException {
		try {
			if (operator < 1) {
				throw new IllegalArgumentException("Operator unknown - allowed operators are:\"\r\n" + 
						"					+ \"1 - add, 2 sub, 3 multiply, 4 divide, 5 modulo");
			}
			if (operator > 5) {
				throw new IllegalArgumentException("Operator unknown - allowed operators are:\"\r\n" + 
						"					+ \"1 - add, 2 sub, 3 multiply, 4 divide, 5 modulo");
			}
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		switch (operator) {
		case 1:
			result = operand1 + operand2;
			break;
		case 2:
			result = operand1 - operand2;
			break;
		case 3:
			result = operand1 * operand2;
			break;
		case 4:
			result = operand1 / operand2;
			break;
		case 5:
			result = operand1 % operand2;
			break;
		default:
			break;
		}
		return result;
	}

	/**
	 *  Simple way to test all cases of operands
	 */
	private static void testAllCases() {
		// Test all cases:
		for (int i = 1; i < 7; i++) {
			System.out.println("Test case: "+ i);
			calc(2, 1, i);
			System.out.println(result);
		}
	}
}
