package mod226_10.delegationexample;

import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import mod226_09.Spielfeld;

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
	public void zeigeSpielfeld(Spielfeld spielfeld) {
	}

	@objid ("556193ae-6eed-49f6-86c6-2bedb466d651")
	public void zeigeEingabeaufforderung() {
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
