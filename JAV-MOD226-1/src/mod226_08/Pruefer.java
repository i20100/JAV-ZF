package mod226_08;

public class Pruefer {

	private int zahl;
	private boolean teilbarDrei;
	private boolean teilbarFuenf;
	private String zahlString;


	public Pruefer(int i) {
		this.zahl = i;
		this.zahlString = Integer.toString(i);
		teilbarDrei();
		teilbarFuenf();
	}

	public int getZahl() {
		return zahl;
	}

	boolean teilbarDrei() {
		if (zahl % 3 == 0 ) {
			teilbarDrei = true;
			return true;
		} 
		return false;
	}

	public boolean teilbarFuenf() {
		if (zahl % 5 == 0 ) {
			teilbarFuenf = true;
			return true;
		} 
		return false;
	}

	public String Antwort() {
		if (teilbarDrei && teilbarFuenf == true) {
			return "Fizz Buzz";
		} else if (teilbarDrei == true && teilbarFuenf == false) {
			return "Fizz";
		} else if (teilbarDrei == false && teilbarFuenf == true) {
			return "Buzz";
		}
		return zahlString;
	}

}
