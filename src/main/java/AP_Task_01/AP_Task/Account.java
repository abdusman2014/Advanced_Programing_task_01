package AP_Task_01.AP_Task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

import java.util.ArrayList;

abstract class Account {

	protected Customer customer;
	protected String accountNo;
	protected double balance;
	protected String dateCreated;
	protected ArrayList<DateTimeFormatter> transactionDateRecord;
	protected ArrayList<Double> transactionAmountRecord;
	protected ArrayList<Double> transactionBalanceRecord;
	//private boolean flag; 			//if 0 =>saving account, if 1 => checking account


	public Account() {
		customer = new Customer();
		accountNo = "\0";
		balance = 0;
		dateCreated = "\0";
		transactionDateRecord = new ArrayList<DateTimeFormatter>();
		transactionAmountRecord = new ArrayList<Double>();
		transactionBalanceRecord = new ArrayList<Double>();
		//flag = false;
	}
	


	public Account(Customer customer,String accountNo,double balance,String dateCreated) {
		this.customer = new Customer(customer);
		this.accountNo = accountNo;
		this.balance = balance;
		this.dateCreated = dateCreated;
		transactionDateRecord = new ArrayList<DateTimeFormatter>();
		transactionAmountRecord = new ArrayList<Double>();
		transactionBalanceRecord = new ArrayList<Double>();
		//this.flag = flag;

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

	public String getDateCreated() {
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
		if(amount>=balance) {
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
			System.out.println( "Transaction amount: " +  transactionAmountRecord.get(i));
			System.out.println( "balance remaining: " +  transactionBalanceRecord.get(i));
			System.out.println( "Date of Transaction: " +  transactionDateRecord.get(i).format(now));
			 
		}
	}
	
	public abstract void displayAllDeductions();

	/*public boolean getFlag() {
		return flag;
	}*/

}
