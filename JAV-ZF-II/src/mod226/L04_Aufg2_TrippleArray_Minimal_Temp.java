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

		//DONE sort for lowest
		for (int i = 0; i < tempMinArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				for (int j2 = 0; j2 < samples; j2++) {
					for (int k = 0; k < samples-1; k++) {
						if (tempMinArray[i][j][k]>tempMinArray[i][j][k+1]) {
							int tempMin = tempMinArray[i][j][k];
							tempMinArray[i][j][k]=tempMinArray[i][j][k+1];
							tempMinArray[i][j][k+1]=tempMin;
						}
					}
				}
			}
		}

		//DONE find lowest number in whole 3-d array. means get lowest number for each group and sort for lowest
		//DONE find lowest temp? write daily lows in one array and sort for lowest 
		//Array size? Per group 1 number, 3 groups times number of days
		int[] lowestAll = new int [days*groups];
		int counter = 0;
		for (int i = 0; i < tempMinArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				lowestAll[counter] = tempMinArray[i][j][0];
				counter = counter+1;
			}
		}
		System.out.println(Arrays.toString(lowestAll));

		//DONE sort lowestAll for lowest
		//Reminder: lowest temperature is lowestAll[0]
		for (int i = 0; i < lowestAll.length; i++) {
			for (int j = 0; j < lowestAll.length-1; j++) {
				if (lowestAll[j]>lowestAll[j+1]) {
					int buffer = lowestAll[j];
					lowestAll[j]=lowestAll[j+1];
					lowestAll[j+1]=buffer;
				}
			}
		}
		System.out.println(Arrays.toString(lowestAll));
		
		//DONE Print Like: lowest are in day(line) x, location(group) y, time(Element) y for all lowest temp.
		System.out.println("Die tiefste gemessene Temperatur ist: "+lowestAll[0]+ ", und wurde gemessen an:");
		for (int i = 0; i < temperaturesArray.length; i++) {
			for (int j = 0; j < groups; j++) {
				for (int k = 0; k < samples; k++) {
					if (lowestAll[0]==temperaturesArray[i][j][k]) {
						System.out.println("Tag: "+ i +" "
								+"Station: "+ j+ " "
								+"Element: "+ k);
					}
				}
			}
		}


		//DONE sort for lowest broken redo it with 4 numbers fix!!
		//Main error above? copy i+1 to i, was copy i to i+1!
		/*		
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

		 */

		//DONE print sorted array as test
		
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

	}
}
