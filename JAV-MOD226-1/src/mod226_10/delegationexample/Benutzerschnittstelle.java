package mod226_10.delegationexample;

import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import mod226_10.mineswepfinal.Spielfeld;

@objid ("9033bcf9-52de-4b99-920a-c11ceb195c60")
public class Benutzerschnittstelle {
    @objid ("d79774d1-f253-4036-8982-68ab20ba690d")
    private final Scanner scanner = new Scanner(System.in);

    @objid ("5d43f3c7-6b96-4ea9-b6fd-fddd7432c609")
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
    public void zeigeSchlussmeldung(Spielfeld spielfeld) {
    	System.out.println("zeigeSchlussmeldung");
    }

}
