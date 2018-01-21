package mod226_07_aufg1_code_to_uml;

import java.util.ArrayList;

public class Kunde {
	private String name;
	private Adresse adresse;
	private ArrayList<Konto> kontos = new ArrayList<Konto>();

	public Kunde(String name, Adresse adresse) {
		this.name = name;
		this.adresse = adresse;
	}

	public void addKonto(Konto konto) {
		kontos.add(konto);
	}

	public String toString() {
		return name + ", " + adresse.toString();
	}
}
