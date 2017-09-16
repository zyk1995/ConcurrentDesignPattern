package com.zyk.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Log{
	public static void println(String s) {
		System.out.println(Thread.currentThread().getName() + ":" + s);
	}
}

//资源个数有限
class BoundedResource{
	private final Semaphore semaphore;//计数信号量
	private final int permits;
	private final static Random random = new Random(314159);
	
	//构造函数（permit为资源个数）
	public BoundedResource(int permits) {
		// TODO Auto-generated constructor stub
		this.semaphore = new Semaphore(permits);
		this.permits = permits;
	}
	
	//使用资源
	public void use() throws InterruptedException {
		// TODO Auto-generated method stub
		semaphore.acquire();
		try {
			doUse();
		} finally {
			// TODO: handle finally clause
			semaphore.release();
		}
	}
	
	//实际使用资源（此处仅使用Thread.sleep)
	protected void doUse() throws InterruptedException {
		Log.println("BEGIN: used = " + (permits - semaphore.availablePermits()));
		Thread.sleep(random.nextInt(500));
		Log.println("END: used = " + (permits - semaphore.availablePermits()));
	}
}

//使用资源的线程
class UserThread extends Thread {
	private final static Random random = new Random(26535);
	private final BoundedResource resource;
	
	public UserThread(BoundedResource resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true) {
				resource.use();
				Thread.sleep(random.nextInt(3000));
			}
		} catch (InterruptedException e) {
			
		}
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设置3个资源
		BoundedResource resource = new BoundedResource(3);
		//10个线程使用资源
		for(int i = 0; i < 10; i++) {
			new UserThread(resource).start();
		}
	}

}
