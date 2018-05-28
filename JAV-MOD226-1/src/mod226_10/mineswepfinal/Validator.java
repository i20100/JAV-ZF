package mod226_10.mineswepfinal;

public class Validator {
	private String[] eingabeTeile;
	private boolean istGueltig = true;

	public Validator(String eingabe) {
		eingabeTeile = eingabe.split(" ");
		if (eingabeTeile.length != 3)
			istGueltig = false;
		if (!eingabeTeile[0].equals("T") && !eingabeTeile[0].equals("M"))
			istGueltig = false;
		try {
			Integer.valueOf(eingabeTeile[1]);
			Integer.valueOf(eingabeTeile[2]);
		} catch (NumberFormatException e) {
			istGueltig = false;
		}
	}

	public boolean istGueltig() {
		return istGueltig;
	}

	public Kommando erzeugeKommando() {
		String kommandoZeichen = eingabeTeile[0];
		int zeile = Integer.valueOf(eingabeTeile[1]);
		int spalte = Integer.valueOf(eingabeTeile[2]);
		return new Kommando(kommandoZeichen, zeile, spalte);
	}
}
