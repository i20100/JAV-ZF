package test;

import java.util.Scanner;

public class MenuTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		boolean exit = false;

		System.out.println("-- Command interpreter --");
		System.out.println("[1] Write results to console");
		System.out.println("[2] Write results to text file");
		System.out.println("[3] exit");
		System.out.println("-------------------------");
		System.out.print("Input Value folled by enter: ");

		String s = sc.nextLine();

		int i = Integer.parseInt(s);

		switch (i)
		{
		case 1:
		{
//			writeToScr();
			System.out.println("Case 1");
			System.out.println("\n\nPress any key to continue..");
			sc.next();
			break;
		}
		case 2:
		{
//			writeToFile();
			System.out.println("Case 2");
			System.out.println("\n\nPress any key to continue..");
			sc.next();
			break;
		}
		case 3:
		{
			exit = true;
			break;
		}
		default:
		{
			System.out.println("Unknown Entry.");
			break;
		}
		}

		if (exit)
		{
			System.out.println("Exit!");
			return;
		}
	}
}
