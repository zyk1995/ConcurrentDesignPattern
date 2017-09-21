package com.zyk.immutable;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person alice = new Person("Alice", "Alaska");
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
	}

}
