package mod226;

import java.util.Arrays;

public class L04_Aufg2_TrippleArray_Minimal_Temp {

	private static int days = 3;
	private static int groups = 3;
	private static int samples = 4;

	public static void main(String[] args) {
		// TODO Idea: on six days, three locations, four temperature messeurements each
		//DONE write a random number generator for numbers between 20-30
		// DONE write this 3d-array with random numbers (20-30)
		//TODO generate a scanner which tells where are the lowest temps. and prints em
		// Like: lowest are in day(line) x, location(group) y, time(Element) y for all lowest temp.

		int[][][] temperaturesArray = new int[days][groups][samples];
		int[][][] tempMinArray = new int[days][groups][samples];


		// Check more dimensional array arrayname.length value is?
		// arrayname.length value is equal to first value when creating
		// more dimensional arrays. ex: new int [6][3][4] arrayname.length is 6!
		/*
		 * for (int i = 0; i < temperaturesArray.length; i++) {
		 * System.out.println(i);
		 *		}
		 */


		//DONE create 3-d array [][][]
		for (int i = 0; i < temperaturesArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				for (int k = 0; k < samples; k++) {
					double myrandom = Math.random()* 10 + 20;
					//					System.out.println(myrandom);
					temperaturesArray[i][j][k] = (int) myrandom;
				}
			}
		}

		System.out.println("Table Legend");
		System.out.println("Row = Day, Brackets = Place, Numbers = temperature measurement");

		//DONE print 3-d array according to task, including output format!
		for (int i = 0; i < temperaturesArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				System.out.print("(");
				for (int k = 0; k < samples; k++) {
					System.out.print(" ");
					System.out.print(temperaturesArray[i][j][k]);
					System.out.print(" ");
				}
				System.out.print(")");
			}
			System.out.println();
		}
		System.out.println();


		//DONE copy Array if you dont want to mess up the data!
		for (int i = 0; i < temperaturesArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				for (int k = 0; k < samples; k++) {
					tempMinArray[i][j][k]=temperaturesArray[i][j][k];
				}
			}
		}

		//DONE Testing copy with print to syso
		/*		for (int i = 0; i < tempMinArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				System.out.print("(");
				for (int k = 0; k < samples; k++) {
					System.out.print(" ");
					System.out.print(tempMinArray[i][j][k]);
					System.out.print(" ");
				}
				System.out.print(")");
			}
			System.out.println();
		}
		 */

		//TODO sort for lowest
		//TODO Print Like: lowest are in day(line) x, location(group) y, time(Element) y for all lowest temp.
		for (int i = 0; i < tempMinArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				for (int k = 0; k < samples-1; k++) {
					if (tempMinArray[i][j][k]>tempMinArray[i][j][k+1]) {
						int tempMin = tempMinArray[i][j][k];
						tempMinArray[i][j][k+1]=tempMinArray[i][j][k];
						tempMinArray[i][j][k+1]=tempMin;
					}
				}
			}
		}

		//TODO sort for lowest broken redo it with 4 numbers fix!!
		int[] tempFix = {25, 26, 23, 22};
		System.out.println(Arrays.toString(tempFix));
		
		for (int i = 0; i < tempFix.length; i++) {
			
		for (int j = 0; j < tempFix.length-1; j++) {
			if (tempFix[j]>tempFix[j+1]) {
				int tempMin= tempFix[j];
				tempFix[j]=tempFix[j+1];
				tempFix[j+1]=tempMin;
			}
			}
		}
		System.out.println(Arrays.toString(tempFix));
		
		
/*		
		//DONE print sorted array as test
		for (int i = 0; i < tempMinArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				System.out.print("(");
				for (int k = 0; k < samples; k++) {
					System.out.print(" ");
					System.out.print(tempMinArray[i][j][k]);
					System.out.print(" ");
				}
				System.out.print(")");
			}
			System.out.println();
		}
*/


	}
}
