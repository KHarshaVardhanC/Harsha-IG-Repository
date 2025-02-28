package com.Java.Collections.day7;

import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args)  throws Exception{
		
		Scanner sc=new Scanner(System.in);
		AccountService as=new AccountService();
		
		as.addAccount(new Account(123, "Harsha", "Current", 5000));
		while(true)
		{
			System.out.println("----------- Welcome ---------");
			System.out.println("1. Add Account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Check balance");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			
			int ch=sc.nextInt();
			if(ch == 1)
			{
				System.out.println("Enter Name: ");
				String Name=sc.next();
				System.out.println("Enter Account Number: ");
				int accno=sc.nextInt();
				System.out.println("Enter Account Type Savings/ Current: ");
				String acctype=sc.next();
				float bal=1000;
				if(acctype.equals("Current"))
				{
					bal=5000;
				}
				
				as.addAccount(new Account(accno, Name, acctype, bal));
				
				
			}
			else if(ch == 2)
			{
				System.out.println("Enter Account Number: ");
				int accno=sc.nextInt();
				System.out.println("Enter Amount: ");
				float bal=sc.nextFloat();
				as.deposit(bal, accno);
			}
			else if(ch == 3)
			{
				System.out.println("Enter Account Number: ");
				int accno=sc.nextInt();
				System.out.println("Enter Amount: ");
				float bal=sc.nextFloat();
				as.withdraw(bal, accno);
			}
			else if(ch == 4)
			{
				System.out.println("Enter Account Number: ");
				int accno=sc.nextInt();
				float bal=as.getBalance(accno);
				
				System.out.println("Your account Balance is : "+bal+" Rupees.");
			}
			else
			{
				break;
			}
			
			
		}
	}
}
