package AP_Task_01.AP_Task;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Customer obj = new Customer(1,"abdullah","islamabad","3298462398");
    	
    	//subClass obj = new subClass();
    	//obj.printCustomer();
    	
    	ArrayList<String> obj = new ArrayList<String>();
    	
    	obj.add("add 1");
    	obj.add("add 2");
    	obj.remove(0);
    	
        System.out.println( obj.get(0) );
    }
}
