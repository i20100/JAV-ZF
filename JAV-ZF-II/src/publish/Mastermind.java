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
	 * user to find the code zaehler = usedTries for tries of user to find the
	 * code
	 */
	static int tries = 10;
	static int usedTries = 0;

	public static int[] codeArray = { 0, 0, 0, 0 };
	private static int[] codeCopy; // needed for user evaluation
	public static int[] tipArray = { 0, 0, 0, 0 };	
	private static int[][] tipHistory = new int[tries][3];

	private static boolean debugMode = false;
	private static Scanner sc;
	private static int userInput;
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
	 * The program compares the try with the "code" and gives some feedback.
	 * If the "code" has been found or there are no more tries left the game ends.
	 * <p>
	 * 
	 * @param args
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		//XXX  Apply Coding best practices: only one lvl of nesting (Verschachtelung) per Method
		//XXX  change do while of checkUserInput() to a simple if break?
		//DONE  sort Methods in order of appearance!
		//DONE Julio found another Bug, Game closes after 2 tries, tries set to 10 again
		//DONE fix game end - proper end with info before closing the console
		//XXX  fix game end - insert restart option and restart loop!
		//DONE add version number
		//DONE wrong guess endgame doesn't generate new code! check and fix!
		//Actualy the problem is with the usedTries which is not reset by a new game!
		//XXX handle InputMismatchExeption with try {} catch (){}!, could be nicer but works
		//XXX rewrite Game Info for the User, so it is eaysier to understand.
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
			checkUserInput();
			restartCodeNotFound();  // restart does generate new code, but usedTries needs to be reset!
			usedTries = 0; // reset of usedTries for a new game
		} while (gameRestartLoop  = true);
		// Add congrats to player before game ends?
		exit();
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
		System.out.println("          v.0.03");  //added Version number (version.major.patchnumber) 

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

	private static void Menu() {
		System.out.println("[1] Start");
		System.out.println("[2] Info");
		System.out.println("[3] Options" + "\n");
		System.out.println("Enter a number, followed by Enter:");

		String s = sc.nextLine();

		int key = Integer.parseInt(s);
		//		int key = sc.nextInt(); // skips the break in the cases but why?

		switch (key) {
		case 1:
			//DONE insert game starting mechanic, just break is enough!
			break;
		case 2:
			//TODO insert game info
			gameInfo();
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

	public static boolean isDebugMode() {
		return debugMode;
	}

	public static void setDebugMode(boolean debugMode) {
		Mastermind.debugMode = debugMode;
	}

	private static void gameInfo() {
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

	static void BackToMenu() {
		System.out.println("press Enter to continue..");
		String next = sc.nextLine();
		Menu();
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

	/** Contains all Methods used for handling the user input
	 * @throws Exception
	 */
	private static void checkUserInput() throws Exception {
		do {
			aksForUserInput();
			readUserInput();
			checkUserInputForErrors(); 
			convertUserInputToSingleDigits();
			incrementUsedTries();
			checkCodeFound(); // checks if Game was solved by Userinput
			evalUserInput();
			saveUserInputHistory();
			printUserInputHistory();
			if (debugMode == true) {
				printCodeAndUserInput(); // debugMode state, shows solution, can be set in the Menu!
			}

		} while (tries > usedTries);
	}

	/**
	 * Displays the Text to the user to Enter his Guess
	 */
	private static void aksForUserInput() {
		System.out.println(
				"Enter 4 numbers between 1-6, followed by Enter. " +
				"Example: 3456 -> Enter");
	}

	/**
	 * Reads userInput akak fill userInput with next int
	 * and checks for errors
	 * @param tipArray
	 */
	public static void readUserInput() throws Exception{

		userInput = -1;
		Scanner reader = new Scanner(System.in);
		userInput = reader.nextInt();
		//		reader.close(); //TODO closing the scanner here is a problem? but why?

	}

	/**
	 * Check User Input via Exception
	 */
	private static void checkUserInputForErrors() {
		do {
			try {
				//XXX 1011 and 6667 gets catched, but 1667 not, this would need
				// a new check system which checks each digit not the whole number!
	
				if (6666 < userInput) {
					throw new Exception("Guess is over 6666! Guess needs to be under 6667.");
				}
				if (0 < userInput && userInput < 1110) {
					throw new Exception("Guess is under 1111! Guess needs to be over 1110.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Guess invalid!");
				userInput = -1; // restart userInput() by setting userInput below zero;
			} catch (Exception e) {/*XXX why use the class Exception and not the expected exceptions?
				*This is not good code! Worse would be the general Exception first, then InputMiss.. 
				*would never be considered */
				System.out.println("Guess: " + userInput + ", is invalid. "
						+ "needs to be between 1111-6666.");
				userInput = -1; // restart userInput() by setting userInput below zero;
			}
		} while (userInput < 0);
	}

	/**
	 * Add +1 for each Valid UserInput to keep track of used tries
	 */
	private static void incrementUsedTries() {
		usedTries = usedTries + 1;
	}

	/** 
	 * Convert userInput into single Digits, stores it in tipArray
	 * @param tipArray
	 */
	public static void convertUserInputToSingleDigits() {
		String tipToDigits = String.valueOf(userInput);
		for(int i = 0; i < tipToDigits.length(); i++) {
			int j = Character.digit(tipToDigits.charAt(i), 10);
			//System.out.println("digit: " + j); // just for Testing if it works
			//TODO write each digit into new Array[][][] when working with NEW usertiparray
			tipArray[i] = j;
		}
	}

	/**
	 * Evaluates if user has found out the code.
	 * 
	 * If so jumps to endGame().
	 * 
	 * @return
	 */
	private static void checkCodeFound() {
		boolean areEqual = Arrays.equals(codeArray, tipArray);
		if (areEqual == true) {
			endGame();
		}
	}

	/**
	 * Prints Endgame Message, then terminates game.
	 */
	private static void endGame() {
		System.out.println("\n"+"Well done, you truly are a Mastermind!!" + " Game over.");
		//DONE add user input to terminate the console, else text is not visible.
		System.out.println("\n\n"+"Press Enter.");
		@SuppressWarnings("unused")
		String next = sc.nextLine(); //Just to get the Enter to continue the program
		exit();
	}

	/**
	 * Calls up the functions to evaluate the user input 
	 */
	private static void evalUserInput() {
		copyCodeToArrayCodeCopy();
		findNumbCorrectWithoutPos(tipArray);
		findNumbCorrectPos(tipArray);
	}

	/**
	 * Copy the "Code" into the Array codeCopy task for findNumbCorrectWithoutPos
	 */
	private static void copyCodeToArrayCodeCopy() {
		codeCopy = new int[4];
		for (int i = 0; i < codeArray.length; i++) {
			codeCopy[i] = codeArray[i];
		}
	}

	/***
	 * finds the number of existing numbers without position in code and counts them
	 * 
	 * @param tip
	 * @return int number of correct numbers guessed
	 * 
	 * The way it works:
	 * Comparing two arrays by for a nested for loop.
	 * for loop one = tip aka userInput
	 * for loop two = codeCopy
	 * so first 4 steps checks the first value of tip[] with all values of codecopy
	 * If there is a match, it will increment numbCorrectWithoutPos and 
	 * CHANGE THE CODECOPY value so it wont recount a same Tip Number with an
	 * already counted Code Number!!
	 */
	private static int findNumbCorrectWithoutPos(int[] tip) {
		// DONE FIX output not correct - add overwrite when matching with -1!
		// DONE exit when match
		// DONE overwrite means copy of code is needed! can't overwrite code!!!

		numbCorrectWithoutPos = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tip[i] == codeCopy[j]) {
					numbCorrectWithoutPos = numbCorrectWithoutPos + 1;
					codeCopy[j]=-1; //Change Code so number does not count twice!
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
	private static int findNumbCorrectPos(int[] tip) {
		numbCorretPos = 0;
		for (int i = 0; i < 4; i++) {
			if (tip[i] == codeArray[i]) {
				numbCorretPos = numbCorretPos + 1;
			}
		}
		return numbCorretPos;
	}

	private static void saveUserInputHistory() {
		tipHistory[usedTries-1][0] = userInput;
		tipHistory[usedTries-1][1] = numbCorrectWithoutPos;
		tipHistory[usedTries-1][2] = numbCorretPos;
	}

	private static void printUserInputHistory() {
		for (int i = 0; i < usedTries; i++) {
			System.out.println("Tip number " + (i + 1) + ": " + tipHistory[i][0] +
					". Amount of matching numbers: "
					+ tipHistory[i][1] +
					". Amount of correct positioned numbers: "
					+ tipHistory[i][2] + "."
					);
		}
	}

	/**
	 * @param debugMode
	 * 
	 * Shows or hides code in game.
	 * Used for cheating, testing or debugging.
	 * Can be activated via Menu()
	 */
	private static void printCodeAndUserInput() {
		System.out.println("Code: " + arrayToString(codeArray));
		System.out.println("Tip: " + arrayToString(tipArray));
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

	private static void restartCodeNotFound() {
		System.out.println("\n" +
				"No tries left. " + "Code not found." +
				"\n" + "Code was: "+ arrayToString(codeArray) + "." + 
				"\n" + "Game over." + "\n\n" + "Press Enter to start new game.");
		@SuppressWarnings("unused")
		String next = sc.nextLine(); // Get the Enter to continue the program
	}

	private static void exit() {
		System.exit(1);
	}
}