package AP_Task_01.AP_Task;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {
	Customer customer;
	
	@Before
	public void SetUp() {
		customer = new Customer("abdullah","Islamabad","03177936365");
		System.out.print("&&");
	}
	
	@Test
	public void a_IdCheck()
	{
		//System.out.println("acc " +account.getAccountNo());
		assertEquals(customer.getId(),1);
	}
	
	@Test
	public void b_NameCheck()
	{
		//System.out.println("acc " +account.getAccountNo());
		assertEquals(customer.getName(),"abdullah");
	}
	
	@Test
	public void c_AddressCheck()
	{
		//System.out.println("acc " +account.getAccountNo());
		assertEquals(customer.getAddress(),"Islamabad");
	}
	@Test
	public void d_NumberCheck()
	{
		//System.out.println("acc " +account.getAccountNo());
		assertEquals(customer.getNumber(),"03177936365");
	}
	
	

}
