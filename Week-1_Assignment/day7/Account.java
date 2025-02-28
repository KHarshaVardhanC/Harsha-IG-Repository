package com.Java.Collections.day7;

public class Account {

	
	int accno;
	String custname;
	String acctype;
	float balance;
	public Account(int accno, String custname, String acctype, float balance) {
		super();
		this.accno = accno;
		this.custname = custname;
		this.acctype = acctype;
		this.balance = balance;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
}
