package com.aweikn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test0001 {
	public static void main(String[] args) {
		//可缓存的线程池 重复利用  无限大小
		ExecutorService  newCachedTreadPool =  Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int temp =i;
			//启动线程
			newCachedTreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + temp);
				}

			});
		}
		
	}
}
