package com.Java.Collections.day7;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

	private static List<Account> list=new ArrayList<>();
	
	public void addAccount(Account account) {
        list.add(account);
    }
	
	boolean isValidAccount(Account account) throws Exception
	{
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).accno == account.accno)
			{
				return true;
			}
		}
		throw new Exception("Account Not Found Exception");
	}

	void deposit(float amt,int accno) throws Exception{

		if(amt < 0)
		{
			throw new Exception("Invalid Ammount Exception");
		}
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).accno == accno)
			{
				float bal=list.get(i).getBalance();
				list.get(i).setBalance(bal+amt);
			}
		}
	}

	void withdraw(float amt,int accno) throws Exception{
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).accno == accno)
			{
				float bal=list.get(i).getBalance();
				
				if(bal < 500)
				{
					throw new Exception("Insufficient Funds Exception");
				}
				
				list.get(i).setBalance(bal-amt);
			}
		}
		
	}

	float getBalance(int accno) {
		
		float bal=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).accno == accno)
			{
				bal=list.get(i).getBalance();
				
				break;
			}
		}
		return bal;
	}
}
