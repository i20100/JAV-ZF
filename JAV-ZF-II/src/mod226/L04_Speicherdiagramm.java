package mod226;

public class L04_Speicherdiagramm {

	public static void main(String[] args) {
		int a = 100;
		int[] b;
		b = new int[]{10, 20, 30};
		int[] c = new int[2]; // c refers to array with two fields both value 0
		System.out.println(c[0]);
		c[0] = b[0]; // what happens to c[0]? b[0] gets copied into c[0], c[1]? stays 0
		System.out.println(c[0]);
		System.out.println(c[1]);
		
		
		
		c[0] = a;
		c = b;
		c[0] = 200;
		b = null;
		c = null;
	}

}
