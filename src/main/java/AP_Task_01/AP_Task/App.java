package AP_Task_01.AP_Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws IOException
	{
		//Customer obj = new Customer(1,"abdullah","islamabad","3298462398");

		//subClass obj = new subClass();
		ArrayList<Account> myAccounts = new ArrayList<Account>();

		Scanner s = new Scanner(System.in);


boolean exitCode = true;
		while(exitCode) {
			int flag = 0;
			do {
				System.out.println( );
				System.out.println("!!!!!!!! Main Menu !!!!!!!!!!!!!! "  );
				System.out.println("Press 1 to Create an account: "  );
				System.out.println("Press 2 to Login to a specific account"  );
				System.out.println("Press 3 to  view details of all accounts"  );
				System.out.println("Press 4 to  view details of all accounts diductions"  );
				System.out.println( "Press 5 to exit" );
				flag = s.nextInt();
			}while(flag <1 || flag > 5);
			s.nextLine();
			if(flag == 1) {
				String name = "\0",address = "\0", number = "\0";
				double balance = 0;
				System.out.print( "Enter you name: " );
				name = s.nextLine();
				System.out.print( "Enter you address: " );
				address = s.nextLine();
				System.out.print( "Enter you phone number: " );
				number = s.nextLine();
				System.out.print( "Enter balance: "  );
				balance = s.nextDouble();
				int opt = 0;
				do {
					System.out.println( "Press 1 to open checking account: "  );
					System.out.println( "Press 2 to open savings account:"  );
					opt = s.nextInt();
					s.nextLine();
				}while(opt<1 && opt>2);
				if(opt == 1) {
					myAccounts.add(new Checkings(new Customer(name,address,number),balance));
				}
				else {
					myAccounts.add(new Savings(new Customer(name,address,number),balance));
				}

				System.out.print("Press Enter to move to main menu: ");
				String temp = s.nextLine();

				//myAccounts.add(new )

			}
			else if(flag ==2) {
				int Index = -1;
				String accNo = "\0";
				System.out.print( "Enter your account No: "  );
				accNo = s.nextLine();
				//Object e;
				for (int i=0;i<myAccounts.size();++i) {
					//System.out.println(myAccounts.get(i).getAccountNo());
					if(myAccounts.get(i).getAccountNo().equals(accNo)) {
						Index = i;
						break;
					}
				}
				if(Index == -1) {
					System.out.println("In Correct acc Id" );
				}
				else {
					boolean isLoggedIn = true;
					while(isLoggedIn) {
						int option = 0;
						do {
							System.out.println("Wellcome " +myAccounts.get(Index).getName());
							System.out.println("Press 1 to deposit amount");
							System.out.println("Press 2 to withDraw amount");
							System.out.println("Press 3 to check balance amount");
							System.out.println("Press 4 to print statement amount");
							System.out.println("Press 5 to transfer amount amount");
							System.out.println("Press 6 to display all deductions");
							if(myAccounts.get(Index) instanceof Savings) {
								System.out.println("Press 7 to calculate zakat");
							}
							option = s.nextInt();

						}while(( option <1 || option >7)  );
						if(option ==1) {
							double amount = 0;
							System.out.print("Enter deposit amount: ");
							amount = s.nextDouble();
							s.hasNextLine();
							myAccounts.get(Index).makeDeposit(amount);
						}
						else if(option ==2) {
							double amount = 0;
							System.out.print("Enter withDraw amount: ");
							amount = s.nextDouble();
							s.hasNextLine();
							myAccounts.get(Index).makeWithdrawal(amount);;
						}
						else if(option ==3) {
							myAccounts.get(Index).checkBalance();
						}
						else if(option == 4) {
							myAccounts.get(Index).printStatement();
						}
						else if(option == 5) {
							String bank = "\0";
							double amount = 0;
							System.out.print("Enter bank name: ");
							bank = s.nextLine();
							System.out.print("Enter withDraw amount: ");
							amount = s.nextDouble();
							s.hasNextLine();
							myAccounts.get(Index).transferAmount(amount, bank);
						}
						else if(option == 7 && (myAccounts.get(Index) instanceof Savings)) {
							System.out.println("****");
							((Savings)myAccounts.get(Index)).calculateZakat();
						}
						else  {
							myAccounts.get(Index).displayAllDeductions();
						}
						
						String chk = "\0";
						do {
							System.out.println("Press y to make more functionality: ");
							System.out.println("or Press n to logout and move to main menu: ");
							chk = s.nextLine();
							System.out.println("opt: " + chk);
						}while(!chk.equals("n")  && !chk.equals("N") && !chk.equals("y") && !chk.equals("Y"));
						if(chk.equals("n")  || chk.equals("N")) {
							isLoggedIn = false;
						}
						System.out.println();
						System.out.println();
					}
				}

			}
			else if(flag ==3) {
				for (int i=0;i<myAccounts.size();++i) {
					myAccounts.get(i).checkBalance();
					if (myAccounts.get(i) instanceof Savings) {
						System.out.println("Savings Account");
					}
					else {
						System.out.println("Checking Account");
					}
				}
			}
			else if(flag ==4) {
				for(int i=0;i<myAccounts.size();++i) {
					System.out.println("Account holder name: " + myAccounts.get(i).getName());
					if (myAccounts.get(i) instanceof Savings) {
						System.out.println("Savings Account");
					}
					else {
						System.out.println("Checking Account");
					}
					myAccounts.get(i).displayAllDeductions();
				}
			}
			else {
				exitCode = false;
			}
			System.out.println();
			System.out.println();
		}

		System.out.println("!!!!!! THE END !!!!!!!");
		/*	//obj.printCustomer();
		Customer customer = new Customer(1,"abdullah","islamabad","238974093");
		Account obj = new Savings(customer,"2",10000,"9/10/2021");

		obj.makeWithdrawal(5000);

		obj.checkBalance();


		if(obj instanceof Savings) {
			((Savings) obj).calculateZakat();
		}

		obj.makeWithdrawal(2000);

		obj.printStatement();


		System.out.println(  );*/
	}
}
