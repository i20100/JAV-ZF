package mod226_06_bank;

public class Konto {

	/*	Aufgabe:
		DONE
		Er�ffnen Sie ein neues Projekt Bank. Schreiben Sie eine Klasse Konto
		mit je einer privaten Instanzvariablen f�r den Saldo und den Zinssatz
		(Der Zinssatz soll zuerst bei jedem Konto 1% betragen).
		DONE
		Die Klasse soll folgende �ffentlichen Methoden haben:
		einzahlen: Der einzuzahlende Betrag kann beim Aufruf als Parameter
		 mitgegeben werden.
		DONE
		verzinsen: Berechnet den Zins f�r eine bestimmte Laufzeit (in Tagen)
		und addiert diesen zum Saldo. Die Laufzeit in Tagen kann beim Aufruf
		 als Parameter angegeben werden. Ber�cksichtigt werden muss dabei, 
		 dass der Zinssatz abh�ngig ist vom vorhandenen Kontostand: ist dieser 
		 �ber 50�000, so halbiert sich der Zinssatz, 
		 ab 500�000 gibt es keinen Zins mehr.
		Die Zinsformel lautet: Zins = Saldo * Zinssatz * Laufzeit / 365
		(Kein Zinseszins, Zinssatz auf ein Jahr bezogen)
		DONE
		getSaldo: Gibt den aktuellen Saldo zur�ck.
		
		DONE
		Schreiben Sie eine Klasse TestKonto mit main-Methode. Diese soll zwei Kontoobjekte erzeugen und deren Methoden testen: z.B.
		Zahlen Sie auf das erste Konto 500.75 CHF ein und verzinsen Sie es w�hrend 365 Tagen.
		Zahlen Sie auf das zweite Konto 720.50 CHF ein und verzinsen es w�hrend 750 Tagen. Geben Sie den Saldo aus. Zahlen Sie erneut auf das zweite Konto ein und geben Sie wiederum den Saldo aus.
		Versuchen Sie im Testprogramm auch direkt auf die Instanzvariablen der Kontoobjekte zuzugreifen. Was stellen Sie fest?

		Beachten Sie die Java-Namenskonventionen (Buch, Kapitel 2.1)
		Zus�tzlich Informationen finden Sie im Buch, Kapitel 3.1 und 3.2.
	 */

	private double saldo;
	private double zinssatz = 0.01;

	public void einzahlen (double betrag) {
		saldo = saldo + betrag;
	}

	public double getSaldo () {
		// XXX saldo Runden auf zwei Kommastellen
		return saldo;
	}

	public void verzinsen (int tage) {
		if (saldo >= 500000) {
			zinssatz = 0;
			// Methode direkt abbrechen? Keine Zinsberechnung n�tig
			
		}
		else if (saldo > 50000) {
			zinssatz = zinssatz /2;
		}
		
		//		Die Zinsformel lautet: Zins = Saldo * Zinssatz * Laufzeit / 365
		//		(Kein Zinseszins, Zinssatz auf ein Jhr bezogen)
		// Die anzahl Tage entspricht also der anzahl Tage seit der Konto Entstehung/Er�ffnung.
		double zins = saldo * zinssatz * tage / 365;
		einzahlen (zins);
	}
	
	
}
