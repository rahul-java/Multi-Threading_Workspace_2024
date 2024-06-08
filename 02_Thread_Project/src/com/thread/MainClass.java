package com.thread;

public class MainClass {

	public static void main(String[] args) {
		
		HDFCBank rahulBankAcct = new HDFCBank(7000.0);
		
		ATMThread atmThread = new ATMThread(rahulBankAcct);
		atmThread.setName("ATM-Thread");
		
		GPayThread gPayThread = new GPayThread(rahulBankAcct);
		gPayThread.setName("GPay-Thread");
		
		PhonePeThread phonePeThread = new PhonePeThread(rahulBankAcct);
		phonePeThread.setName("PhonePe-Thread");
		
		atmThread.start();
		gPayThread.start();
		phonePeThread.start();
	}
}
