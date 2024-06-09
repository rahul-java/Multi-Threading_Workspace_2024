package com.thread;

public class MainClass {

	public static void main(String[] args) {
		
		HDFCBank rahulBankAcct = new HDFCBank(7000.0);
		HDFCBank abcBankAcct = new HDFCBank(6000.0);
		
		
		ATMThread atmThread = new ATMThread(rahulBankAcct);
		ATMThread atm1Thread = new ATMThread(rahulBankAcct);
		ATMThread abcThread = new ATMThread(abcBankAcct);
		atmThread.setName("ATM-Thread");
		atm1Thread.setName("ATM-1-Thread");
		abcThread.setName("ABC-ATM-Thread");
		
		GPayThread gPayThread = new GPayThread(rahulBankAcct);
		gPayThread.setName("GPay-Thread");
		
		PhonePeThread phonePeThread = new PhonePeThread(rahulBankAcct);
		phonePeThread.setName("PhonePe-Thread");
		
		NetBankingThread netBankingThread = new NetBankingThread(rahulBankAcct);
		phonePeThread.setName("PhonePe-Thread");
		
		atmThread.start();
		atm1Thread.start();
		abcThread.start();
		gPayThread.start();
		//phonePeThread.start();
		//netBankingThread.start();
	}
}
