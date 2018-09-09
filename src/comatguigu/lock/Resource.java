package comatguigu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

	private String name;
	private static int count=1;
	private boolean flag=false;//代表盘子里没有东西,要生产
	//定义一个锁对象。
	private final Lock l = new ReentrantLock();

	private Condition product = l.newCondition();//负责生产。
	private Condition consume = l.newCondition();//负责消费。
	
	//生产
	public void set(String name) throws InterruptedException{
		l.lock();
		try {
			if(flag==false){
				this.name=name+count;
				count++;
				System.out.println(Thread.currentThread().getName()+"...生产."+this.name);
				flag=true;
				consume.signal();
			}else{
				product.await();
			}
		}finally{
			l.unlock();
		}
		
	}
	
	//消费
	public void con() throws InterruptedException{
		l.lock();
		try {
			if(flag==true){
				System.out.println(Thread.currentThread().getName()+".消费..."+this.name);
				flag=false;
				product.signal();
			}else{
				consume.await();
			}
		}finally{
			l.unlock();
		}
		
	}
	
	
}
