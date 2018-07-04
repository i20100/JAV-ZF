package mod226_10.mineswepfinal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("bf490681-3275-421c-9a85-1bef6c8ba79d")
public class Kommando {
    @objid ("17b108f0-3623-4587-9d44-4150fe42bf99")
    private String kommadoZeichen;

    @objid ("9c5b612f-8e6d-465a-a2b6-7aff6ae853e5")
    private int zeile;

    @objid ("1ed207ea-b214-41e6-9e60-7a56969aa9a1")
    private int spalte;

    @objid ("7a20b8f2-04bf-4a3a-92e0-b3df63ae38af")
    public Kommando(String kommandoZeichen, int zeile, int spalte) {
        this.kommadoZeichen = kommandoZeichen;
        this.zeile = zeile;
        this.spalte = spalte;
    }

    @objid ("6ffc63b4-4216-4894-8c51-1ca3263c6d1f")
    public void ausfuehren(Spielfeld spielfeld) {
        switch (kommadoZeichen) {
        case "M":
            spielfeld.markieren(zeile, spalte);
            break;
        case "T":
            spielfeld.aufdecken(zeile, spalte);
            break;
        default: 
            System.err.println("Switch malfunction");
        }
    }

}
