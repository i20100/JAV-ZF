package mod226_08;

public class FizzBuzz {

	public static void main(String[] args) {
		Zahlenreihe init = new Zahlenreihe();
		init.setEndzahl(15);
		
		for (int i = 0; i < init.getEndzahl(); i++) {
			
		Pruefer eins = new Pruefer(
				init.getZahl()
				);
		
		System.out.println(eins.Antwort());
		}
		
		
	}

}
