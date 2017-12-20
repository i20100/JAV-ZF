package mod226_06_bank;

import javax.sound.midi.Synthesizer;

public class TestKonto {

	public static void main(String[] args) {
/*		Schreiben Sie eine Klasse TestKonto mit main-Methode. Diese soll zwei Kontoobjekte erzeugen und deren Methoden testen: z.B.
		Zahlen Sie auf das erste Konto 500.75 CHF ein und verzinsen Sie es während 365 Tagen.
		Zahlen Sie auf das zweite Konto 720.50 CHF ein und verzinsen es während 750 Tagen. Geben Sie den Saldo aus.
		Zahlen Sie erneut auf das zweite Konto ein und geben Sie wiederum den Saldo aus.
		Versuchen Sie im Testprogramm auch direkt auf die Instanzvariablen der Kontoobjekte zuzugreifen. Was stellen Sie fest?*/
		
		Konto k1 = new Konto(new Kunde ("Heinz", "Truttmann", 1111));
		//		k1.inhaber = new Kunde ("Heinz", "Truttmann", 1111); würde auch gehen, aber da inhaber private geht es so eben doch nicht
		k1.einzahlen(500.75);
		System.out.println(k1.getInhaberName());
		System.out.println(k1.getSaldo());
		k1.verzinsen(365);
		System.out.println(k1.getSaldo());
		
		Konto k2 = new Konto(new Kunde ("Anita", "Bonucci", 1112));
		k2.einzahlen(720.50);
		k2.verzinsen(750);
		System.out.println(k2.getSaldo());
		k2.einzahlen(1000);
		System.out.println(k2.getSaldo());
		
//		k2.zinssatz = 0.02; -> zinssatz ist nicht sichtbar!
		
		Konto k3 = new Konto(new Kunde("Donald", "Duck", 1113));
		k3.einzahlen(55000);
		k3.verzinsen(365);
		System.out.println(k3.getSaldo());
		
		
		Konto k4 = new Konto();
		Kunde ku4 = new Kunde("Max", "Testermann", 1114);
		System.out.println(ku4.getName());
//		System.out.println(k4.getInhaberName()); // Gibt Fehler aus wenn Inhaber nicht vorher gesetzt wurde: k4.setInhaber(ku4); 
		k4.setInhaber(ku4);
		System.out.println(k4.getInhaberName());
		
	}

}
