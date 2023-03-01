package com.masai;

public class Main {
	
	public static void main(String[] args) {
		int mask = 0x000F;
		
		int value = 0x2222;
		
		System.out.println(mask & value);
	}
}
