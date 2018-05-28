package mod226_07_aufg1_code_to_uml;

public class Konto {
	@SuppressWarnings("unused")
	private Kunde inhaber;
	private double saldo;
	private double zinssatz;
	
	public Konto(Kunde inhaber, double zinssatz) {
		this.inhaber = inhaber;
		this.zinssatz = zinssatz;
	}
	
	public void einzahlen(double betrag) {
		saldo += betrag;
	}
	
	public double saldo() {
		return saldo;
	}

	/** 
	 * Berechnet den Zins fuer den aktuellen saldo und erhoeht den saldo entsprechend
	 *
	 * @param i Anzahl Tage fuer welche Zins berechnet wird. Ein Jahr entspricht 360 Tagen.
	 */
	public void verzinsen(int i) { double zins = saldo * zinssatz * i / 360; saldo = saldo + zins;
	}
}
