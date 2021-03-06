package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mod226_10.mineswepfinal.Spielfeld;
import mod226_10.mineswepfinal.Zelle;

public class ListExamples {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		//		List myList = new ArrayList(); // was before auto cleanup with ctrl+1
		List<Comparable> myList = new ArrayList<Comparable>();

		String b = "this is b as variable";

		myList.add("Object 1");
		myList.add(123); //error with access via Iterator! bad idea to mix types
		myList.add(b);
		myList.add(b + " 666");

		//direct access
		int secondPosMyList = (int) myList.get(1); // 1 refers to position like with array
		System.out.println(secondPosMyList);

		//remove object or index
		myList.remove("Object 1");
		//myList.remove(123); // does not work cause 123 would refert to positon not number
		myList.remove(0); // 0 refers to position like with array

		//access via Iterator
		@SuppressWarnings("rawtypes")
		Iterator<Comparable> iterator = myList.iterator();
		while(iterator.hasNext()) {
			String element = (String) iterator.next();
			System.out.println(element);
		}

		//access via new for-loop = for(int i = 0; i < myList.size(); i++)
		for(Object object : myList) {
			String element = (String) object;
			System.out.println(element);
		}

		//List size
		int listSize = myList.size();
		System.out.println("List Size = " + listSize);

		//clear List entries
		myList.clear();
		System.out.println("List Size = " + listSize); //interesting pointer to old value?
		System.out.println("List Size = " + myList.size()); //actual value

		System.out.println(secondPosMyList); //still works cause pointer goes to value 123
		//		System.out.println(myList.get(1)); // creates exception IndexOutOfBoundsException:

		//generic ListArray = ListArray with type bounding
		List<String> myListStr = new ArrayList<>();
		myListStr.add("def");
		myListStr.add("ABC");
		//		myListStr.add(123); // now throws error: Unresolved compilation problem
		myListStr.set(1, "bcd"); // overwrites entry [1]

		@SuppressWarnings("unused")
		String position0 = myListStr.get(0); //this still is not smart, after sorting of myListStr
		String position1 = myListStr.get(1); //positions will not be updated !!!

		//print whole ArrayList:
		System.out.println("Whole ArrayList as syso: " + myListStr.toString());
		System.out.println(position1);

		// ListArray bound to Class or object
		Spielfeld sf = new Spielfeld();
		sf.initialisiereZellenInArray();

		// Try to store object through attribute of object, this does not work!
		List<String> zellen = new ArrayList<String>();
		zellen.add(Spielfeld.zellenArray[0][0].zeichen);
		System.out.println("zellenArray: "+zellen.toString());
		for (
				@SuppressWarnings("unused")
				String string : zellen) {
			string = "%";
		}
		System.out.println("zellenArray: "+zellen.toString());

		// store object in list, then modify static attribute
		List<Zelle> listCellObjects = new ArrayList<Zelle>();
		listCellObjects.add(Spielfeld.zellenArray[0][1]);
		System.out.println("listCellObjects: "+listCellObjects.toString());
		for (Zelle zelle : listCellObjects) {
			zelle.zeichen = "&";
		}
		System.out.println("listCellObjects: "+listCellObjects.toString());
		System.out.println(listCellObjects.get(0).zeichen);
		System.out.println(Spielfeld.zellenArray[0][1].zeichen);


		//sort List
		myListStr.sort(null); //.sort(null) stands for natural order
		System.out.println("Whole ArrayList as syso: " + myListStr.toString());
		System.out.println(position1); // is not position1 after sort!!
		myListStr.set(1, "a new entry");
		System.out.println(position1); // is not position1 after set [1] !!!!
		System.out.println(myListStr.get(1)); // how to get entry [1]

	}

}
