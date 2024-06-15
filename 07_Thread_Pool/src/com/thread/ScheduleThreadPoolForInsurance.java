package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolForInsurance {

	public static void main(String[] args) throws Exception, ExecutionException {
		
		Customer customer1 = new Customer("Rahul", "LIC-12345",5000.0);
		Customer customer2 = new Customer("Rohit", "LIC-12346",50000.0);
		Customer customer3 = new Customer("Amit", "LIC-12347",15000.0);
		Customer customer4 = new Customer("Amrit", "LIC-12348",25000.0);
		Customer customer5 = new Customer("Vivek", "LIC-12349",55000.0);
		Customer customer6 = new Customer("Vishnu", "LIC-12350",35000.0);
		Customer customer7 = new Customer("Manish", "LIC-12351",10000.0);
		Customer customer8 = new Customer("Mritunjay", "LIC-12352",65000.0);
		Customer customer9 = new Customer("Kavi", "LIC-12353",1000.0);
		Customer customer10 = new Customer("Kailash", "LIC-12354",55000.0);
		
		List<Customer> custList=new ArrayList<Customer>();
		custList.add(customer1);
		custList.add(customer2);
		custList.add(customer3);
		custList.add(customer4);
		custList.add(customer5);
		custList.add(customer6);
		custList.add(customer7);
		custList.add(customer8);
		custList.add(customer9);
		custList.add(customer10);
		
		//ExecutorService ex = Executors.newFixedThreadPool(3);
		//ExecutorService ex = Executors.newCachedThreadPool();
		//ExecutorService ex = Executors.newSingleThreadExecutor();
		
		ScheduledExecutorService ex = Executors.newScheduledThreadPool(3);
		
		//List list=new ArrayList();
		List<ScheduledFuture<Object>> list=new ArrayList<ScheduledFuture<Object>>();
		for(int i=0;i<custList.size();i++)
		{
			//Using Runnable
			/*TriggerEmailForPolicy triggerEmailForPolicy = new TriggerEmailForPolicy(custList.get(i));
			ex.execute(triggerEmailForPolicy);*/
			
			//Using Callable
			/*TriggerEmailForPolicyCallable triggerEmailForPolicyCallable = new TriggerEmailForPolicyCallable(custList.get(i));
			Future<Object> future = ex.submit(triggerEmailForPolicyCallable);
			//list.add(future);
			Customer c=(Customer) future.get();
			System.out.println(c);*/
			
			TriggerEmailForPolicyCallable triggerEmailForPolicyCallable = new TriggerEmailForPolicyCallable(custList.get(i));
			ScheduledFuture<Object> scheduledFuture = ex.schedule(triggerEmailForPolicyCallable, 2, TimeUnit.MINUTES);
			list.add(scheduledFuture);
			Customer c = (Customer)scheduledFuture.get();
			System.out.println(c);
			
			/*TriggerEmailForPolicy triggerEmailForPolicy = new TriggerEmailForPolicy(custList.get(i));
			ex.scheduleAtFixedRate(triggerEmailForPolicy, 1, 3, TimeUnit.SECONDS);
			*/
		}
		
		System.out.println("=====================================================================");
		
		for(int i=0;i<list.size();i++) {
			ScheduledFuture<Object> scheduled = list.get(i);
			//Customer cust = (Customer)scheduled.get(); //get method provide you blocking operation
			//System.out.println(cust);
			
			if(scheduled.isDone()) {
				try {
					Customer cust = (Customer)scheduled.get();
					System.out.println(cust);
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		
		ex.shutdown();
	}
}
