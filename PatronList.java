
public class PatronList 
{
	//#14 - what five instance variables?
	private BankPatron patron1;
	private BankPatron patron2;
	private BankPatron patron3;
	private BankPatron patron4;
	private BankPatron patron5;
	
	public PatronList()  //#15
	{
		//which instance variables to set to null?
		patron1 = null;
		patron2 = null;
		patron3 = null;
		patron4 = null;
		patron5 = null;
	}
	
	public boolean addPatron(BankPatron patron)  //#16
	{
		if(patron1==null)
		{
			patron1=patron;
			return true;
		}
		else if(patron2==null)
		{
			patron2=patron;
			return true;
		}
		else if(patron3==null)
		{
			patron3=patron;
			return true;
		}
		else if(patron4==null)
		{
			patron4=patron;
			return true;
		}
		else if(patron5==null)
		{
			patron5=patron;
			return true;
		}
		else
			return false;
	}
	//#17 - how to overload the method??
	public boolean addPatron(String first, String last, double salary, double cash)
	{
		if(patron1.equals(null))
		{
			patron1 = new BankPatron(first, last, salary, cash);
			return true;
		}
		else if(patron2.equals(null))
		{
			patron2=new BankPatron(first, last, salary, cash);
			return true;
		}
		else if(patron3.equals(null))
		{
			patron3=new BankPatron(first, last, salary, cash);
			return true;
		}
		else if(patron4.equals(null))
		{
			patron4=new BankPatron(first, last, salary, cash);
			return true;
		}
		else if(patron5.equals(null))
		{
			patron5=new BankPatron(first, last, salary, cash);
			return true;
		}
		else
			return false;
	}
	
	public BankPatron givePatron(int num)  //#18
	{
		if(num==0)
		{
			if(patron1==null)
			{
				return null;
			}
			else
			{
				return patron1;
			}
		}
		else if(num==1)
		{
			if(patron2==null)
			{
				return null;
			}
			else
			{
				return patron2;
			}
		}
		else if(num==2)
		{
			if(patron3==null)
			{
				return null;
			}
			else
			{
				return patron3;
			}
		}
		else if(num==3)
		{
			if(patron4==null)
			{
				return null;
			}
			else
			{
				return patron4;
			}
		}
		else if(num==4)
		{
			if(patron5==null)
			{
				return null;
			}
			else
			{
				return patron5;
			}
		}
		else
		{
			return null;
		}
	}
	
	public BankPatron givePatronName(String fullName)  //#19
	{
		if(patron1 != null && fullName.equals(patron1.getFullName()))
		{ 
			return patron1; 
		} 
		else if(patron2 != null &&fullName.equals(patron2.getFullName()))
		{ 
			return patron2; 
		} 
		else if(patron3 != null &&fullName.equals(patron3.getFullName()))
		{
			return patron3; 
		} 
		else if(patron4 != null && fullName.equals(patron4.getFullName()))
		{ 
			return patron4; 
		} 
		else if(patron5 != null &&fullName.equals(patron5.getFullName()))
		{ 
			return patron5; 
		} 
		else
			return null;
	}
	
	public void removePatron(BankPatron patron)  //#20
	{
		if(patron.equals(patron1))
		{
			patron1=null;
		}
		if(patron.equals(patron2))
		{
			patron2=null;
		}
		if(patron.equals(patron3))
		{
			patron3=null;
		}
		if(patron.equals(patron4))
		{
			patron4=null;
		}
		if(patron.equals(patron5))
		{
			patron5=null;
		}
		
	}
	public String printPatron(BankPatron patron)
	{
		String returnString = "";
		String name = patron.getFullName();
		returnString = returnString+ " " + name;
		if(patron.specificAccount(1)!=null || patron.specificAccount(2)!=null)
		{
			AccountType accountType1 = patron.specificAccount(1).getType();
			int number = patron.specificAccount(1).getAccountNum();
			double balance = patron.specificAccount(1).checkBalance();
			double rate = patron.specificAccount(1).getRate();
			String ans1 = accountType1 + " " + number + " Balance: " + balance + " Interest Rate: " + rate;
			returnString+=ans1;
			if(patron.specificAccount(2)!=null)
			{
				AccountType accountType2 = patron.specificAccount(2).getType();
				int number2 = patron.specificAccount(2).getAccountNum();
				double balance2 = patron.specificAccount(2).checkBalance();
				double rate2 = patron.specificAccount(2).getRate();
				String ans2 = accountType2 + " " + number2 + " Balance: " + balance2 + " Interest Rate: " + rate2;
				returnString+=ans2;
			}
		}
		return returnString;
	}
}
