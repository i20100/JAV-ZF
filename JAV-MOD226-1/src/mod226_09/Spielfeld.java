package mod226_09;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("6f95d20d-8cb0-4295-b3ee-87d1508129d8")
public class Spielfeld {
    @objid ("e19ea3e3-81a1-4e70-970a-1212868f2036")
    public int laenge;

    @objid ("8e694de4-f0a9-40a7-9f5d-dedd78104eac")
    public int breite;

    @objid ("080a90b4-179f-468a-b69c-c1700b831e79")
    public int bomben;

    @objid ("66f7561a-c9d2-4609-890f-2c1ccbbfa7a2")
    public List<Zelle> zellen = new ArrayList<Zelle> ();

    @objid ("c34c7b64-7e01-4c60-8aaa-f7843ceaddba")
    public void erstelleSpielfeld() {
    }

	public void markieren(int spalte, int zeile) {
		// TODO Auto-generated method stub
		
	}

	public void aufdecken(int spalte, int zeile) {
		// TODO Auto-generated method stub
		
	}

}
