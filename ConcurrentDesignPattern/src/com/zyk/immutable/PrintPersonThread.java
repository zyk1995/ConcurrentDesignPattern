package com.zyk.immutable;

public class PrintPersonThread extends Thread {
	private Person person;
	
	
	public PrintPersonThread(Person person) {
		super();
		this.person = person;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println(Thread.currentThread().getName() + " prints " + person);
		}
	}
}
