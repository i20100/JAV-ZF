package test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStandardMemAllocation {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//What happens for new ArrayList() (type of Array not defined)
		//Answer: Instance of DEFAULTCAPACITY_EMPTY_ELEMENTDATA is created
		//with a 10 standard capacity, stored in a buffer, but
		//the size() of the List is still zero. The list is initialized empty.
		@SuppressWarnings("rawtypes")
		List myList = new ArrayList();
		System.out.println("myList:");
		System.out.println(myList.size());
		System.out.println(myList.isEmpty());
		//IndexOutOfBoundsException example when accessing empty list
		//System.out.println(myList.get(0)); // @(ArrayListStandardMemAllocation.java:18)
		
		@SuppressWarnings("rawtypes")
		List myList2 = new ArrayList(); // refers to same instance like myList
		// reference is to DEFAULTCAPACITY_EMPTY_ELEMENTDATA
		// cause this is a Shared empty array instance used for empty instances.
		// Will switch to another Object once filled with data
		// see ArrayList.class for details
		System.out.println("Is myList equal to myList2?");
		System.out.println(myList.equals(myList2));
		
		//Another example of new ArrayList(withCapacitySet);
		//Instance of EMPTY_ELEMENTDATA is created
		//Same result list is empty until filled.
		@SuppressWarnings("rawtypes")
		List myList3 = new ArrayList(5);
		System.out.println("myList3:");
		System.out.println(myList3.size());
		System.out.println(myList3.isEmpty());
		myList3.add("Spectre");
		myList3.add("Meltdown");
		System.out.println(myList3.size());
		System.out.println(myList3.toString()); //=System.out.println(myList3);

		//Same applies to ArrayList with type defined
		List<Object> myObjsList = new ArrayList<Object>();
		System.out.println("myObjsList:");
		System.out.println(myObjsList.size());


		//Comparison of behavior to normal Array
		int[] intArray = new int[10];
		System.out.println("intArray:");
		System.out.println(intArray.length);
		System.out.println(intArray[0]);
		System.out.println(intArray[1]);


		//Examples of ArrayList with entries and therefore size > 0
		// create an array list
		@SuppressWarnings("rawtypes")
		ArrayList al = new ArrayList();
		System.out.println("Initial size of al: " + al.size());

		// add elements to the array list
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		al.add(1, "A2");
		System.out.println("Size of al after additions: " + al.size());

		// display the whole array list
		System.out.println("Contents of al: " + al);

		// Remove elements from the array list
		al.remove("F");
		al.remove(2);
		System.out.println("Size of al after deletions: " + al.size());
		System.out.println("Contents of al: " + al);


	}

}
