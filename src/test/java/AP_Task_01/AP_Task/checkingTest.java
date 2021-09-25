package AP_Task_01.AP_Task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class checkingTest {
	
	Customer customer;
	
	Checkings account;
	
	@Before
	public void SetUp() {
		customer = new Customer("abdullah","Islamabad","03177936365");
		account = new Checkings(customer,3000);
		System.out.print("&&");
	}
	
	@Test
	public void a_AccountNoCheck()
	{
		assertEquals(account.getAccountNo(),"abdullah1");
	}

	@Test
	public void b_NameCheck()
	{
		assertEquals(account.getName(),"abdullah");
	}
	
	
	

	@Test
	public void c_TransferAmountCheckNegative()
	{
		account.transferAmount(4000, "hbl");
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),3000,0);
	}
	
	@Test
	public void d_TransferAmountCheck()
	{
		account.transferAmount(1000, "hbl");
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),2000,0);
	}
	
	@Test
	public void d_WithDrawalCheck()
	{
		account.makeWithdrawal(1000);
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),2000,0);
	}
	
	@Test
	public void e_WithDrawaAmountGreaterThanBalanceCheck()		//can withdraw amount of 5000 even if balance is zero or less than amount
	{
		account.makeWithdrawal(5000);
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),-2000,0);
	}
	
	@Test
	public void f_WithDrawalNegativeCheck()		
	{
		account.makeWithdrawal(9000);			//amount withdrawing is greater than balance + additional amount
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),3000,0);
	}
	
	@Test
	public void g_WithDrawalTaxeCheck()		
	{
		account.makeWithdrawal(1000);
		account.makeWithdrawal(500);
		account.makeWithdrawal(500);
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),990,0);		//withdraw total = 1000+500+500 + 10(tax after first two transactions) = 2010
	}
	
	@Test
	public void h_DepositeCheck()
	{
		account.makeDeposit(1000);
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),4000,0);
	}
	
	//rest of the functions have void return type (display functions, i.e, displayAllDeductions and printStatement)
	//their test cases can not be return
	

}
