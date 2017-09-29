package com.zyk.ConcurrentCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		final List<Integer> list = new CopyOnWriteArrayList<Integer>(); //写时复制
		new WriterThread(list).start();
		new ReaderThread(list).start();
	}

}
