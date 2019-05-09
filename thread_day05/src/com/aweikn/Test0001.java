package com.aweikn;


//共享对象
class Res {
	public String name;
	
	public String sex;
	//为true  允许读不能写
	//为false 允许写不能读
	public volatile boolean flag = false;
	
}
//生产者   主要写入公共数据
class IntThread extends Thread{
	public Res res;
	
	public  IntThread(Res res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		int count = 0 ;
		while(true) {
			synchronized (res) {
				
				if (res.flag) {
					try {
						res.wait();//释放当前锁对象
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if (count == 0) {
					res.name = "小宏";
					res.sex = "女";
				} else {
					res.name = "小军";
					res.sex = "男";
				}
				count = (count + 1) % 2;
				res.flag = true;//标记当前线程为等待
				res.notify();
			}
		}
	}
}

class OutThread extends Thread{
	
	public Res res;
	
	public  OutThread(Res res) {
		this.res = res;
	}
	
	
	public void run() {
		while(true) {
			synchronized (res) {
				if(!res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(res.name + "," + res.sex);
				
				res.flag = false;
				res.notify();	//唤醒被等待的线程
			}
		}
	}
}

public class Test0001 {
	
	public static void main(String[] args) {
		Res res	= new Res();
		IntThread in   = new  IntThread(res);
		OutThread out  = new  OutThread(res);
		
		in.start();
		out.start();
		
		
	}
	
}
