package test;

public class ClassAndMethods {

	public static void main(String[] args) {

		Account a1 = new Account(new Customer("Foo"));

		// magic Answer on how to print Customer "Foo" not known jet.... 
		// something along: a1.getCustomer.name would be nice...
		//workaround or solution to this? write a get method as follows 
		// (getName needs to exist in Customer!) in class Account:
		System.out.println(a1.getOwner()); // test.Customer@70dea4e

		Customer c1 = a1.getOwner();
		System.out.println(c1.getName()); // Foo

	}

}

class Account {
	private Customer owner;

	public Customer getOwner() {
		return owner;
	}

	public Account(Customer customer) {
		this.owner = customer;
	}

}

class Customer {
	private String name;

	public String getName() {
		return name;
	}

	public Customer(String string) {
		this.name = string;
	}

}
