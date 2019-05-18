package com.java.test;

public class Test2 {
	final static int N = 2;
	final static int M = N+1;
	final static int NUM = (M+1)*M/2;
	public static void main(String[] args) {
		int i, n = 0;
		for( i = 1 ; i <= NUM ; i++ ) {
			n++;
			System.out.print(n);
		}
		System.out.println();
		return;
	}
}
