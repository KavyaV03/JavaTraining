package com.dal;

interface Additionn {
	public int add(int a, int b);
	public int sum(int a, int b);
}

public class Java8eg {

	public static void main(String[] args) {
		Additionn  sum=(a,b)->{
			return a+b;
		};
		System.out.println(sum.add(8, 1));
	}

}
