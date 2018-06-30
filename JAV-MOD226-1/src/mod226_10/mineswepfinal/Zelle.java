package mod226_10.mineswepfinal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("33727d3b-06ba-42bd-9787-1c071adb7350")
public class Zelle {
	@objid ("9d1fba41-d4bd-42ae-85fe-bd2e9a19eb5e")
	public int xKoordinate;

	@objid ("6760e3fc-cb3f-412e-80d1-d39bb75a85b2")
	public int yKoordinate;

	@objid ("051c7e36-a810-4c17-959c-1b7ac18b54d8")
	public String zustand = "verdeckt";

	@objid ("878845f6-60ca-4f59-9686-adb8435a75db")
	public boolean bombe = false;

	public String zeichen = " ";

	public int bombenInNachbarschaft = 0;

	public Zelle(int i, int j) {
		xKoordinate = j;
		yKoordinate = i;
	}

	@objid ("41c8f7f1-e7be-4051-8495-a2b52bd9d0c3")
	public void aufdecken() {
	}

	@objid ("7399c172-ea5c-431c-a912-76609ebaedd3")
	public void markieren() {
	}

	public void setzeBombe() {
		this.bombe = true;
	}
	
	public Zelle zelleLinks() {
		Zelle zelle = Spielfeld.zellenArray[this.yKoordinate][this.xKoordinate-1];
		return zelle;
	}
	
	public Zelle zelleRechts() {
		Zelle zelle = Spielfeld.zellenArray[this.yKoordinate][this.xKoordinate+1];
		return zelle;
	}

	public Zelle zelleObenLinks() {
		Zelle zelle = Spielfeld.zellenArray[this.yKoordinate-1][this.xKoordinate-1];
		return zelle;
	}
	
	public Zelle zelleObenRechts() {
		Zelle zelle = Spielfeld.zellenArray[this.yKoordinate-1][this.xKoordinate+1];
		return zelle;
	}
	
	public Zelle zelleUntenLinks() {
		Zelle zelle = Spielfeld.zellenArray[this.yKoordinate+1][this.xKoordinate-1];
		return zelle;
	}
	
	public Zelle zelleUntenRechts() {
		Zelle zelle = Spielfeld.zellenArray[this.yKoordinate+1][this.xKoordinate+1];
		return zelle;
	}
	
	public Zelle zelleOben() {
		Zelle zelle = Spielfeld.zellenArray[this.yKoordinate-1][this.xKoordinate];
		return zelle;
	}
	
	public Zelle zelleUnten() {
		Zelle zelle = Spielfeld.zellenArray[this.yKoordinate+1][this.xKoordinate];
		return zelle;
	}
	
}
