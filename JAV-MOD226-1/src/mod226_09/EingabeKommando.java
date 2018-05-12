package mod226_09;

import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("6303347c-f1fd-46c0-9ea7-8dfa90384f7b")
public class EingabeKommando {
	@objid ("5fe374a7-3f62-4847-8e8e-5f6a7f70952c")
	private String benutzerEingabe;
	
	public String getBenutzerEingabe() {
		return benutzerEingabe;
	}

	@objid ("72d11dcb-6987-4a16-8084-97a669e47f49")
	//    public void liesBenutzerEingabe(Scanner benutzerInput) {
	public void liesBenutzerEingabe() {
		Scanner sc = new Scanner(System.in);
		benutzerEingabe = sc.nextLine();
		sc.close();
		System.exit(0);
	}

	@objid ("f27262b4-9774-4354-a60f-28a56cb0f256")
	public void pruefeBenutzerEingabe() {
	}

}
