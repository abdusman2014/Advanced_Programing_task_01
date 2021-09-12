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
    	Customer customer = new Customer(1,"abdullah","islamabad","238974093");
    	Savings obj = new Savings(customer,"2",10000,"9/10/2021");
    	
    	obj.makeWithdrawal(5000);
    	
    	obj.checkBalance();
    	
    	obj.calculateZakat();
    	
    	obj.makeWithdrawal(2000);
    	
    	obj.printStatement();
    	
    	
        System.out.println(  );
    }
}
