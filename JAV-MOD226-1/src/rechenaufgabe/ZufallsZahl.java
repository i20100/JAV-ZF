package rechenaufgabe;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3bdc7d5d-e699-46de-835c-98093bb1be11")
public class ZufallsZahl {
    @objid ("c7f1ac5e-b8df-415b-9ebc-df0206bf5bc7")
    private int zufallsZahl;

    @objid ("54933b67-532d-4c73-bb43-7871fc76ac6b")
    public ZufallsZahl(int maxInt) {
        zufallsZahl = (int)(Math.random()*maxInt+1);
    }

    @objid ("53a9a254-836d-4a3f-8a51-3a3bc3a69895")
    public ZufallsZahl() {
        zufallsZahl = (int)(Math.random()*99+1);
    }

    @objid ("2aaddb27-f759-486b-b642-735c988c809d")
    public void zufallsZahlenErstellen() {
    }

    @objid ("cf2a08ce-a7f1-40a7-87a1-dae6d5cf7ee5")
    int getZufallsZahl() {
        return this.zufallsZahl;
    }

}
