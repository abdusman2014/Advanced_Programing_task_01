package AP_Task_01.AP_Task;

import java.util.ArrayList;

public class Checkings extends Account {

	private int freeTransactions;
	private double additionalAmount;
	
	private ArrayList<Integer> transactionTaxRecord;
	/*private ArrayList<Double> transactionAmountRecord;
	private ArrayList<Double> transactionBalanceRecord;*/

	public Checkings() {
		freeTransactions = 1;
		additionalAmount = 5000;
		transactionTaxRecord = new ArrayList<Integer>();
		/*transactionBalanceRecord = new ArrayList<Double>();
		transactionBalanceRecord = new ArrayList<Double>();*/
	}

	@Override
	public void makeWithdrawal(double amount) {
		// TODO Auto-generated method
		if(freeTransactions>2) {		//tax will be applies on every withdrawl
			balance -= 10;
		}
		freeTransactions++;
		if(additionalAmount>0 && amount<=balance + additionalAmount) {
			balance -= amount;
			if(balance <0) {
				additionalAmount -= (balance) + (2*balance);
			}
			transactionAmountRecord.add(amount);
			transactionBalanceRecord.add(balance);
			transactionTaxRecord.add(transactionAmountRecord.size() -1);
		}
		else {
			System.out.println( "Insufficient balance and additional amount of 5000 also consumed");
		}

	}

	@Override
	public void displayAllDeductions() {
		// TODO Auto-generated method stub
		System.out.println("Tax of 10Rs applied on following withdrawls:");
		for(int i=0;i<transactionTaxRecord.size();++i) {
			System.out.println("amount withdraw: " + transactionAmountRecord.get(transactionTaxRecord.get(i)));
			System.out.println("remaining balance: " + transactionBalanceRecord.get(transactionTaxRecord.get(i)));
		}

	}

}