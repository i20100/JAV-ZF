package mod226_10.mineswepfinal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7331b7f0-6f03-4481-bf58-4aa496d1a965")
public class Validator {
	@objid ("4fe5e432-87c2-4c09-be8b-2ab41165c873")
	private String[] eingabeTeile;

	@objid ("5c664e19-9076-4b2b-8859-8180f613ca48")
	private boolean istGueltig = true;

	@objid ("8ab97b09-eebb-426a-8ab3-e5f7ea7aee27")
	public Validator(String eingabe) {
		eingabeTeile = eingabe.split(" ");
		if (eingabeTeile.length != 3)
			istGueltig = false;
		if (!eingabeTeile[0].equals("T") && !eingabeTeile[0].equals("M"))
			istGueltig = false;
		try {
			Integer.valueOf(eingabeTeile[1]);
			Integer.valueOf(eingabeTeile[2]);
			if (Integer.valueOf(eingabeTeile[1]) > Spielfeld.zeilen ) {
			throw new ArrayIndexOutOfBoundsException("Spielfeld enthaelt nur "+ (Spielfeld.zeilen-1) + " Zeilen");
			}
			if (Integer.valueOf(eingabeTeile[2]) > Spielfeld.spalten ) {
				throw new ArrayIndexOutOfBoundsException("Spielfeld enthaelt nur "+ (Spielfeld.spalten-1) + " Spalten");
			}
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			// ArrayIndexOutOfBoundsException faengt 'M 0' und 'T 0  ' eingaben auf,
			// ohne try > if ArrayIndexOutOfBoundsException Teil
			istGueltig = false;
			System.out.println(e);
		}
	}

	@objid ("6d64f307-31d6-421f-89eb-c9821c307d6d")
	public boolean istGueltig() {
		return istGueltig;
	}

	@objid ("7cf91935-bb63-46dd-ac71-7f99a4ecca06")
	public Kommando erzeugeKommando() {
		String kommandoZeichen = eingabeTeile[0];
		int zeile = Integer.valueOf(eingabeTeile[1]);
		int spalte = Integer.valueOf(eingabeTeile[2]);
		return new Kommando(kommandoZeichen, zeile, spalte);
	}

}
