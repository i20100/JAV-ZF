package mod226_10.delegationexample;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("242b4d63-88eb-4129-be95-e8957b6176e8")
public class Validator {
    @objid ("31b6f6ce-89fc-45f2-b5b9-69e06f5aeb73")
    private String[] eingabeTeile;

    @objid ("f52b5604-d763-4154-bb90-0b37a958a597")
    private boolean istGueltig = true;

    @objid ("b62573fb-97d2-4699-ab8e-cc38c629174e")
    public Validator(String eingabe) {
        eingabeTeile = eingabe.split(" ");
        if (eingabeTeile.length != 3)
            istGueltig = false;
        if (!eingabeTeile[0].equals("T") && !eingabeTeile[0].equals("M"))
            istGueltig = false;
        try {
            Integer.valueOf(eingabeTeile[1]);
            Integer.valueOf(eingabeTeile[2]);
        } catch (NumberFormatException e) {
            istGueltig = false;
        }
    }

    @objid ("146a6cc5-984c-4700-8774-694a34186dad")
    public boolean istGueltig() {
        return istGueltig;
    }

    @objid ("f216a242-84cf-41b3-9a6d-48f766fab2d3")
    public Kommando erzeugeKommando() {
        String kommandoZeichen = eingabeTeile[0];
        int zeile = Integer.valueOf(eingabeTeile[1]);
        int spalte = Integer.valueOf(eingabeTeile[2]);
        return new Kommando(kommandoZeichen, zeile, spalte);
    }

}
