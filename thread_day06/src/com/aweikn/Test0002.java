package com.aweikn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test0002 {
	
	public static void main(String[] args) throws Exception {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
		blockingQueue.offer("������ʱ 1");
		boolean b1 = blockingQueue.offer("2����", 3, TimeUnit.SECONDS);
		System.out.println(b1);
		blockingQueue.offer("������ʱ 3");
		boolean offer = blockingQueue.offer("��4����ʱ",3, TimeUnit.SECONDS);
		System.out.println(offer);
//		System.out.println(blockingQueue.poll());
//		System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
//		System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
		
	}
}
