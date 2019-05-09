package com.aweikn;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Test0001 {

	public static void main(String[] args) {
		//非阻塞式队列  无界队列
		ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue();
				
		concurrentLinkedQueue.offer("0安排");
		concurrentLinkedQueue.offer("1安排");
		concurrentLinkedQueue.offer("2安排");
		
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.size());

	}
}
