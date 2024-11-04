package com.multiThreading;

public class A {
	public synchronized void foo(B b) {
		
		System.out.println("thread -1 starts the execution of foo() method.");
		try {
			Thread.sleep(2000);
			
		}
		catch(InterruptedException e) {
			
		}
		System.out.println("thread-1 trying to call b.last()");
		b.last();
	}
	
	public synchronized void last() {
		System.out.println("inside -A this is last() method");
	}

}
