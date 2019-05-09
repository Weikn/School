package com.aweikn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test0004 {
	public static void main(String[] args) {
		//单例线程池 
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int temp =i;
			//启动线程
			newSingleThreadExecutor.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + temp);
				}
				
			});
			
		}
		newSingleThreadExecutor.shutdown();
	}
}
