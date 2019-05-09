package com.aweikn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test0002 {
	public static void main(String[] args) {
		
		//可固定长度的线程池
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int temp =i;
			//启动线程
			newFixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + temp);
				}

			});
		}
	}
	
}
