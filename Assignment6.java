import java.util.Scanner;

public class Assignment6 
{
	public static Scanner scan = new Scanner(System.in);
	public static PatronList obj = new PatronList();
	
	private static String printList()
	{
		System.out.println("a. List Patrons");
		System.out.println("b. Add New Patron");
		System.out.println("c. Remove Patron");
		System.out.println("d. Patron Specific Actions");
		System.out.println("e. Quit");
		String input = scan.nextLine();
		return input;
	}
		private static String patronMenu()
		{
			System.out.println("a. Add New Account");
			System.out.println("b. Close Account");
			System.out.println("c. Get Paid");
			System.out.println("d. Apply Interest to Accounts");
			System.out.println("e. Make Deposit");
			System.out.println("f. Make Withdraw");
			System.out.println("g. Return to Main Menu");
			
			String input = scan.nextLine();
			return input;
		}
	
	private static void accountTypeMenu() //#25
	{
		System.out.println("a. Checking");
		System.out.println("b. Savings");
		System.out.println("c. CD");
		System.out.println("d. Money Market");
		System.out.println("e. IRA");
	}
	
	public static void patronSpecificMenu(BankPatron a) //#26 - do they want a patronlist or bankpatron object
	{
		String name = a.getFullName();
		//which method to call and how?
		String input = patronMenu();
		while(!(input.equals("g")))
		{
			
			if(input.equals("a"))  //#27
			{
				//how to determine which account type the user wants?
				System.out.println("Which account type did you want?");
				accountTypeMenu();
				String account = scan.nextLine();
				
				System.out.println("Please input the interest rate");
				double rate = scan.nextDouble();
				
				scan.nextLine();//DEBUG
				
				AccountType type = AccountType.Checking;
				
				if(account.equals("a"))
					type = AccountType.Checking;
				else if(account.equals("b"))
					type = AccountType.Savings;
				else if(account.equals("c"))
					type = AccountType.CD;
				else if(account.equals("d"))
					type = AccountType.MoneyMarket;
				else if(account.equals("e"))
					type = AccountType.IRA;
				
				
				
				boolean result = a.addAccount(rate, type);
				if(result==false)
				{
					System.out.println("Account has been failed to be created");
				}
				else
					System.out.println("Account successfully added!");
				
			}
			else if(input.equals("b"))   //#28
			{
				System.out.println("Please enter account number");
				int account = scan.nextInt();
				//how to remove an account from patron?
				scan.nextLine();
				boolean result = a.remove(account);
				if(result==true)
				{
					System.out.println("Success");
				}
				else
					System.out.println("failed");
			}
			else if(input.equals("c"))  //#29
			{
				a.givePaycheck();   
				//System.out.println("Paycheck done");
			}
			else if(input.equals("d"))  //#30
			{
				BankAccount acct1=a.specificAccount(1);
				BankAccount acct2=a.specificAccount(2);
				
				if(acct1!=null)
				{
					acct1.applyInterest();
					
				}
				if(acct2!=null)
				{
					acct2.applyInterest();
				}
				if(acct1==null && acct2==null) {
				System.out.println("No accounts available");}
				//else
					//System.out.println("Success");
			}
			else if(input.equals("e"))  //#31
			{
				System.out.println("Which account would you like to make a deposit in?");
				int account = scan.nextInt();
				System.out.println("Please enter the amount you would like to deposit");
				double deposit = scan.nextDouble();
				scan.nextLine();
				
				BankAccount z = a.specificAccount(account);
				if(z!=null)
				{
					boolean result = a.addToAccount(deposit, z);
					if(result==true)
					{
						System.out.println("Deposit successfully made!");
					}
					else
						System.out.println("Patron does not have enough cash on hand!");
				}
				else
					System.out.println("No bank account");
				
			}
			else if(input.equals("f"))  //#32
			{
				System.out.println("Which account would you like to make a withdrawal from?");
				int account = scan.nextInt();
				System.out.println("Please enter the amount you would like to withdraw");
				double withdraw = scan.nextDouble();
				
				BankAccount z = a.specificAccount(account);
				if(z!=null)
				{
					boolean result = a.withdrawMoney(withdraw, z);
					if(result==true)
					{
						System.out.println("Success");
					}
					else
						System.out.println("Failed");
				}
				else
					System.out.println("No bank account");
				//how to check if account exists and remove the withdraw from the account?
			}
	
			System.out.println("What do you want to do with " + name);
			input = patronMenu();
		}
	}
	
	public static void main(String[] args)   
	{
		System.out.println("Welcome to the CSE 110 Bank!");  //#33
		String input = printList();
		while(!(input.equals("e")))
		{
			if(input.equals("a"))  //#34
			{
				System.out.println("Patrons currently at the bank: ");
				boolean patronExists = false;
				
				for(int i = 0; i<=4; i++)
				{
					BankPatron p = obj.givePatron(i);
					if(p!=null)
					{
						patronExists = true;
						String s = obj.printPatron(p);
						System.out.println(s);
					}
				}
				if(patronExists == false)
				{
					System.out.println("There are none");
				}
				
			}
			else if(input.equals("b"))  //#35
			{
				System.out.println("What is the first name of the patron?");
				String first = scan.nextLine();
				System.out.println("What is the last name of the patron?");
				String last = scan.nextLine();
				System.out.println("What is their yearly salary?");
				double salary = scan.nextDouble();
				System.out.println("How much cash do they have on hand?");
				double cash = scan.nextDouble();
				scan.nextLine();
				BankPatron y = new BankPatron(first, last, salary, cash);
				boolean ans = obj.addPatron(y);
				if(ans)
				{
					//obj.addPatron(y);
					System.out.println("Welcome to the bank, " + first);
				}
				else
				{
					System.out.println("The line at the bank is already full!");
				}
				
				
			}
			else if(input.equals("c"))  //#36
			{
				System.out.println("Type the full name of the patron you want");
				String full = scan.nextLine();
				BankPatron pat = obj.givePatronName(full);
				if(pat!=null) 
				{
					obj.removePatron(pat);
					System.out.println(full + " has left the bank.");
				}
				else
				{
					System.out.println("There is no patron by that name.");
				}
			}
			else if(input.equals("d"))  //#37
			{
				System.out.println("Type the full name of the patron you want");
				String name = scan.nextLine();
				System.out.println("What do you want to do with " + name);
				BankPatron x = obj.givePatronName(name);
				
				if(x==null)
				{
					System.out.println("The patron does not exist");
				}
				else
				{
					patronSpecificMenu(x);
				}
				
			}
			
			input = printList();
			
		}
		System.out.println("Thank you for coming.");
	}
}
