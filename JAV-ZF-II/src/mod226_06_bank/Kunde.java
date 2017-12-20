package mod226_06_bank;

public class Kunde {
	/*
	 * DONE
	 * Schreiben Sie eine Klasse Kunde inkl. Konstruktor. Die Klasse 
	 * soll private Instanzvariablen für folgende Informationen zu 
	 * einem Kunden enthalten:
		•	Name
		•	Vorname
		•	Kundennummer
		Wählen Sie geeignete Datentypen.

		DONE
		Erweitern Sie sodann die Klasse Konto um die Instanzvariable
		 inhaber. Dieses soll auf den Kunden, welchem das Konto gehört
		  verweisen. Welcher Typ muss die Instanzvariable somit haben?

		DONE
		Passen Sie auch den Konstruktor in der Klasse Konto an, 
		so dass bei der Erzeugung eines neuen Kontos ein Kundenobjekt 
		als Inhaber mitgegeben werden kann. 
		-> Konstruktor Kunde (name, vorname, kundennummer) erstellt
		
		TODO
		Erweitern Sie schliesslich Ihre Testklasse, so dass jedes Konto 
		einen Kunden als Inhaber hat, und seinen Namen ausgibt in 
		Zusammenhang mit der Saldoausgabe.

		Weitere Informationen zur Klasse String finden Sie entweder in der 
		Java-Api-Doc oder im Buch Kapitel 5.1.1.
	 */

	private String name;
	private String vorname;
	private int kundennummer;

	Kunde() {
	}
	
	Kunde(String vorname, String name, int kundennummer) {
		this.vorname = vorname;
		this.name = name;
		this.kundennummer = kundennummer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}
}
