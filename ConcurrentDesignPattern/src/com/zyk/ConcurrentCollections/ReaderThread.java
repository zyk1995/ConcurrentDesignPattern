package com.zyk.ConcurrentCollections;

import java.util.List;

public class ReaderThread extends Thread {
	private final List<Integer> list;

	public ReaderThread(List<Integer> list) {
		super();
		
		this.list = list;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized (list) {
				for(int n : list) {
					System.out.println(n);
				}				
			}
		}
	}
}
