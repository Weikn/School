package com.aweikn;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test005 {

	public static void main(String[] args) {
		//核心线程数1 最大线程数2  
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(3));
		//任务1 已经创建线程执行了
		threadPoolExecutor.execute(new TaskThread("mythread1"));
		//任务2 存放队列中缓存
		threadPoolExecutor.execute(new TaskThread("mythread2"));
		//任务3 存放队列中缓存
		threadPoolExecutor.execute(new TaskThread("mythread3"));
		//任务4 存放队列中缓存
		threadPoolExecutor.execute(new TaskThread("mythread4"));
		//任务5 存放队列中缓存
		threadPoolExecutor.execute(new TaskThread("mythread5"));
		//任务1 已经创建线程执行了
		threadPoolExecutor.execute(new TaskThread("mythread6"));
		//任务2 存放队列中缓存
//		threadPoolExecutor.execute(new TaskThread("mythread7"));
		//任务3 存放队列中缓存
//		threadPoolExecutor.execute(new TaskThread("mythread8"));
		//任务4 存放队列中缓存
//		threadPoolExecutor.execute(new TaskThread("mythread9"));
		//任务5 存放队列中缓存
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