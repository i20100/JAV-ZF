package mod226;

import java.util.Arrays;

public class L04_Aufg2_TrippleArray_Minimal_Temp {

	private static int samples = 4;
	private static int groups = 3;
	private static int days = 6;

	public static void main(String[] args) {
		// TODO Idea: on six days, three locations, four temperature messeurements each
		//DONE write a random number generator for numbers between 20-30
		// TODO write this 3d-array with random numbers (20-30)
		//TODO generate a scanner which tells where are the lowest temps. and prints em
		// Like: lowest are in day(line) x, location(group) y, time(Element) y for all lowest temp.

		int[] temperaturesArray = new int[samples];
		
		for (int i = 0; i < temperaturesArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				for (int j2 = 0; j2 < days; j2++) {
					
					double myrandom = Math.random()* 10 + 20;
					System.out.println(myrandom);
					temperaturesArray[i] = (int) myrandom;
				}
			}

		}

		System.out.println(Arrays.toString(temperaturesArray));
		
	}

}
