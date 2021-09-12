package AP_Task_01.AP_Task;

import java.util.ArrayList;

public class Savings extends Account {

	private double intrestRate;
	private ArrayList<Integer> transactionZakatRecord;
	/*private ArrayList<Double> transactionAmountRecord;
	private ArrayList<Double> transactionBalanceRecord;*/

	public Savings() {
		intrestRate = 10;
		transactionZakatRecord = new ArrayList<Integer>();
		/*transactionBalanceRecord = new ArrayList<Double>();
		transactionBalanceRecord = new ArrayList<Double>();*/
	}

	@Override
	public void displayAllDeductions() {
		// TODO Auto-generated method stub
		System.out.println("Zakat details:");
		for(int i=0;i<transactionZakatRecord.size();++i) {
			System.out.println("amount withdraw: " + transactionAmountRecord.get(transactionZakatRecord.get(i)));
			System.out.println("remaining balance: " + transactionBalanceRecord.get(transactionZakatRecord.get(i)));
		}

	}

	public void calculatelnterest(double intrest) {
		this.intrestRate = intrest;
	}

	public void calculateZakat() {
		if(balance>=20000) {
			double amount = (balance*2.5)/100;
			balance -= amount;
			transactionAmountRecord.add(amount);
			transactionBalanceRecord.add(balance);
			transactionZakatRecord.add(transactionAmountRecord.size() -1);
		}
		else {
			System.out.println( "Balance is less than 20,000");
		}
	}

	@Override
	public void makeWithdrawal(double amount) {
		// TODO Auto-generated method stub
		if(amount<=balance) {
			balance -= amount;
			transactionAmountRecord.add(amount);
			transactionBalanceRecord.add(balance);
		}
		else {
			System.out.println( "Insufficient balance");
		}
	}

	public double getIntrestRate() {
		return intrestRate;
	}







}
