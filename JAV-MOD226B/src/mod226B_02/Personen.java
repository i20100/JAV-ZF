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

abstract class Person {
	protected String name;
	protected String vorname;
	protected int personalNummer;

	public Person(String name, String vorname, int personalNummer) {
		this.name = name;
		this.vorname = vorname;
		this.personalNummer = personalNummer;
	}

	public void print() {
		System.out.println("Personal-Nr.: "+personalNummer+"\n"
				+ "Name und Vorname : "+name+" "+vorname);
	}

	public abstract int berechneFerien(int alter);
}

class Chef extends Person {
	private String abteilung;

	public Chef(String name, String vorname, int personalNummer, String abteilung) {
		super(name, vorname, personalNummer);
		this.setAbteilung(abteilung);
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Abteilungsleiter fuer: "+ abteilung);
	}

	@Override
	public int berechneFerien(int alter) {
		int ferien = 4;
		if (alter > 54) {
			ferien = 6;
		}
		if (alter > 44) {
			ferien = 5;
		}
		return ferien;
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

	@Override
	public int berechneFerien(int alter) {
		int ferien = 4;
		if (alter > 59) {
			ferien = 6;
		}
		if (alter > 49) {
			ferien = 5;
		}
		return ferien;
	}

}

class Lernender extends Person {
	private int lehrjahr;

	public Lernender(String name, String vorname, int personalNummer, int lehrjahr) {
		super(name, vorname, personalNummer);
		this.lehrjahr = lehrjahr;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Lehrjahr: "+lehrjahr);
	}

	@Override
	public int berechneFerien(int alter) {
		int ferien = 5;
		return ferien;
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

		//		f.setMitarbeiter(new Fachangestellter("von Siebenthal", "Marie", 5, f.getMitarbeiter()));
	
		Fachangestellter fa = new Fachangestellter("von Siebenthal", "Marie", 5, chef1);
		Lernender l = new Lernender("Schweizer", "Kevin", 3, 2);

		p1.print();
		fa.print();
		l.print();

		Person[] angestellte = new Person[4];
		angestellte[0] = chef1;
		angestellte[1] = fa;
		angestellte[2] = l;
		angestellte[3] = new Fachangestellter("Schweizer", "Alois", 6, chef1);
		
		for (Person person : angestellte) {
			System.out.println("Der Ferienanspruch beträgt: " + person.berechneFerien(46));
		}
		
	}
}
