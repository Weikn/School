package com.aweikn;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Test0001 {

	public static void main(String[] args) {
		//������ʽ����  �޽����
		ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue();
				
		concurrentLinkedQueue.offer("0����");
		concurrentLinkedQueue.offer("1����");
		concurrentLinkedQueue.offer("2����");
		
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.size());

	}
}
