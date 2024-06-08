package com.thread;

import java.net.NoRouteToHostException;

public class HDFCBank {

	double acctBal;
	
	public HDFCBank(double acctBal) {
		this.acctBal=acctBal;
	}
	
	synchronized public void withdraw(double withdrawalAmt) {
		System.out.println("Before HDFCBank.withdraw() Balance : "+this.acctBal );
		acctBal=acctBal-withdrawalAmt;
		System.out.println("After HDFCBank.withdraw() Balance : "+this.acctBal );
	}
	
	synchronized public void deposit(double depositedAmt) {
		System.out.println(" Before HDFCBank.deposit() Balance : "+this.acctBal);
		acctBal=acctBal+depositedAmt;
		System.out.println(" After HDFCBank.deposit() Balance : "+this.acctBal);
	}
	
	synchronized public void checkBalance() {
		System.out.println("HDFCBank.checkBalance()");
		System.out.println("Balance is "+this.acctBal);
	}

	public void profileUpdate() {
		System.out.println("HDFCBank.profileUpdate()");
	}
}
