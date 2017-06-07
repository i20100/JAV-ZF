package mod226;

public class L02_Typen_Casts {

	private static int a = 13; // Klassenvariable

	public static void main(String args[])
	{
		int a; // lokale Variable überdeckt Klassenvariable
		a = 10;
		{
			int b = 20; //noch "lokalere" Variable
			System.out.println(b); // Ausgbe 20
		}

		System.out.println(a);       // Ausgabe: 10 
		System.out.println(L02_Typen_Casts.a); // Ausgabe: 13
		L02_Typen_Casts.a = a;       // a 10 wird in private static int a geschrieben!!!          
		System.out.println(L02_Typen_Casts.a); // Ausgabe: 10
	}
}