package com.aweikn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
   * ͨ����Ϣ����ʵ�� ��������
 * 
 * */


//��������  ����
class ProducerThread implements Runnable{
	private  BlockingQueue<String>  blockingQueue;
	
	private volatile boolean FLAG = true;
	
	private AtomicInteger atomicInteger = new AtomicInteger();
	
	public ProducerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	public void run() {
		try {
			System.out.println("�������Ѿ�����");
			while (FLAG) {
				String data = atomicInteger.incrementAndGet() + "";

				boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
				if (offer) {
					System.out.println("�ɹ�����");
				} else {
					System.out.println("����������ʧ�� data :" + data);
				}
				Thread.sleep(1000);
			} 
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			System.out.println("�������Ѿ�������������");
		}
	}
	
	
	public void  stop () {
		this.FLAG = false;
	}
	
}



//�����߶���  ����
class ConsumerThread implements Runnable{
	private  BlockingQueue<String>  blockingQueue;
	
	private volatile boolean FLAG = true;
	
	public ConsumerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run() {
		System.out.println("�������Ѿ���������");
		try {
			while (FLAG) {
				String data = blockingQueue.poll(2, TimeUnit.SECONDS);
				if (null == data ) {
					System.out.println("�������� û�ж�����Ϣ");
					FLAG =false;
					return ;
				}
				System.out.println("�����߳���  data ��" + data);
			} 
		} 
		catch (Exception e) {
		}
		finally {
			System.out.println("�������Ѿ���������");
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
		//�ȴ�10
		Thread.sleep(1000 * 10);
		
		producerThread.stop();
		
	}
}
