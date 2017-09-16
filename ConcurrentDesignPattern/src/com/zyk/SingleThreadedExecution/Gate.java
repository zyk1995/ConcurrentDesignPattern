package com.zyk.SingleThreadedExecution;

public class Gate {
	   private int counter = 0;
	   private String name = "Nobody";
	   private String address = "Nowhere";
	   
	   public synchronized void pass(String name, String address) {
		// TODO Auto-generated method stub
		   this.counter++;
		   this.name = name;
		   this.address = address;
		   check();
	   }
	  	   
	   @Override
	   public synchronized String toString() {
		   return "Gate [counter=" + counter + ", name=" + name + ", address=" + address + "]";
	   }

	   private void check() {
		// TODO Auto-generated method stub
		   if(name.charAt(0) != address.charAt(0)) {
			   System.out.println("***** BROKEN" + toString());
		   }
	   }
	}
