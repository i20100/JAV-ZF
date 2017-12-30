package mod226_07_aufg1_code_to_uml;

import java.awt.List;
import java.util.ArrayList;

public class Bank {
	private ArrayList<Kunde> kunden = new ArrayList<Kunde>();
	private ArrayList<Konto> kontos = new ArrayList<Konto>();
	
	public double summeKundenGelder() {
		int summe = 0;
		for (Konto konto : kontos)
			summe += konto.saldo();
		return summe;	
	}
	
	public String kundenVerzeichnis() {
		String verzeichnis = "";
		for (Kunde kunde : kunden)
			verzeichnis += kunde.toString() + '\n';
		return verzeichnis;
	}
	
	public void addKonto(Konto konto) {
		kontos.add(konto);
	}
	
	public void addKunde(Kunde kunde) {
		kunden.add(kunde);
	}
}