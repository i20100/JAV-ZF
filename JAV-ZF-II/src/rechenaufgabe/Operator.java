import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3799ecc0-a5ac-49ac-aa08-69275184c5dc")
public class Operator {
    @objid ("27f7df6d-02aa-4e40-9625-aee1ff38001b")
    public int operationAuswaehlen(int zahlOperator, int zahlA, int zahlB) {
        // TODO Hier sollte ein Operator gewaehlt werden, erster Test addition
        // TODO benutze eine Switch Anweisung + Random Zahl dazu
        // TODO da diese Funktion immer Funktionieren sollte, am besten
        // alle drei Zahlen uebergeben als Parameter
        // Parameter 1: zahlOperator
        // Parameter 2: zahlA, Parameter 3: zahlB
        
        // Addition
        int resultat = zahlA + zahlB;
        
        
        //Returnwert? Die ganze Rechnung als String zurueckgeben?
        return resultat;
    }

    @objid ("6caf9bf3-b497-4a6c-8586-a5a4b3ac716a")
    public void zeigeOperatorAlsZeichen(int zahlOperator) {
    	// TODO Switch 1-5 return char +,-,...
    	
    	
    }

}
