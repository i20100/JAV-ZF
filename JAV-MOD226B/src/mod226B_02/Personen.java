package mod226B_02;

class Firma {
	private Person[] mitarbeiter;

	public Firma (Person[] p) {
		setMitarbeiter(p);
	}

	/**
	 * @return the mitarbeiter
	 */
	public Person[] getMitarbeiter() {
		return mitarbeiter;
	}

	/**
	 * @param mitarbeiter the mitarbeiter to set
	 */
	public void setMitarbeiter(Person[] mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
}

class Person {
	protected String name;
	protected String vorname;
	protected int personalNummer;

	public Person(String name, String vorname, int personalNummer) {
		this.name = name;
		this.vorname = vorname;
		this.personalNummer = personalNummer;
	}

}

class Chef extends Person {
	private String abteilung;

	public Chef(String name, String vorname, int personalNummer, String abteilung) {
		super(name, vorname, personalNummer);
		this.setAbteilung(abteilung);
	}

	/**
	 * @return the abteilung
	 */
	public String getAbteilung() {
		return abteilung;
	}

	/**
	 * @param abteilung the abteilung to set
	 */
	public void setAbteilung(String abteilung) {
		this.abteilung = abteilung;
	}
}

class Fachangestellter extends Person {
	private Chef vorgesetzter;

	public Fachangestellter(String name, String vorname, int personalNummer, Chef vorgesetzter) {
		super(name, vorname, personalNummer);
		this.setVorgesetzter(vorgesetzter);
	}

	/**
	 * @return the vorgesetzter
	 */
	public Chef getVorgesetzter() {
		return vorgesetzter;
	}

	/**
	 * @param vorgesetzter the vorgesetzter to set
	 */
	public void setVorgesetzter(Chef vorgesetzter) {
		this.vorgesetzter = vorgesetzter;
	}

}


public class Personen {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Firma f = new Firma(
				new Person[] {new Chef("Sattler", "Beatrice",25 , "Verkauf")} ); // <==
// Teste die Aussage aus dem Video ein Cast von Kreis zu Rechteck geht nicht aber ein cast von Rechteck zu Rechteck geht und keine Daten gehen verloren?
		
		Chef chef1 = new Chef("Meier", "Hans", 1, "Einkauf");
		Person p1;
		p1 = chef1;
		
		Chef chef2;
		chef2 = (Chef) p1;
		System.out.println(chef2.getAbteilung());

	}
}
