package com.masai;

import java.util.Arrays;

public class Demo extends Thread {
	@Override
	public void run() {
		for (int i=0; i<3; i++) {
			System.out.println("Inside of the thread..");
		}
	}
	
	public static void main(String[] args) {
		Demo d = new Demo();
		d.start();
	}
}
