package testinstanzen;

public class KlasseStaticTest2 {

	int count=0;//will get memory when instance is created  
	static int countStatic = 0;

	public KlasseStaticTest2(){  
		count++;
		countStatic++;
		System.out.println("count: " + count);  
		System.out.println("countStatic: " + countStatic);
	}

	public static void main(String[] args) {
		KlasseStaticTest2 c1 = new KlasseStaticTest2(); // Output will be 1
		KlasseStaticTest2 c2 = new KlasseStaticTest2(); // Output will be 1
	}

}
