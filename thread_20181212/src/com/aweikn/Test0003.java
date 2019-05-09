package com.aweikn;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test0003 {
	public static void main(String[] args) {
		//���Զ�ʱִ�е��̳߳�
	   ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
	   
	   for (int i = 0; i < 10; i++) {
			final int temp =i;
			//�����߳�
			newScheduledThreadPool.schedule(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + temp);
				}
				
			}, 5, TimeUnit.SECONDS);
			
		}
	}
}
