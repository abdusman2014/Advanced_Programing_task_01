package AP_Task_01.AP_Task;


public class Customer {
	
	private int id;
	private String name;
	private String address;
	private String number;
	
	public Customer() {
		id = 0;
		name = "\0";
		address = "\0";
		number = "\0";
	}
	
	public Customer(int id, String name, String address, String number) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
	}
	
	public Customer(Customer customer) {
		this.address = customer.address;
		this.name = customer.name;
		this.address = customer.address;
		this.number = customer.number;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void printCustomer() {
		System.out.println( "Id: " + id );
		System.out.println( "Name: " + name );
		System.out.println( "Address: " + address );
		System.out.println( "Number: " + number );
		//System.out.println( "parent class" );
	}
	
	
		

}


/*
class subClass extends Customer{
	@Override
	public void printCustomer() {
		//super.printCustomer();
		System.out.println( "Override" );
	}
}
*/

/*

//withdrawl waly function k liye class
abstract class Bike{ 
	 float salary=40000; 
	abstract void run();  
	public void same() {
		System.out.println( "I am same for both classes"  );
	}
}


 

//saving bank class
class Programmer extends Bike{
	float salary = 50;
	int bonus=10000;  
	@Override
	public void run(){System.out.println("running safely with programmer");}  
}

//checking bank class
class test  extends Bike{  
	int bonus=90000;  
	@Override
	public void run(){System.out.println("running safely with test");}  
}*/




