package AP_Task_01.AP_Task;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SavingsTest {

	 Customer customer;

	 Savings account;

	@Before
	public void SetUp() {
		//if(flag) {
			customer = new Customer("abdullah","Islamabad","03177936365");
			account = new Savings(customer,3000);
	//	}
		//System.out.println(i);
		//i++;
	}

	@Test
	public void a_AccountNoCheck()
	{
		//System.out.println("acc " +account.getAccountNo());
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
	public void e_WithDrawalCheck()
	{
		account.makeWithdrawal(1000);
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),2000,0);
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
	public void g_DepositeCheck()
	{
		account.makeDeposit(1000);
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),4000,0);
	}

	@Test
	public void h_ZakatDeductionNegativeCheck()
	{
		account.calculateZakat();
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),3000,0);
	}

	@Test
	public void i_ZakatDeductionCheck()
	{
		account.makeDeposit(20000);
		account.calculateZakat();
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getBalance(),23000-575,0);
	}

	@Test
	public void j_IntresetCheck()
	{
		account.calculatelnterest(2000);
		//System.out.print(account.getBalance());
		//assertEquals(account.getBalance(),3000.0);
		assertEquals(account.getIntrestRate(),2000,0);
	}



	//rest of the functions have void return type (display functions, i.e, displayAllDeductions and printStatement)
	//their test cases can not be return


}
