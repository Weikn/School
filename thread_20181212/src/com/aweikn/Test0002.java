package com.aweikn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test0002 {
	public static void main(String[] args) {
		
		//�ɹ̶����ȵ��̳߳�
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int temp =i;
			//�����߳�
			newFixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + temp);
				}

			});
		}
	}
	
}
