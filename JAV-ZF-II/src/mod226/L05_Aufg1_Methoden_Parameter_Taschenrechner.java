package mod226;

public class L05_Aufg1_Methoden_Parameter_Taschenrechner                   {

	public static void main(String[] args) {
		// Hier geht es um eine Verbindung der Themen Methode mit Parameter und switch-Anweisung.
		/*
Methoden und Parameter
Aufgabe 1:
Einleitung:
Hier geht es um eine Verbindung der Themen Methode mit Parameter und switch-Anweisung.
Aufgabe:
a.	Schreiben Sie eine Java-Klasse mit einer Methode calc. Die Methode hat folgende Eigenschaften:
•	Die Methode besitzt drei Parameter vom Typ int:
-	operand1
-	operand2
-	operator
•	Beim Aufruf verrechnet die Methode die beiden ersten Parameter in Abhängigkeit vom Wert des dritten Parameters. Dabei gilt für die auszuführende Rechnung folgende Zuordnung:

Wert von operator	Auszuführende Rechnung
1	Addition von operand1 und operand2
2	Subtraktion von operand2 von operand1
3	Multiplikation von operand1 und operand2
4	Ganzzahlige Division von operand1 durch operand2
5	Rest der ganzzahligen Division von operand1 durch operand2

•	Die Methode gibt das Resultat der Berechnung als Return-Wert zurück.
•	Wenn operator einen ungültigen Wert hat, soll eine Fehlermeldung auf die Konsole geschrieben werden.
•	Verwenden Sie eine switch-Anweisung. 

b.	Erweitern Sie die Klasse aus Aufgabe a mit einer main-Methode, welche die Methode calc mit verschiedenen Werten aufruft. Wählen sie die Werte so, dass die Methode calc vollständig getestet wird.

c.	Für Fortgeschrittene: 
Die Ausgabe der Fehlermeldung auf die Konsole ist eine unbefriedigende Lösung. Implementieren Sie eine bessere Lösung unter Verwendung von Ausnahmen (siehe auch Buch, Kapitel 4).
		 */

		System.out.println(calc(1,1,1));
		
	}

	private static int calc(int operand1, int operand2, int operator) {
		// DONE switch by operator
		// DONE return result

		int result = 0;
		switch (operator) {
		case 1:
			result = (operand1 + operand2);			
			break;
		case 2:
			result = (operand1 - operand2);			
			break;
		case 3:
			result = (operand1 * operand2);			
			break;
		case 4:
			result = (operand1 / operand2);			
			break;
		case 5:
			result = (operand1 % operand2);			
			break;
		default:
			System.out.println("Operator ungueltig.");
			break;
		}
		return result;
	}

}
