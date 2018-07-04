package mod226_10.delegationexample;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import mod226_10.mineswepfinal.Spielfeld;

//import mod226_10.mineswepfinal.Spielfeld;
@objid ("9bf86ab1-668a-4c0c-974c-ff4639a7d2cb")
public class Kommando {
    @objid ("f1af64c3-b11c-4c0f-9c53-318a883b2dae")
    private int zeile;

    @objid ("b9131997-1c3e-4ca2-9e49-fdbacc508608")
    private int spalte;

    @objid ("fdb2e63c-7616-4c18-947e-b6397b6bc1f4")
    private String kommadoZeichen;

    @objid ("c89d476b-784f-4000-af6e-358dacf710db")
    public Kommando(String kommandoZeichen, int zeile, int spalte) {
        this.kommadoZeichen = kommandoZeichen;
        this.zeile = zeile;
        this.spalte = spalte;
    }

    @objid ("50c2cca1-9159-406b-b1f4-ec62a638d698")
    public void ausfuehren(Spielfeld spielfeld) {
        switch (kommadoZeichen) {
        case "M":
            spielfeld.markieren(spalte, zeile);
        case "T":
            spielfeld.aufdecken(spalte, zeile);
        }
    }

}
