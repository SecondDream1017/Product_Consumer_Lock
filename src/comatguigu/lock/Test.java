package comatguigu.lock;

public class Test {

	public static void main(String[] args) {
		Resource r = new Resource();
		Product p = new Product(r);
		Consumer c = new Consumer(r);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(c);
		Thread t4 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
