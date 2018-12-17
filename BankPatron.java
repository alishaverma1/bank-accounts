
public class BankPatron 
{
	private String firstName;
	private String lastName;
	private double salary;
	private double cashOnHand;
	BankAccount bankacct1 = new BankAccount();
	BankAccount bankacct2 = new BankAccount();
	 
	public BankPatron()
	{
		firstName = "";
		lastName = "";
		salary = 0.0;
		cashOnHand = 0.0;
		bankacct1 = null;
		bankacct2 = null;
	}
	public BankPatron(String firstNm, String lastNm, double sal, double cash)
	{
		firstName = firstNm;
		lastName = lastNm;
		salary = sal;
		cashOnHand = cash;
		bankacct1 = null;
		bankacct2 = null;
	}
	public String getFullName()    //#6
	{
		return (firstName + " " + lastName);
	}
	public double getSalary()     //#7
	{
		return salary;
	}
	public double getCashOnHand()
	{
		return cashOnHand;
	}
	public void givePaycheck()   //#8
	{
		double moneyPerWeek = salary/52;
		double paycheck = moneyPerWeek*2;
		cashOnHand = cashOnHand + paycheck;
	}
	public BankAccount specificAccount(int account)   //#9
	{ 
		if(account == 1)
		{
			if(bankacct1!=null)
			{
				return bankacct1;
			}
			else
				return null;
		}
		else if(account==2)
		{
			if(bankacct2!=null)
			{
				return bankacct2;
			}
			else
				return null;
		}
		else
			return null;
		
	}
	public boolean addToAccount(double deposit, BankAccount bankacct)   //#10
	{
		if(bankacct.equals(bankacct1))
		{
			if(deposit<=cashOnHand)
			{
				bankacct1.deposit(deposit);  
				return true;
			}
			else
			{
				return false;
			}
		}
		if(bankacct.equals(bankacct2))
		{
			if(deposit<=cashOnHand)
			{
				bankacct2.deposit(deposit);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
			return false;
	}
	public boolean withdrawMoney(double amount, BankAccount bankacct) //#11
	{
		if(bankacct.equals(bankacct1))
		{
			bankacct1.withdraw(amount); 
			cashOnHand+=amount; 
			return true;
		}
		if(bankacct.equals(bankacct2))
		{
			bankacct2.withdraw(amount);
			cashOnHand+=amount;
			return true;
		}
		else
			return false;
	}
	public boolean addAccount(double interestRate, AccountType type)   //#12
	{
		if(bankacct1==null)
		{
			BankAccount bankaccttemp = new BankAccount();
			bankaccttemp.setRate(interestRate);
			bankacct1=bankaccttemp;
			return true;
		}
		else if(bankacct2==null)
		{
			//same thing as before w account 2
			BankAccount bankaccttemp = new BankAccount();
			bankaccttemp.setRate(interestRate);
			bankacct2=bankaccttemp;
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean remove(int accountnum) //#13
	{
		if(accountnum==1)
		{
			if(bankacct1!=null)
			{
				bankacct1=null;
				return true;
			}
			else
				return false;
		}
		if(accountnum==2)
		{
			//same thing w account 2
			if(bankacct2!=null)
			{
				bankacct2=null;
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}
