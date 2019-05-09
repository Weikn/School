package com.aweikn;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test005 {

	public static void main(String[] args) {
		//�����߳���1 ����߳���2  
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(3));
		//����1 �Ѿ������߳�ִ����
		threadPoolExecutor.execute(new TaskThread("mythread1"));
		//����2 ��Ŷ����л���
		threadPoolExecutor.execute(new TaskThread("mythread2"));
		//����3 ��Ŷ����л���
		threadPoolExecutor.execute(new TaskThread("mythread3"));
		//����4 ��Ŷ����л���
		threadPoolExecutor.execute(new TaskThread("mythread4"));
		//����5 ��Ŷ����л���
		threadPoolExecutor.execute(new TaskThread("mythread5"));
		//����1 �Ѿ������߳�ִ����
		threadPoolExecutor.execute(new TaskThread("mythread6"));
		//����2 ��Ŷ����л���
//		threadPoolExecutor.execute(new TaskThread("mythread7"));
		//����3 ��Ŷ����л���
//		threadPoolExecutor.execute(new TaskThread("mythread8"));
		//����4 ��Ŷ����л���
//		threadPoolExecutor.execute(new TaskThread("mythread9"));
		//����5 ��Ŷ����л���
//		threadPoolExecutor.execute(new TaskThread("mythread10"));
	}
	
}

class TaskThread implements Runnable {
	
	private String  threadName;
	
	public TaskThread(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() +  threadName);
	}
} 