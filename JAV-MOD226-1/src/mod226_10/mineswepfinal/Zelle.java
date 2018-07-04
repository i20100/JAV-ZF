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

    @objid ("5ff36a94-a2d9-4536-8f5c-1befde06ead1")
    public boolean bombe = false;

    @objid ("b7ab442a-4600-4b53-9c68-b99e5a3da2db")
    public String zeichen = " ";

    @objid ("49770a48-f1b4-42d4-8470-6c3933f657c2")
    public int bombenInNachbarschaft = 0;

    @objid ("d3be3fb2-1ff0-4316-9664-523fddc6107c")
    public PositionImSpielfeld positionImSpielfeld = PositionImSpielfeld.UNDEFINIERT;

    @objid ("e408dd48-296e-4bed-9065-3535afb7986f")
    public boolean nullenBehandeltFlag = false;

    @objid ("41c8f7f1-e7be-4051-8495-a2b52bd9d0c3")
    public void aufdecken() {
    }

    @objid ("7399c172-ea5c-431c-a912-76609ebaedd3")
    public void markieren() {
    }

    @objid ("9b57d52b-ea08-4097-aba4-2f3511681e13")
    public Zelle(int i, int j) {
        xKoordinate = j;
        yKoordinate = i;
    }

    @objid ("f6153892-a3a8-4ac8-9fb2-e364c887a123")
    public void setzeBombe() {
        this.bombe = true;
    }

    @objid ("a90c9b43-1976-4d71-a866-d7944178452e")
    public Zelle zelleLinks() {
        Zelle zelle = Spielfeld.zellenArray[this.yKoordinate][this.xKoordinate-1];
        return zelle;
    }

    @objid ("f18a85a0-1e2a-4322-8059-e70c66011a2d")
    public Zelle zelleRechts() {
        Zelle zelle = Spielfeld.zellenArray[this.yKoordinate][this.xKoordinate+1];
        return zelle;
    }

    @objid ("518306af-6e6b-44e5-972f-11d81be5586b")
    public Zelle zelleObenLinks() {
        Zelle zelle = Spielfeld.zellenArray[this.yKoordinate-1][this.xKoordinate-1];
        return zelle;
    }

    @objid ("93774405-0f2b-4080-8770-ecd0babe1d03")
    public Zelle zelleObenRechts() {
        Zelle zelle = Spielfeld.zellenArray[this.yKoordinate-1][this.xKoordinate+1];
        return zelle;
    }

    @objid ("b3ebc28a-fd47-44c2-8f83-c0792c06f04e")
    public Zelle zelleUntenLinks() {
        Zelle zelle = Spielfeld.zellenArray[this.yKoordinate+1][this.xKoordinate-1];
        return zelle;
    }

    @objid ("20df1ee7-91b7-49c2-bb61-563503112016")
    public Zelle zelleUntenRechts() {
        Zelle zelle = Spielfeld.zellenArray[this.yKoordinate+1][this.xKoordinate+1];
        return zelle;
    }

    @objid ("efdf9894-c761-4fb1-8710-d05ae52f716d")
    public Zelle zelleOben() {
        Zelle zelle = Spielfeld.zellenArray[this.yKoordinate-1][this.xKoordinate];
        return zelle;
    }

    @objid ("ceed110c-70e6-4544-8539-14ce94a4ddb8")
    public Zelle zelleUnten() {
        Zelle zelle = Spielfeld.zellenArray[this.yKoordinate+1][this.xKoordinate];
        return zelle;
    }

}
