package mod226_07_aufg1_code_to_uml;

public class Adresse {
	private String strasse;
	private String ort;
	
	public Adresse(String strasse, String ort) {
		this.strasse = strasse;
		this.ort = ort;
	}
	
	public String toString() {
		return strasse + ", " + ort;
	}
}
