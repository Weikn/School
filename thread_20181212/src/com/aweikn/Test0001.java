package com.aweikn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test0001 {
	public static void main(String[] args) {
		//�ɻ�����̳߳� �ظ�����  ���޴�С
		ExecutorService  newCachedTreadPool =  Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int temp =i;
			//�����߳�
			newCachedTreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + temp);
				}

			});
		}
		
	}
}
