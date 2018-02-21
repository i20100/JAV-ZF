package mod226;

import mod226_06_bank.Konto;

public class L06_Aufg2_Speicherdiagramm {


	public static void main(String[] args) {
		// creates a variable kontos which points to an arry of Konto
		Konto[] kontos = new Konto[2];
		kontos[0] = new Konto();
	
		System.out.println(kontos[0].getSaldo());

	}
}

