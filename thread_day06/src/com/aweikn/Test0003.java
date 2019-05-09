package com.aweikn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
   * 通过消息队列实现 生产消费
 * 
 * */


//生产队列  入列
class ProducerThread implements Runnable{
	private  BlockingQueue<String>  blockingQueue;
	
	private volatile boolean FLAG = true;
	
	private AtomicInteger atomicInteger = new AtomicInteger();
	
	public ProducerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	public void run() {
		try {
			System.out.println("生产者已经启动");
			while (FLAG) {
				String data = atomicInteger.incrementAndGet() + "";

				boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
				if (offer) {
					System.out.println("成功入列");
				} else {
					System.out.println("生产者入列失败 data :" + data);
				}
				Thread.sleep(1000);
			} 
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			System.out.println("生产者已经结束。。。。");
		}
	}
	
	
	public void  stop () {
		this.FLAG = false;
	}
	
}



//消费者队列  出列
class ConsumerThread implements Runnable{
	private  BlockingQueue<String>  blockingQueue;
	
	private volatile boolean FLAG = true;
	
	public ConsumerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		System.out.println("消费者已经启动。。");
		try {
			while (FLAG) {
				String data = blockingQueue.poll(2, TimeUnit.SECONDS);
				if (null == data ) {
					System.out.println("超过两秒 没有队列信息");
					FLAG =false;
					return ;
				}
				System.out.println("消费者出列  data ：" + data);
			} 
		} 
		catch (Exception e) {
		}
		finally {
			System.out.println("消费者已经结束。。");
		}
	}
}


public class Test0003 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>(10);
		ProducerThread producerThread = new ProducerThread(linkedBlockingQueue);
		ConsumerThread consumerThread = new ConsumerThread(linkedBlockingQueue);
		
		new Thread(producerThread).start();
		
		new Thread(consumerThread).start();
		//等待10
		Thread.sleep(1000 * 10);
		
		producerThread.stop();
		
	}
}
