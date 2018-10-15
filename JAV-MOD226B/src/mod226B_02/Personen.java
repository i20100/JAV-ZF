package mod226B_02;

class Person {
  String name;
  String vorname;
  int personalNummer;
}

class Chef extends Person {
  String abteilung;
}

class Fachangestellter extends Person {
  Chef vorgesetzter;
}


public class Personen {
	public static void main(String[] args) {
	  Fachangestellter personal1 = new Fachangestellter();
	  @SuppressWarnings("unused")
	Fachangestellter personal2 = new Fachangestellter();
	  Chef personal3 = new Chef();
	  Person personal4 = new Person();

	  personal3.name="Sattler";
	  personal3.vorname="Beatrice";
	  personal3.abteilung="Verkauf";
	  personal1.name="Klein";
	  personal1.vorname="Thomas";

	  personal1.vorgesetzter=personal3; 		//*1
	  personal4 = personal1; 				//*2
//	  personal4.vorgesetzter = personal3; 		//*3 -> Fehler
//	  personal1 = personal4; 				//*4 -> Fehler
	  personal1 = (Fachangestellter) personal4; 	//*5
  }
}
