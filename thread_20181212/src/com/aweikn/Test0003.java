package com.aweikn;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test0003 {
	public static void main(String[] args) {
		//可以定时执行的线程池
	   ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
	   
	   for (int i = 0; i < 10; i++) {
			final int temp =i;
			//启动线程
			newScheduledThreadPool.schedule(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + temp);
				}
				
			}, 5, TimeUnit.SECONDS);
			
		}
	}
}
