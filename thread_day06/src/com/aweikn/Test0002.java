package com.aweikn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test0002 {
	
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
		blockingQueue.offer("非阻塞时 1");
		boolean b1 = blockingQueue.offer("2李四", 3, TimeUnit.SECONDS);
		System.out.println(b1);
		blockingQueue.offer("非丽丽时 3");
		boolean offer = blockingQueue.offer("非4阻塞时",3, TimeUnit.SECONDS);
		System.out.println(offer);
//		System.out.println(blockingQueue.poll());
//		System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
//		System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
		
	}
}
