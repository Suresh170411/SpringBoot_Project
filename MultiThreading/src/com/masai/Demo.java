package com.masai;

public class Demo implements Runnable{

	@Override
	public void run() {
		System.out.println("INside of default thread..");
	}
	
	public static void main(String[] args) {
		
		Demo d = new Demo();
		
		Thread t = new Thread(d);
		
		t.start();
	}
}
