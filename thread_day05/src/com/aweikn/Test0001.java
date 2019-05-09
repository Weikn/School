package com.aweikn;


//�������
class Res {
	public String name;
	
	public String sex;
	//Ϊtrue  ���������д
	//Ϊfalse ����д���ܶ�
	public volatile boolean flag = false;
	
}
//������   ��Ҫд�빫������
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
						res.wait();//�ͷŵ�ǰ������
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if (count == 0) {
					res.name = "С��";
					res.sex = "Ů";
				} else {
					res.name = "С��";
					res.sex = "��";
				}
				count = (count + 1) % 2;
				res.flag = true;//��ǵ�ǰ�߳�Ϊ�ȴ�
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
				res.notify();	//���ѱ��ȴ����߳�
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
