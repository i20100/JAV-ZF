package test;

import java.util.Arrays;

class ObjA {
	int a = 1;
}

public class ArrayObjects {

	public static void main(String[] args) {
		ObjA[] objAArray = new ObjA[3];
		
		System.out.println(Arrays.toString(objAArray));

		objAArray[0] = new ObjA();
		System.out.println(objAArray[0].a);
		
		for (int i = 0; i < objAArray.length; i++) {
			objAArray[i] = new ObjA();
		}
		System.out.println(Arrays.toString(objAArray));
		
	}
	
}
