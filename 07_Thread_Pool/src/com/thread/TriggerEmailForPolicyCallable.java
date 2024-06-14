package com.thread;

import java.util.concurrent.Callable;

public class TriggerEmailForPolicyCallable implements Callable<Object> {

	private Customer customer;
	
	public TriggerEmailForPolicyCallable(Customer cust) {
		this.customer=cust;
	}
	
	@Override
	public Object call() throws Exception {
		
		return triggerEmail(customer);
	}
	
	public static Object triggerEmail(Customer cust) {
		System.err.println("===============Triggering email to all person...=================="+Thread.currentThread().getName());
		StringBuffer msg=new StringBuffer();
		msg.append("Hi "+cust.customerName);
		msg.append(" for Policy Number "+cust.policyNumber+" premium is due");
		msg.append(" And Premium Amount is "+cust.premium);
		msg.append(" Please py before the due date to avoid late charges.");
		//call the java mail api to trigger email
		//System.out.println(msg);
		cust.setMessage(msg.toString());
		
		return cust;
	}

	

	
}
