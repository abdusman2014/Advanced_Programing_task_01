package AP_Task_01.AP_Task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

import java.util.ArrayList;
import java.util.StringTokenizer;

abstract class Account {

	protected Customer customer;
	protected String accountNo;
	protected double balance;
	protected DateTimeFormatter dateCreated;
	protected ArrayList<DateTimeFormatter> transactionDateRecord;
	protected ArrayList<Double> transactionAmountRecord;
	protected ArrayList<Double> transactionBalanceRecord;
	//private boolean flag; 			//if 0 =>saving account, if 1 => checking account


	public Account() {
		customer = new Customer();
		accountNo = "\0";
		balance = 0;
		dateCreated = null;
		transactionDateRecord = new ArrayList<DateTimeFormatter>();
		transactionAmountRecord = new ArrayList<Double>();
		transactionBalanceRecord = new ArrayList<Double>();
		//flag = false;
	}
	


	public Account(Customer customer,double balance) {
		this.customer = new Customer(customer);
		 StringTokenizer st1 =
	             new StringTokenizer(customer.getName(), " ");
		this.accountNo = st1.nextToken() + customer.getId();//accountNo;
		System.out.println("Your account number is, this will be required when you will login: " + this.accountNo);
		this.balance = balance;
		this.dateCreated = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		transactionDateRecord = new ArrayList<DateTimeFormatter>();
		transactionAmountRecord = new ArrayList<Double>();
		transactionBalanceRecord = new ArrayList<Double>();
		//this.flag = flag;

	}
	
	public String getName() {
		return customer.getName();
	}

	public int getId() {
		return customer.getId();
	}


	public String getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public DateTimeFormatter getDateCreated() {
		return dateCreated;
	}

	public void makeDeposit(double amount) {
		balance += amount;
	}

	public abstract void makeWithdrawal(double amount);/* {
		if(amount>=balance) {
			balance -= amount;
		}
		else {
			System.out.println( "Insufficient balance");
		}
	}*/

	public void checkBalance() {
		System.out.println( "name: " + customer.getName());
		System.out.println( "balance: " + balance);
	}

	public void transferAmount(double amount, String bankName ) {
		if(amount<=balance) {
			balance -= amount;
			System.out.println( "Amount transfered to " + bankName);
		}
		else {
			System.out.println( "Insufficient balance");
		}
	}
	
	public void printStatement() {
		System.out.println( "Customer name: " + customer.getName());
		System.out.println( "Account Number: " + accountNo);
		LocalDateTime now = LocalDateTime.now();  
		for(int i=0;i<transactionAmountRecord.size();++i) {
			System.out.print( "Transaction amount: " +  transactionAmountRecord.get(i) + ", ");
			System.out.print( "balance remaining: " +  transactionBalanceRecord.get(i) + ", ");
			System.out.println( "Date of Transaction: " +  transactionDateRecord.get(i).format(now));
			 
		}
	}
	
	public abstract void displayAllDeductions();

	/*public boolean getFlag() {
		return flag;
	}*/

}
