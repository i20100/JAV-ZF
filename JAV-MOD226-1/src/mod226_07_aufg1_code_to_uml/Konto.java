package mod226_07_aufg1_code_to_uml;

public class Konto {
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
}
