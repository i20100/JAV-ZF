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
	public static int[] codeArray = { 0, 0, 0, 0 }; //FIXME reactivate for live version! 
//	public static int[] codeArray = { 1, 1, 2, 4 }; // Just for testing!
	private static int[] copyCode; // needed for user evaluation
	public static int[] tipArray = { 0, 0, 0, 0 };
	static int versuche = 10;
	static int zaehler = 0;
	private static boolean debugMode = false;
	private static Scanner sc;

	/**
	 * Dies ist das Spiel Mastermind.
	 * <p>
	 * Spielbeschreibung: Computer wählt aus 6 möglichen Farben (Zahlen 1-6) 4
	 * aus. Der Spieler versucht diesen "Code" zu erraten. Dazu gibt er eine
	 * Kombination der 6 möglichen Zahlen ein. Das Programm vergleicht die
	 * Eingabe mit dem "Code" und wertet diese aus. Ist der "Code" geknackt oder
	 * die Anzahl Versuche aufgebraucht wird das Spiel beendet.
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
		// [1] Spiel starten
		// [2] Spiel Erklärung
		// [3] Spieloptionen -> todo add debugMode boolean <b> ** debugg on / off option ** </b> 
		//DONE change code visible according to debugMode state!
		//DONE berechneAnrRichtigeOhnePos not working as it should!
		//DONE remove syso("digit:...)
		//TODO give tip history before every tip (array(arraytipnr(tip,amp,aop))
		//TODO make tiphistory as table? https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
		//TODO make runnable exe
		//TODO close reader at end of main?
		//DONE make input possible as one number of 4 digits 
		//(shoulb be possible easy way with space, since java recognizes space as separator)
		//TODO commit git when last version of CLI only
		//TODO release game for friends
		//TODO make a GUI with colors to click and submit
		//TODO implement missing Game requirements from doc AB226A-01-1.docx:
		//TODO	Da auf der Konsole keinerlei grafische Ausgabe möglich ist, sollen die Farben durch einzelne Buchstaben dargestellt werden:
		//
		//			r	Rot
		//			b	Blau
		//			g	Grün
		//			y	Gelb
		//			w	Weiss
		//			s	Schwarz
		//
		//TODO			Die Eingabe des Spielers soll jeweils auf einer neuen Zeile eingelesen werden. Sie soll aus einer Folge von vier Buchstaben ohne Zwischenraum bestehen und wird mit der Return-Taste abgeschlossen.
		//
		//TODO			Das Programm soll die Benutzereingabe auf Korrektheit überprüfen (validieren) und im Falle einer fehlerhaften Eingabe eine entsprechende Meldung ausgeben und zur Wiederholung der Eingabe auffordern.
		//
		//TODO			Bei einer gültigen Eingabe soll auf einer neuen Zeile die Bewertung der Eingabe ausgegeben werden (Schritt 3 in obigem Ablauf).
		//
		//TODO			Die Ausgaben des Programms sollen so gestaltet werden, dass dem Benutzer jederzeit klar ist, was von ihm erwartet wird (Benutzerfreundlichkeit).

		intro(); // disable for faster debugging
		Menu();
		generateCode(); // whole Method has blockcomment

		do {
			tipUser();
			tipEqualCode();
			evalUserInput();
			if (debugMode == true) {
				debugger(); // debugMode state can be set in the Menu!
			}

		} while (versuche > zaehler);
		System.out.println(
				"Keine Versuche mehr übrig. " + "Sie haben den Code nicht geknackt."
						+ " " + "Das Spiel ist beendet...");
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

		sc = new Scanner(System.in);
//		Scanner sc = new Scanner(System.in); since the scanner doesn't work for menu() exctract as fieldlike
		System.out.println("\n\n             Drücke Enter um fortzufahren..");
		@SuppressWarnings("unused")
		String next = sc.nextLine(); //Just to get the Enter to continue the program
		//sc.close(); //FIXME closing the scanner here makes the whole program fail, but why?
		//String next = sc.next(); does not work!! but sc.nextLine(); gets the Enter =)
		//TODO close scanner
		//TODO clear console?

		System.out.println("Willkommen bei Mastermind" + "\n" + "\n" + 
				"Sie haben " + versuche+ " Versuche um den Code zu knacken." + "\n"
				+ "Der Code besteht aus den Zahlen 1-6. Der Code besteht aus " + "\n"
				+ "vier Stellen. Viel Erfolg!"
				+ "\n");
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
	 * Calls up the functions to evaluate the user input and displays the
	 * results.
	 * 
	 * Calls functions: berechneAnrRichtigeOhnePos berechneAnzRichtiePosition
	 */
	private static void evalUserInput() {
		System.out.println(
				"Anzahl richtige Zahlen ohne Betrachtung der Position: " 
						+ berechneAnrRichtigeOhnePos(tipArray));
		System.out.println("Anzahl mit richtiger Position: " 
				+ berechneAnzRichtiePosition(tipArray));
		System.out.println(
				"Danke für den " + zaehler + ". Tip. " + "Sie haben noch " 
						+ (versuche - zaehler) + " versuche übrig.");
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
		System.out.println("Glückwunsch Sie sind ein Mastermind!!" + " Spiel beendet.");
		exit();
	}

	/***
	 * Berechnet die Anzahl der erratenen Zahlen aus dem Geheimcode ohne die
	 * Position der Zahlen zu berücksichtigen
	 * 
	 * @param tip
	 * @return int Anzahl erratene/vorhandene Zahlen
	 * 
	 * The way it works is it copies the code, then checks for matches
	 * between tip and copy.
	 */
	public static int berechneAnrRichtigeOhnePos(int[] tip) {
		// DONE FIX output not correct - add overwrite when matching with -1!
		// DONE Exit bei Treffer, damit jede Zahl nur einmal gezählt wird.
		// DONE overwrite means copy of code is needed! can't overwrite code!!!
		// this is the copy job!
		copyCode = new int[4];
		for (int i = 0; i < codeArray.length; i++) {
			copyCode[i] = codeArray[i];
		}
		
		int anzRichtige = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tip[i] == copyCode[j]) {
					anzRichtige = anzRichtige + 1;
					copyCode[j]=-1;
					j = 4; // => Exit bei Treffer
				}
				anzRichtige = anzRichtige + 0;
			}
		}
		return anzRichtige;
	}

	/**
	 * Berechnet die Anzahl der erratenen Zahlen auf der richtigen Position
	 * 
	 * @param tip
	 * @return int Anzahl Zahlen Position richtig
	 */
	public static int berechneAnzRichtiePosition(int[] tip) {
		int anzRichtige = 0;
		for (int i = 0; i < 4; i++) {
			// System.out.println("test");
			if (tip[i] == codeArray[i]) {
				anzRichtige = anzRichtige + 1;
			}
			// anzRichtige = anzRichtige + 0;
		}
		return anzRichtige;
	}

	/**
	 * Converts any Int[] array to a single String
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
	 * Ask User for his guess and gets the Userinput.
	 * @param tipArray
	 */
	public static void tipUser() throws Exception{
		//DONE implement try, catch Exception handler
		//DONE Solve question, if it is possible to get each int separate from
		// a int like 1980 => 1, 9, 8, 0 ???
		// ANSWER: => YES, see class ScannerIntToSingleInt.java

		// DONE Zahleneingabe ohne Enter nach jeder Zahl ermöglichen
		//DONE Tip can be given in one number but the whole game doesn't work anymore,
		// -> changed static tipArray to public static tipArray 
		// rework game to work with new tip as whole number given!!

		int tipUser = -1;
		
		do {
			System.out.println(
					"Bitte geben Sie vier Zahlen zwischen 1-6 als " 
							+ "eine Zahl ein. Gefolgt von Enter. Bsp. 2222->Enter");

			Scanner reader = new Scanner(System.in);
			try {
				tipUser = reader.nextInt();

				//XXX tried those two throws on different positions, obviously this isn't the right way
				// but it works, only the message will not be displayed but it triggers and get catched
				// and handled as intended.
				if (6666 < tipUser) {
					throw new Exception("Tip ist über 6666! Bitte geben Sie einen Tip unter 6667 ein.");
				}
				if (0 < tipUser && tipUser < 1110) {
					throw new Exception("Tip ist unter 1111! Bitte geben Sie einen Tip über 1110 ein.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Eingabe für Tip ungültig!");
				tipUser = -1; // restart tipUser() by setting tipUser below zero;
			} catch (Exception e) {
				System.out.println("Eingabe für Tip: " + tipUser + ", diese Eingabe ist ungültig. "
						+ "Eingabe muss zwischen 1111-6666 liegen.");
				tipUser = -1; // restart tipUser() by setting tipUser below zero;
			}
			
			/*if (6666 < tipUser) { // THIS IS THE OLD way it worked also as if statement instead of exception
				System.out.println("Tip ist ausserhalb der erlaubten Zahlen.");				//XXX restart at the start of this do loop, solved whitout exception
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
		zaehler = zaehler + 1;
		//		reader.close(); //TODO closing the scanner here is a problem? but why?
	}


	public static boolean isDebugMode() {
		return debugMode;
	}


	public static void setDebugMode(boolean debugMode) {
		Mastermind.debugMode = debugMode;
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
		intro();
		break;
	case 2:
		//TODO insert game info
		System.out.println(spielInfo());
		BackToMenu();
		break;
	case 3:
		//TODO insert game options: debug/cheat toggle
		//TODO show debugMode Status -> isDebugMode()
		System.out.println("Im Debug Modus: " + isDebugMode());
		System.out.println("[1] Debug Modus: true");
		System.out.println("[2] Debug Modus: false");
		System.out.println("Wähle Zahl, bestätige mit Enter:");

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
	System.out.println("\n Drücke Enter um fortzufahren..");
	String next = sc.nextLine();
	Menu();
}

private static String spielInfo() {
	System.out.println("Dies ist das Spiel Mastermind.\r\n" + 
			"Spielbeschreibung: Computer wählt aus 6 möglichen Farben (Zahlen 1-6) 4\r\n" + 
			"aus. Der Spieler versucht diesen \"Code\" zu erraten. Dazu gibt er eine\r\n" + 
			"Kombination der 6 möglichen Zahlen ein. Das Programm vergleicht die\r\n" + 
			"Eingabe mit dem \"Code\" und wertet diese aus. Ist der \"Code\" geknackt oder\r\n" + 
			"die Anzahl Versuche aufgebraucht wird das Spiel beendet.\r\n\n"
			+ "Sie haben " + versuche + " Versuche um den Code zu knacken.");
	return null;
}

}