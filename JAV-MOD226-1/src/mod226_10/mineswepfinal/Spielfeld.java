package mod226_10.mineswepfinal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("6f95d20d-8cb0-4295-b3ee-87d1508129d8")
public class Spielfeld {
	@objid ("e19ea3e3-81a1-4e70-970a-1212868f2036")
	public int spalten = 8;

	@objid ("8e694de4-f0a9-40a7-9f5d-dedd78104eac")
	public int zeilen = 8;

	@objid ("080a90b4-179f-468a-b69c-c1700b831e79")
	public int bomben = 10;

	@objid ("66f7561a-c9d2-4609-890f-2c1ccbbfa7a2")
	public Zelle[] zellenArray = new Zelle[(spalten*zeilen)];

	@objid ("c34c7b64-7e01-4c60-8aaa-f7843ceaddba")
	public void initialisiereZellenInArray() {
		for (int i = 0; i < zellenArray.length; i++) {
			zellenArray[i] = new Zelle();
		}
	}
	
	public void markieren(int zeile, int spalte) {
		int i = spalte + (zeile * 8);
		this.zellenArray[i].zeichen = "!";
	}

	public void aufdecken(int spalte, int zeile) {
		int i = spalte + (zeile * 8);
		if (zellenArray[i].bombe = true) {
			this.zellenArray[i].zeichen = "*";
			//TODO switch to spielEnde();
		}

	}

}
