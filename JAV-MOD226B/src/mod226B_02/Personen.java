package mod226B_02;

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
		Chef personal3 = new Chef("Klein", "Thomas", 2, "Verkauf");
		Fachangestellter personal1 = new Fachangestellter("Sattler", "Beatrice", 1, personal3);
		Person personal4 = new Person("Meier", "Hans", 3);

		personal1.setVorgesetzter(personal3); 		//*1
		personal4 = personal1; 				//*2
		//	  personal4.vorgesetzter = personal3; 		//*3 -> Fehler
		//	  personal1 = personal4; 				//*4 -> Fehler
		personal1 = (Fachangestellter) personal4; 	//*5
	}
}
