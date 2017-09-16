package com.zyk.SingleThreadedExecution;

public class UserThread extends Thread {
	private final Gate gate;
	private final String myname;
	private final String myaddress;
	
	public UserThread(Gate gate, String myname, String myadress) {
		// TODO Auto-generated constructor stub
		this.gate = gate;
		this.myname = myname;
		this.myaddress = myadress;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(myname + " BEGIN"); 
		while(true) {
			gate.pass(myname, myaddress);
		}
	}
}
