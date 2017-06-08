package publish;

import java.util.Arrays;
import java.util.Scanner;

public class Mastermind {
	/** Initial variables needed for the game  
	 * 
	 * codeArray = variable for saving the computer generated code
	 * tipArray = variable for saving the user input
	 * versuche = number of tries for the user to find the code
	 * zaehler = counter for tries of user to find the code
	 */
	static int[] codeArray = {0, 0, 0, 0};
	static int[] tipArray = {0, 0, 0, 0};
	static int versuche = 10;
	static int zaehler = 0;


	/** Dies ist das Spiel Masterminds.
	 * <p>
	 * Spielbeschreibung:
	 * Computer wählt aus 6 möglichen Farben (Zahlen 1-6) 4 aus. 
	 * Der Spieler versucht diesen "Code" zu erraten.
	 * Dazu gibt er eine Kombination der 6 möglichen Zahlen ein.
	 * Das Programm vergleicht die Eingabe mit dem "Code" und
	 * wertet diese aus. Ist der "Code" geknackt oder die Anzahl versuche
	 * aufgebraucht wird das Spiel beendet.
	 * <p>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO make it work as a runnable .jar!
		generateCode(codeArray);
		System.out.println("Willkommen bei Masterminds"+"\n"+"\n"
				+ "Sie haben "+ versuche + " Versuche um den Code zu knacken."+"\n"
				+ "Der Code besteht aus den Zahlen 1-6. Der Code besteht aus "+"\n"
				+ "vier Stellen. Viel Erfolg!"
				+ "\n");

		do {
			tipUser(tipArray);
			tipEqualCode();
			evalUserInput();
			debugger();

		} while (versuche > zaehler);
		System.out.println("Keine Versuche mehr übrig. "
				+ "Sie haben den Code nicht geknackt. "
				+ "Das Spiel ist beendet...");
		exit();
	}

	private static void exit() {
		System.exit(1);
		} 

	/** Calls up the functions to evaluate the user input and displays the results.
	 * 
	 *  Calls functions:
	 *  berechneAnrRichtigeOhnePos
	 *  berechneAnzRichtiePosition
	 */
	private static void evalUserInput() {
		System.out.println("Anzahl richtige Zahlen ohne Betrachtung der Position: "
				+ berechneAnrRichtigeOhnePos(tipArray));
		System.out.println("Anzahl mit richtiger Position: "
				+ berechneAnzRichtiePosition(tipArray));
		System.out.println("Danke für den " + zaehler + ". Tip. "
				+ "Sie haben noch " + (versuche-zaehler) + " versuche übrig.");		
	}

	/** Use this for cheating, testing or debugging
	 * 
	 * Uncomment the two lines below to see the code and user input as Strings
	 * 
	 */
	private static void debugger() {
		//			System.out.println(arrayToString(codeArray));
		//			System.out.println(arrayToString(tipArray));		
	}

	/** Evaluates if user has found out the code.
	 * 
	 * If so jumps to endGame().
	 * @return 
	 */
	private static  void tipEqualCode() {
		boolean areEqual = Arrays.equals(codeArray, tipArray);
		if (areEqual == true) {
			endGame();
		}
	}

	/** Terminates game.
	 * 
	 */
	private static void endGame() {
		System.out.println("Glückwunsch Sie sind ein Mastermind!!"
				+ " Spiel beendet.");
		exit();
	}

	/** Generates the "Code" (Geheimcode) which the User has to guess.
	 * @param codeArray2
	 */
	private static void generateCode(int[] codeArray2) {
		//		generate 4 numbers and write them to codeArray
		for (int i = 0; i < codeArray.length; i++) {
			double random = Math.random() * 6 + 1;
			codeArray[i] = (int)random;
		}		
	}

	/***
	 * Berechnet die Anzahl der erratenen Zahlen aus dem Geheimcode ohne die 
	 * Position der Zahlen zu berücksichtigen 
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
				} anzRichtige = anzRichtige + 0;
			}
		}
		return anzRichtige;
	}
	
	/**
	 * Berechnet die Anzahl der erratenen Zahlen auf der richtigen Position
	 * @param tip
	 * @return int Anzahl Zahlen Position richtig
	 */
	public static int berechneAnzRichtiePosition(int[] tip) {
		int anzRichtige = 0;
		for (int i = 0; i < 4; i++) {
			//			System.out.println("test");
			if (tip[i] == codeArray[i]) {
				anzRichtige = anzRichtige + 1;
			} 
			//			anzRichtige = anzRichtige + 0;
		}
		return anzRichtige;
	}

	/** Converts any Int[] array to a single String
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

	/** Ask User for his guess and gets the Userinput. 
	 * @param tipArray
	 */
	public static void tipUser(int[] tipArray) {
		System.out.println("Bitte geben Sie vier Zahlen zwischen 1-6 nach "
				+ "einander ein. Jede Zahl gefolgt von Enter.");
		// TODO Zahleneingabe ohne Enter nach jeder Zahl ermöglichen
		// TODO close reader
		Scanner reader = new Scanner(System.in);
		for (int i = 0; i < tipArray.length; i++) {
			tipArray[i] = reader.nextInt();
		}
		zaehler = zaehler + 1; 
	}

}