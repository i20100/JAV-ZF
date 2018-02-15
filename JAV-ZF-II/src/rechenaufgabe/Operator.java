package rechenaufgabe;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3799ecc0-a5ac-49ac-aa08-69275184c5dc")
public class Operator {
    @objid ("27f7df6d-02aa-4e40-9625-aee1ff38001b")
    public int operationAuswaehlen(int zahlOperator, int zahlA, int zahlB) {
        // Parameter 1: zahlOperator
        // Parameter 2: zahlA, Parameter 3: zahlB
        
        int resultat = 0;
        
        switch (zahlOperator) {
        case 1:
			resultat = zahlA + zahlB;
			break;
        case 2:
			resultat = zahlA - zahlB;
			break;
        case 3:
			resultat = zahlA * zahlB;
			break;
        case 4:
			resultat = zahlA / zahlB;
			break;
        case 5:
			resultat = zahlA % zahlB;
			break;

		default:
			resultat = 0;
			break;
		}
        
        return resultat;
    }

    @objid ("6caf9bf3-b497-4a6c-8586-a5a4b3ac716a")
    public char zeigeOperatorAlsZeichen(int zahlOperator) {
    	char operation;
    	// Switch 1-5 return char +,-,etc.
    	switch (zahlOperator) {
		case 1:
			operation =  '+';
			break;
		case 2:
			operation =  '-';
			break;
		case 3:
			operation =  '*';
			break;
		case 4:
			operation =  '/';
			break;
		case 5:
			operation =  '%';
			break;

		default:
			operation =  '?';
			break;
		}
    	
    	return operation;
    	
    }

}
