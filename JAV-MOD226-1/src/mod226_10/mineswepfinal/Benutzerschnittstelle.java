package mod226_10.mineswepfinal;

import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f5c705d4-0c98-4a61-9eb9-37830a10ffda")
public class Benutzerschnittstelle {
    @objid ("4dad3e03-a29f-42a4-b1ab-bad592759d49")
    private final Scanner scanner = new Scanner(System.in);

    @objid ("03379f85-3eca-4d51-9c08-bc53d8e9ecc4")
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

    @objid ("61c9a27c-1db8-41ba-864a-3f53242686d5")
    public String zeigeSpielfeld(Spielfeld spielfeld) {
    	/// XXX anzahlSpaltenInArray anzahlZeilenInArray angepasst auf -1, da Fehler verursacht
    	// dieses Problem beim zugriff auf zellenArray tritt auch andernort auf, evtl. dort direkt in loop
    	// geloest. vereinheitliche wenn moeglich.
        int anzahlSpaltenInArray = Spielfeld.spalten-1;
        int anzahlZeilenInArray = Spielfeld.zeilen-1;
        
        String zeichneSpielfeld = 
                "     0  1  2  3  4  5  6  7\n" +
                        zeichneZeilen(spielfeld, anzahlZeilenInArray, anzahlSpaltenInArray);
        
        System.out.println(zeichneSpielfeld);
        
        // XXX return Wert ist nur fuer JUnit test vorhanden...
        return zeichneSpielfeld;
    }

    @objid ("f66ae63e-5044-4f6c-b99d-ed491b725ede")
    private String zeichneZeilen(Spielfeld spielfeld, int zeilen, int spalten) {
        String zeile = "";
        for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
            zeile = zeile+"  "+i+"  ";
            for (int j = 0; j < Spielfeld.zellenArray[i].length; j++) {
                zeile += Spielfeld.zellenArray[i][j].zeichen+"  ";
            }
            zeile += "\n";
        }
        return zeile;
    }

    @objid ("5eec9d07-4b29-43ec-94da-b39402157aca")
    public String zeigeEingabeaufforderung() {
        String eingabeaufforderung =
                "Geben Sie ein Kommando ein:\n" + 
                        "T x y (z.B. T 2 3 testet Feld Zeile 2, Spalte 3 auf Mine)\n" +
                        "M x y (z.B. M 6 1 kehrt Markierung Feld Zeile 6, Spalte 1)\n";
        System.out.println(eingabeaufforderung);
        return eingabeaufforderung;
    }

    @objid ("08247a7e-b42c-4290-a173-77f1eb6455c0")
    public void zeigeFehlermeldung() {
        System.out.println("Eingabe Fehler!");
    }

    @objid ("1a607e4f-1c08-44ab-a1d8-d49c69da0640")
    public String zeigeSchlussmeldung() {
    	// So wie die Vorlage der Programmstruktur ist muss hier nun Unterschieden werden ob das Spiel
    	// gewonnen wurde oder die Bombe explodiert ist?
    	String schlussmeldung = "";
       	if (Spielfeld.schlussmeldungsNummer == 1) {
       		schlussmeldung = "Gewinner Text fehlt noch!";
    		}
    	
    	if (Spielfeld.schlussmeldungsNummer == 2) {
    		schlussmeldung = "Mine explodiert, Spiel beendet.";
		}
    	return schlussmeldung;
    }

}
