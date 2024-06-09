package com.thread;

import java.net.NoRouteToHostException;

public class HDFCBank {

	static double acctBal=7000.0;
		
	synchronized public static void withdraw(double withdrawalAmt) {
		System.out.println("Before HDFCBank.withdraw() Balance : "+acctBal );
		acctBal=acctBal-withdrawalAmt;
		System.out.println("After HDFCBank.withdraw() Balance : "+acctBal );
	}
	
	synchronized public static void deposit(double depositedAmt) {
		System.out.println(" Before HDFCBank.deposit() Balance : "+acctBal);
		acctBal=acctBal+depositedAmt;
		System.out.println(" After HDFCBank.deposit() Balance : "+acctBal);
	}
	
	synchronized public static void checkBalance() {
		System.out.println("HDFCBank.checkBalance()");
		System.out.println("Balance is "+acctBal);
	}

	public static void  profileUpdate() {
		System.out.println("HDFCBank.profileUpdate()");
	}
}
