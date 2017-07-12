package publish;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mastermind {
	/**
	 * Initial variables needed for the game
	 * 
	 * codeArray = variable for saving the computer generated code tipArray =
	 * variable for saving the user input versuche = number of tries for the
	 * user to find the code zaehler = counter for tries of user to find the
	 * code
	 */
	static int tries = 10;
	static int counter = 0;

	public static int[] codeArray = { 0, 0, 0, 0 }; //FIXME reactivate for live version! 
	//	public static int[] codeArray = { 1, 1, 2, 4 }; // Just for testing!
	private static int[] copyCode; // needed for user evaluation
	public static int[] tipArray = { 0, 0, 0, 0 };
	private static int[][] tipHistory = new int[tries][3];

	private static boolean debugMode = false;
	private static Scanner sc;
	private static int tipUser;
	private static int numbCorrectWithoutPos;
	private static int numbCorretPos;
	private static boolean gameRestartLoop = true;

	/**
	 * This is the game Mastermind.
	 * <p>
	 * Game description: The computer chooses four colors 
	 * from six possible ones (represented as numbers 1-6).
	 * The player tries to guess this combination of numbers.
	 * The try is given as a four digit number by the player.
	 * The programm compares the try with the "code" and gives some feedback.
	 * If the "code" has been found or there are no more tries left the game ends.
	 * <p>
	 * 
	 * @param args
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		//XXX handle InputMismatchExeption with try {} catch (){}!, could be nicer but works
		//DONE re-implement generate code!
		//DONE beautiful menu from menu.jpage implement the like into mastermind?
		// started under ***mastermind>MenuMastermind.java*** impelmented
		// [1] Start game
		// [2] Game Manual
		// [3] Options -> todo add debugMode boolean <b> ** debugg on / off option ** </b> 
		//DONE change code visible according to debugMode state!
		//DONE berechneAnrRichtigeOhnePos not working as it should!
		//DONE remove syso("digit:...)
		//DONE give tip history before every tip (array(arraytipnr(tip,amp,aop))
		//DONE insert restart game when game ends via solved or out of tries
		//TODO make tiphistory as table? https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
		//DONE make runnable exe
		//TODO close reader at end of main?
		//DONE make input possible as one number of 4 digits 
		//(shoulb be possible easy way with space, since java recognizes space as separator)
		//TODO commit git when last version of CLI only
		//TODO release game for friends
		//TODO make a GUI with colors to click and submit
		//TODO implement missing Game requirements from doc AB226A-01-1.docx:
		//TODO according to task switch colors to letters:
		//
		//			r	red
		//			g	green
		//			y	yellow
		//			p	pink
		//			w	white
		//			b	black
		//
		//TODO			Die Eingabe des Spielers soll jeweils auf einer neuen Zeile eingelesen werden. Sie soll aus einer Folge von vier Buchstaben ohne Zwischenraum bestehen und wird mit der Return-Taste abgeschlossen.
		//
		//TODO			Das Programm soll die Benutzereingabe auf Korrektheit checken (validieren) und im Falle einer fehlerhaften Eingabe eine entsprechende Meldung ausgeben und zur Wiederholung der Eingabe auffordern.
		//
		//TODO			Die Ausgaben des Programms sollen so gestaltet werden, dass dem Benutzer jederzeit klar ist, was von ihm erwartet wird (Benutzerfreundlichkeit).

		do {
			intro(); // disable for faster debugging
			Menu();
			generateCode(); // whole Method has blockcomment

			do {
				tipUser();
				tipEqualCode();
				evalUserInput();
				tipHistory();
				if (debugMode == true) {
					debugger(); // debugMode state can be set in the Menu!
				}

			} while (tries > counter);

			restartCodeNotFound();

		} while (gameRestartLoop  = true);
		exit();
	}


	private static void restartCodeNotFound() {
		System.out.println("\n" +
				"No tries left. " + "Code not found." +
				"\n" + "Code was: "+ arrayToString(codeArray) + "." + 
				"\n" + "Game over." + "\n\n" + "Press Enter to start new game.");
		@SuppressWarnings("unused")
		String next = sc.nextLine(); //Just to get the Enter to continue the program
	}


	public static void intro() {
		System.out.println("::::	 ::::     :::      :::::::: ::::::::::: :::::::::: :::::::::");  
		System.out.println("*:*:*: :*:*:*   :*: :*:   :*:    :*:    :*:     :*:        :*:    :*:"); 
		System.out.println("*:* *:*:* *:*  *:*   *:*  *:*           *:*     *:*        *:*    *:*"); 
		System.out.println("*#*  *:*  *#* *#**:**#**: *#**:**#**    *#*     *#**:**#   *#**:**#: "); 
		System.out.println("*#*       *#* *#*     *#*        *#*    *#*     *#*        *#*    *#*"); 
		System.out.println("#*#       #*# #*#     #*# #*#    #*#    #*#     #*#        #*#    #*#"); 
		System.out.println("###       ### ###     ###  ########     ###     ########## ###    ###"); 
		System.out.println();
		System.out.println("          ::::    ::::  ::::::::::: ::::    ::: :::::::::            "); 
		System.out.println("          *:*:*: :*:*:*     :*:     :*:*:   :*: :*:    :*:           "); 
		System.out.println("          *:* *:*:* *:*     *:*     :*:*:*  *:* *:*    *:*           "); 
		System.out.println("          *#*  *:*  *#*     *#*     *#* *:* *#* *#*    *:*           "); 
		System.out.println("          *#*       *#*     *#*     *#*  *#*#*# *#*    *#*           "); 
		System.out.println("          #*#       #*#     #*#     #*#   #*#*# #*#    #*#           "); 
		System.out.println("          ###       ### ########### ###    #### #########           ");
		System.out.println();

		sc = new Scanner(System.in);
		//		Scanner sc = new Scanner(System.in); since the scanner doesn't work for menu() exctract as fieldlike
		System.out.println("\n\n             press Enter to continue..");
		@SuppressWarnings("unused")
		String next = sc.nextLine(); //Just to get the Enter to continue the program
		//sc.close(); //FIXME closing the scanner here makes the whole program fail, but why?
		//String next = sc.next(); does not work!! but sc.nextLine(); gets the Enter =)
		//TODO close scanner
		//TODO clear console?

		System.out.println("Welcome to Mastermind" + "\n"); 
	}


	/**
	 * Generates the code the user has to guess.
	 */
	private static void generateCode() {
		//		generate 4 numbers and write them to codeArray
		for (int i = 0; i < codeArray.length; i++) {
			double random = Math.random() * 6 + 1;
			codeArray[i] = (int)random;
		}
	}


	private static void exit() {
		System.exit(1);
	}

	/**
	 * Calls up the functions to evaluate the user input 
	 * 
	 * Calls functions: berechneAnrRichtigeOhnePos berechneAnzRichtiePosition
	 */
	private static void evalUserInput() {
		findNumbCorrectWithoutPos(tipArray);
		findNumbCorrectPos(tipArray);

		/*// Old way of tip feedback to user
		System.out.println(
				"Number without correct position: " 
						+ findNumbCorrectWithoutPos(tipArray));
		System.out.println("Number with correct position: " 
				+ findNumbCorrectPos(tipArray));
		System.out.println(
				"Thanks for tip" + zaehler + ". " + "You have  " 
						+ (versuche - zaehler) + " tries left.");
		 */


	}

	/**
	 * @param debugMode
	 * 
	 * Shows or hides code in game.
	 * Used for cheating, testing or debugging.
	 */
	private static void debugger() {
		System.out.println("Code: " + arrayToString(codeArray));
		System.out.println("Tip: " + arrayToString(tipArray));
	}

	/**
	 * Evaluates if user has found out the code.
	 * 
	 * If so jumps to endGame().
	 * 
	 * @return
	 */
	private static void tipEqualCode() {
		boolean areEqual = Arrays.equals(codeArray, tipArray);
		if (areEqual == true) {
			endGame();
		}
	}

	/**
	 * Terminates game.
	 * 
	 */
	private static void endGame() {
		System.out.println("\n"+"Well done, you truly are a Mastermind!!" + " Game over.");
		exit();
	}

	/***
	 * finds the number of existing numbers without position in code and counts them
	 * 
	 * @param tip
	 * @return int number of correct numbers guessed
	 * 
	 * The way it works is it copies the code, then checks for matches
	 * between tip and copy.
	 */
	public static int findNumbCorrectWithoutPos(int[] tip) {
		// DONE FIX output not correct - add overwrite when matching with -1!
		// DONE exit when match
		// DONE overwrite means copy of code is needed! can't overwrite code!!!
		// this is the copy job!
		copyCode = new int[4];
		for (int i = 0; i < codeArray.length; i++) {
			copyCode[i] = codeArray[i];
		}

		numbCorrectWithoutPos = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tip[i] == copyCode[j]) {
					numbCorrectWithoutPos = numbCorrectWithoutPos + 1;
					copyCode[j]=-1;
					j = 4; // => exit when match
				}
				numbCorrectWithoutPos = numbCorrectWithoutPos + 0;
			}
		}
		return numbCorrectWithoutPos;
	}

	/**
	 * finds the number of existing numbers with position in code and counts them
	 * 
	 * @param tip
	 * @return int number of correct numbers on correct position guessed
	 */
	public static int findNumbCorrectPos(int[] tip) {
		numbCorretPos = 0;
		for (int i = 0; i < 4; i++) {
			if (tip[i] == codeArray[i]) {
				numbCorretPos = numbCorretPos + 1;
			}
		}
		return numbCorretPos;
	}

	/**
	 * Converts any int[] array to a single String
	 * 
	 * @param array
	 * @return
	 */
	static String arrayToString(int[] array) {
		String arrayToString = "";
		for (int i = 0; i < array.length; i++) {
			arrayToString = arrayToString + Integer.toString(array[i]);
		}
		return arrayToString;
	}

	/**
	 * Ask User for his guess and gets the userInput and stores it in tipArray
	 * @param tipArray
	 */
	public static void tipUser() throws Exception{
		//DONE implement try, catch Exception handler
		//DONE Solve question, if it is possible to get each int separate from
		// a int like 1980 => 1, 9, 8, 0 ???
		// ANSWER: => YES, see class ScannerIntToSingleInt.java

		//DONE Allow userInput as one number not 4 x 1 digit and 4xEnter
		//DONE Tip can be given in one number but the whole game doesn't work anymore,
		// -> changed static tipArray to public static tipArray 
		// rework game to work with new tip as whole number given!!

		tipUser = -1;

		do {
			System.out.println(
					"Enter 4 numbers between 1-6, followed by Enter. " +
					"Example: 2222->Enter");

			Scanner reader = new Scanner(System.in);
			try {
				tipUser = reader.nextInt();

				//XXX tried those two throws on different positions, obviously this isn't the right way
				// but it works, only the message will not be displayed but it triggers and get catched
				// and handled as intended.
				if (6666 < tipUser) {
					throw new Exception("Guess is over 6666! Guess needs to be under 6667.");
				}
				if (0 < tipUser && tipUser < 1110) {
					throw new Exception("Guess is under 1111! Guess needs to be over 1110.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Guess invalid!");
				tipUser = -1; // restart tipUser() by setting tipUser below zero;
			} catch (Exception e) {
				System.out.println("Guess: " + tipUser + ", is invalid. "
						+ "needs to be between 1111-6666.");
				tipUser = -1; // restart tipUser() by setting tipUser below zero;
			}

			/*if (6666 < tipUser) { // THIS IS THE OLD way it worked also as if statement instead of exception
				System.out.println("Guess out of range.");				//XXX restart at the start of this do loop, solved whitout exception
				tipUser = -1; //idea leave the loop and restart if catched an exception
			}*/ // commented out and replaced with throw new InputMismatchException

		} while (tipUser < 0); //XXX rework the whole do while and try catch to work also within the limits
		// 6666 < tipUser > 1110!! at a later time
		//		System.out.println(tipUser); // just for testing!
		String tipToDigits = String.valueOf(tipUser);
		for(int i = 0; i < tipToDigits.length(); i++) {
			int j = Character.digit(tipToDigits.charAt(i), 10);
			//System.out.println("digit: " + j); // just for Testing if it works
			//TODO write each digit into new Array[][][] when working with NEW usertiparray

			tipArray[i] = j;

		}
		counter = counter + 1;
		//		reader.close(); //TODO closing the scanner here is a problem? but why?
	}


	private static void tipHistory() {
		//TODO tipHistory has to be saved
		//TODO tipHistory has to be displayed


		//TipHistory save mechanism
		tipHistory[counter-1][0] = tipUser;
		tipHistory[counter-1][1] = numbCorrectWithoutPos;
		tipHistory[counter-1][2] = numbCorretPos;


		//TipHistory display mechanism
		for (int i = 0; i < counter; i++) {
			System.out.println("Tip number " + (i + 1) + ": " + tipHistory[i][0] +
					". Correct numbers, incorrect position: "
					+ tipHistory[i][1] +
					". Correct numbers and position: "
					+ tipHistory[i][2] + "."
					);
		}
	}


	public static boolean isDebugMode() {
		return debugMode;
	}


	public static void setDebugMode(boolean debugMode) {
		Mastermind.debugMode = debugMode;
	}

	private static void Menu() {
		System.out.println("[1] Start game");
		System.out.println("[2] Game description");
		System.out.println("[3] Game options" + "\n");
		System.out.println("Enter a number, followed by Enter:");

		String s = sc.nextLine();

		int key = Integer.parseInt(s);
		//		int key = sc.nextInt(); // skips the break in the cases but why?

		switch (key) {
		case 1:
			//TODO insert game starting mechanic
			intro();
			break;
		case 2:
			//TODO insert game info
			spielInfo();
			BackToMenu();
			break;
		case 3:
			//TODO insert game options: debug/cheat toggle
			//TODO show debugMode Status -> isDebugMode()
			System.out.println("Debug Mode: " + isDebugMode());
			System.out.println("[1] Set Debug Mode: true");
			System.out.println("[2] Set Debug Mode: false" + "\n");
			System.out.println("Enter a number, followed by Enter:");

			String s1 = sc.nextLine();

			int key1 = Integer.parseInt(s1);

			switch (key1) {
			case 1:
				Mastermind.setDebugMode(true);
				//			setDebugMode = true;
				break;
			case 2:
				Mastermind.setDebugMode(false);
				//			setDebugMode = false;
				break;

			default:
				//FIXME catch if user doesn't choose a number!
				//			Menu();
				break;
			}

			//		BackToMenu(); // goto Menu() instead?
			Menu();
			break;
		default:
			BackToMenu();
			//FIXME catch if user doesn't choose a number!
			//TODO insert default is start game
			break;
		}
	}

	static void BackToMenu() {
		System.out.println("press Enter to continue..");
		String next = sc.nextLine();
		Menu();
	}

	private static void spielInfo() {
		System.out.println("\n" + 
				"The computer chooses four colors from six possible ones " + "\n"
				+ "(represented as numbers 1-6). The player tries to guess " + "\n"
				+ "this combination of numbers. The try is given as a four " + "\n"
				+ "digit number by the player. The programm compares the " + "\n"
				+ "try with the \"code\" and gives some feedback. If the " + "\n"
				+ "\"code\" has been found or there are no more tries left " + "\n"
				+ "the game ends." + "\n"
				+ tries + " is the number of tries given to break the code.");
	}

}