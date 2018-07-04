package mod226_09;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("80f3c185-7a16-4a0f-bcdf-bca5c0a9f41d")
public class Spielfeld {
    @objid ("4e0166f5-fcd1-4bf2-8146-1b05771aa9c0")
    public int laenge;

    @objid ("c7ae1f4b-63f1-411c-933b-d0268061d2d1")
    public int breite;

    @objid ("235eb840-da27-4180-9bc3-ad67feb6ef1f")
    public int bomben;

    @objid ("afc021e0-f529-4dcc-87d4-43008f1c82a0")
    public List<Zelle> zellen = new ArrayList<Zelle> ();

    @objid ("db7b89a3-ad84-4abd-91d7-e78ebda559f2")
    public void erstelleSpielfeld() {
    }

    @objid ("87968918-f6e2-4861-94d3-ae98a759bd6b")
    public void markieren(int spalte, int zeile) {
        // TODO Auto-generated method stub
    }

    @objid ("0d6abddb-35ac-4898-822d-096cef7bf5ae")
    public void aufdecken(int spalte, int zeile) {
        // TODO Auto-generated method stub
    }

}
