package mastermind;

import java.util.Scanner;

public class MenuMastermind {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO finish Menu similar to menu.jpage
		Menu();
	}

	private static void Menu() {
		System.out.println("[1] Spiel starten");
		System.out.println("[2] Spiel Info");
		System.out.println("[3] Spiel Optionen");
		System.out.println("Wähle Zahl, bestätige mit Enter:");

		String s = sc.nextLine();

		int key = Integer.parseInt(s);
		//		int key = sc.nextInt(); // skips the break in the cases but why?

		switch (key) {
		case 1:
			//TODO insert game starting mechanic
			System.out.println("1 geht noch?");
			BackToMenu();
			break;
		case 2:
			//TODO insert game info
			System.out.println(test());
			BackToMenu();
			break;
		case 3:
			//TODO insert game options: debug/cheat toggle
			BackToMenu();
			break;
		default:
			//TODO insert default is start game
			break;
		}
	}


	private static void BackToMenu() {
		System.out.println("\n Drücke Enter um fortzufahren..");
		String next = sc.nextLine();
		Menu();
	}

	private static String test() {
		int versuche = 4; //TODO replace variable versuche with the global one
		System.out.println("Sie haben " + versuche+ " Versuche um den Code zu knacken. Der Code besteht aus den Zahlen 1-6."
				+ "Der Code besteht aus vier Stellen. Viel Erfolg!");
		return null;
	}

}