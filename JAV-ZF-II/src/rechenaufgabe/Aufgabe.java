import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c73b7522-c470-4da2-a0ce-ce20e79a3519")
public class Aufgabe {
    @objid ("5fd7eafb-16d4-4cb5-b04a-024e3d3c8a82")
    public static int zuloesendeAufgaben = 5;

    @objid ("3395fef0-cd49-490d-a34c-af4430657943")
    public int geloesteAufgaben;

    @objid ("c4cdb250-b51d-40d8-920a-80e3e0158f09")
    public int zahlA;

    @objid ("91832bc9-1dda-4555-a3a0-7f862f3a200f")
    public int zahlB;

    @objid ("640d9aab-256e-4fcb-a930-4d063be2b2f3")
    public int zahlOperator;

    @objid ("994f232a-b4b9-48c5-a7c9-5b0c6d7e838f")
    public List<ZufallsZahl> zufallsZahl;

    @objid ("e6ced48b-f4bc-43ab-940c-6a6da12b9010")
    public Operator operator;

    @objid ("91acbc43-a2d7-4c73-b8c0-e5995290b3be")
    public void zufallszahlenErstellen() {
        // rufe 2x ZufallsZahl auf und Speichere die Werte in Variablen
        ZufallsZahl objZahlA = new ZufallsZahl();
        zahlA = objZahlA.getZufallsZahl();
        ZufallsZahl objZahlB = new ZufallsZahl();
        zahlB = objZahlB.getZufallsZahl();
        ZufallsZahl objZahlOperator = new ZufallsZahl(5);
        zahlOperator = objZahlOperator.getZufallsZahl();
    }

}
