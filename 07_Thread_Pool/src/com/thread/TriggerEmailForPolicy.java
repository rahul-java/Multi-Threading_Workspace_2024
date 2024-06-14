package com.thread;

public class TriggerEmailForPolicy implements Runnable {

	private Customer customer;
	
	public TriggerEmailForPolicy(Customer cust) {
		this.customer=cust;
	}
	
	@Override
	public void run() {

		triggerEmail(customer);
	}
	
	public static void triggerEmail(Customer cust) {
		System.err.println("===============Triggering email to all person...=================="+Thread.currentThread().getName());
		StringBuffer msg=new StringBuffer();
		msg.append("Hi "+cust.customerName);
		msg.append(" for Policy Number "+cust.policyNumber+" premium is due");
		msg.append(" And Premium Amount is "+cust.premium);
		msg.append(" Please py before the due date to avoid late charges.");
		//call the java mail api to trigger email
		System.out.println(msg);
		
	}

	
}
