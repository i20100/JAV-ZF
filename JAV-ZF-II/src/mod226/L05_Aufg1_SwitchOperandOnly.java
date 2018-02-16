package mod226;

public class L05_Aufg1_SwitchOperandOnly {

	public static void main(String[] args) {
		int operator = 2;
		char operatorIs = 0;
		char[] result;

		//		int result = (2(operatorIs)1); THIS is impossible in JAVA!!!
//		see explaination in Logbook, java doesnt allow to pack Operators into variables
//		You will always have to write out every instruction single handedly 
//		Or implement .javascript which can do it

		System.out.println("result");
		
		switch (operator) {
		case 1:
			operatorIs = ('+');
			break;
		case 2:
			operatorIs = '-';
			break;
			default:
				System.out.println("Invalid operand.");
		}

		
		
	}

}
