package mod226_10.mineswepfinal;

import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/** 
 * @author Vincent
 * Ort für alle Ein- und Ausgabeaktionen mit dem Benutzer, anstatt in der Minesweeper Klasse. 
 * Zudem besteht neu die Methode zeigeSpielfeld mit Parameter, womit dieser von anderer Klasse aufgerufen werden kann.
 */
@objid ("9033bcf9-52de-4b99-920a-c11ceb195c60")
public class Benutzerschnittstelle {
	private final Scanner scanner = new Scanner(System.in);

	public Kommando liesEingabe() {
		do {
			String eingabe = scanner.nextLine();
			Validator validator = new Validator(eingabe);
			if (validator.istGueltig())
				return validator.erzeugeKommando();
			else
				zeigeFehlermeldung();
		} while (true);
	}

	@objid ("be2af921-7d73-417e-bd72-37350101a56f")
	public String zeigeSpielfeld(Spielfeld spielfeld) {
		int spalten = spielfeld.spalten;
		int zeilen = spielfeld.zeilen;

		String zeichneSpielfeld = 
				"     0  1  2  3  4  5  6  7\n" +
		zeichneZeilen(spielfeld, zeilen);
		return zeichneSpielfeld;
	}

	private String zeichneZeilen(Spielfeld spielfeld, int zeilen) {
		String zeichneZeilen = "";
		for (int i = 0; i < zeilen; i++) {
			zeichneZeilen = zeichneZeilen+"  "+i+"  "+zeicheneZeile(spielfeld, i)+"\n";
		}
		return zeichneZeilen;
	}

	private String zeicheneZeile(Spielfeld spielfeld, int zeilenNummer) {
		String zeile = "";
		for (int i = 0; i < 8; i++) {
			zeile = zeile+spielfeld.zellenArray[i+(zeilenNummer*8)].zeichen+"  ";
		}
		return zeile;
	}

	@objid ("556193ae-6eed-49f6-86c6-2bedb466d651")
	public String zeigeEingabeaufforderung() {
		String eingabeaufforderung =
				"Geben Sie ein Kommando ein:\n" + 
						"T x y (z.B. T 2 3 testet Feld Zeile 2, Spalte 3 auf Mine)\n" +
						"M x y (z.B. M 6 1 kehrt Markierung Feld Zeile 6, Spalte 1)\n";
		return eingabeaufforderung;

	}

	@objid ("8b5124c7-0ecd-4682-a3ef-725c5ed63eb7")
	public void zeigeFehlermeldung() {
		System.out.println("Eingabe Fehler!");
	}

	@objid ("2bc13a81-07ad-4c48-bb52-e34a82e98a57")
	public void zeigeSchlussmeldung() {
		System.out.println("Schlussmeldung!");
	}

}
