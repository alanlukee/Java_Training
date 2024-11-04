package com.multiThreading;

public class DeadLock implements Runnable {

	A a=new A();
	B b=new B();
	
	DeadLock()
	{
		Thread t=new Thread(this);
		t.start();
		a.foo(b);//main thread
	}
	
	public void run()
	{
		b.bar(a);//child thread
	}
	
	
	public static void main(String[] args)
	{
	new DeadLock();//main thread

}
}
