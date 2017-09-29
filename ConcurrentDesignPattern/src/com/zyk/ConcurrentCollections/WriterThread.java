package com.zyk.ConcurrentCollections;

import java.util.List;

public class WriterThread extends Thread {
	private final List<Integer> list;

	public WriterThread(List<Integer> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; true; i++) {
			list.add(i);
			list.remove(0);
		}
	}
	
}
