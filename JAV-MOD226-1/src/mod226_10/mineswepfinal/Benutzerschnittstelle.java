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
        int spalten = Spielfeld.spalten;
        int zeilen = Spielfeld.zeilen;
        
        String zeichneSpielfeld = 
                "     0  1  2  3  4  5  6  7\n" +
                        zeichneZeilen(spielfeld, zeilen, spalten);
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
        return eingabeaufforderung;
    }

    @objid ("08247a7e-b42c-4290-a173-77f1eb6455c0")
    public void zeigeFehlermeldung() {
        System.out.println("Eingabe Fehler!");
    }

    @objid ("1a607e4f-1c08-44ab-a1d8-d49c69da0640")
    public void zeigeSchlussmeldung() {
        System.out.println("Schlussmeldung!");
    }

}
