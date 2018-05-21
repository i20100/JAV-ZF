package mod226_10.delegationexample;

import mod226_09.Spielfeld;

public class Kommando {

	private String kommadoZeichen;
	private int zeile;
	private int spalte;

	public Kommando(String kommandoZeichen, int zeile, int spalte) {
		this.kommadoZeichen = kommandoZeichen;
		this.zeile = zeile;
		this.spalte = spalte;
	}

	public void ausfuehren(Spielfeld spielfeld) {
		switch (kommadoZeichen) {
		case "M":
			spielfeld.markieren(spalte, zeile);
		case "T":
			spielfeld.aufdecken(spalte, zeile);
		}
	}

}