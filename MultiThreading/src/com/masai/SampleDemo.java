package com.masai;

public class SampleDemo implements Runnable {

	private Thread t;
	
	private String threadName;
	
	public SampleDemo(String threadName) {
		this.threadName = threadName;
	}
	
	public SampleDemo(Thread t,String threadName) {
		this.t = t;
		this.threadName = threadName;
	}
	
	
	@Override
	public void run() {
		while(true) {
			System.out.println(threadName);
		}
		
	}
	
	

}
