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
	//	public static int[] codeArray = { 0, 0, 0, 0 }; //FIXME reactivate for live version! 
	public static int[] codeArray = { 1, 1, 2, 4 }; // Just for testing!
	public static int[] tipArray = { 0, 0, 0, 0 };
	static int versuche = 10;
	static int zaehler = 0;

	/**
	 * Dies ist das Spiel Mastermind.
	 * <p>
	 * Spielbeschreibung: Computer wählt aus 6 möglichen Farben (Zahlen 1-6) 4
	 * aus. Der Spieler versucht diesen "Code" zu erraten. Dazu gibt er eine
	 * Kombination der 6 möglichen Zahlen ein. Das Programm vergleicht die
	 * Eingabe mit dem "Code" und wertet diese aus. Ist der "Code" geknackt oder
	 * die Anzahl versuche aufgebraucht wird das Spiel beendet.
	 * <p>
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		//TODO handle InputMismatchExeption with try {} catch (){}!
		//TODO re-implement generate code!
		//TODO beautiful menu from menu.jpage implement the like into mastermind?
		// [1] Spiel starten
		// [2] Spieloptionen -> todo add <b> ** debugg on / off option ** </b> 
		//TODO Revert to last commit? new class GenerateCode not usable, stick with code in file for now!
		//TODO make runnable exe
		//TODO give tip history before every tip (array(arraytipnr(tip,amp,aop))
		//TODO make tiphistory as table? https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
		//TODO make input possible as one number of 4 digits 
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


		//		 generateCode(codeArray); // whole Method has blockcomment
		// GenerateCode();

		// GenerateCode genCode = new GenerateCode();
		// genCode.genCode(codeArray);

		/*
		 * Horse p0 = new Horse(); Horse p1 = new Horse(); p1.move();
		 */

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

		//		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n             Drücke Enter um fortzufahren..");
		//		@SuppressWarnings("unused")
		//		String next = sc.nextLine(); //Just to get the Enter to continue the program
		//		sc.close(); //FIXME closing the scanner here makes the whole program fail, but why?
		//		String next = sc.next(); does not work!! but sc.nextLine(); gets the Enter =)
		//DONE close scanner
		//TODO clear console, this is a hard one

		System.out.println("Willkommen bei Mastermind" + "\n" + "\n" + 
				"Sie haben " + versuche+ " Versuche um den Code zu knacken." + "\n"
				+ "Der Code besteht aus den Zahlen 1-6. Der Code besteht aus " + "\n"
				+ "vier Stellen. Viel Erfolg!"
				+ "\n");

		do {
			tipUser();
			tipEqualCode();
			evalUserInput();
			debugger(); // Uncomment this line for exit debug mode aka hide code

		} while (versuche > zaehler);
		System.out.println(
				"Keine Versuche mehr übrig. " + "Sie haben den Code nicht geknackt."
						+ " " + "Das Spiel ist beendet...");
		exit();
	}


	/*
	 * private static void generateCode(int[] codeArray2) { /** Generates the
	 * "Code" (Geheimcode) which the User has to guess.
	 * 
	 * @param codeArray2
	 */ /*
	 * // generate 4 numbers and write them to codeArray for (int i = 0; i <
	 * codeArray.length; i++) { double random = Math.random() * 6 + 1;
	 * codeArray[i] = (int)random; } }
	 */

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
	 * Use this for cheating, testing or debugging
	 * 
	 * Uncomment the two lines below to see the code and user input as Strings
	 * 
	 */
	private static void debugger() {
		System.out.println(arrayToString(codeArray));
		System.out.println(arrayToString(tipArray));
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
	 */
	public static int berechneAnrRichtigeOhnePos(int[] tip) {
		// *Exit bei Treffer, damit jede Zahl nur einmal gezählt wird.
		int anzRichtige = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tip[i] == codeArray[j]) {
					anzRichtige = anzRichtige + 1;
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
	public static void tipUser() {
		//DONE implement try, catch Exception handler
		//DONE Solve question, if it is possible to get each int separate from
		// a int like 1980 => 1, 9, 8, 0 ???
		// ANSWER: => YES, see class ScannerIntToSingleInt.java

		// DONE Zahleneingabe ohne Enter nach jeder Zahl ermöglichen
		//DONE Tip can be given in one number but the whole game doesn't work anymore,
		// -> changed static tipArray to public static tipArray 
		// rework game to work with new tip as whole number given!!
		//TODO close reader

		int tipUser = -1;

		do {
			System.out.println(
					"Bitte geben Sie vier Zahlen zwischen 1-6 nach " 
							+ "einander ein gefolgt von Enter. Bsp. XXXX->Enter");

			Scanner reader = new Scanner(System.in);
			try {
				tipUser = reader.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("Eingabe für Tip ungültig!");
			}
			
			if (6666 < tipUser) {
				System.out.println("Tip ist ausserhalb der erlaubten Zahlen.");
				//FIXME restart at the start of this do loop
			}
			
			
		} while (tipUser < 0);
		//		System.out.println(tipUser); // just for testing!
		String tipToDigits = String.valueOf(tipUser);
		for(int i = 0; i < tipToDigits.length(); i++) {
			int j = Character.digit(tipToDigits.charAt(i), 10);
			System.out.println("digit: " + j);
			//TODO write each digit into new Array[][][] when working with new usertiparray

			tipArray[i] = j;

		}
		zaehler = zaehler + 1;
		//		reader.close(); //TODO closing the scanner here is a problem? but why?
	}
}