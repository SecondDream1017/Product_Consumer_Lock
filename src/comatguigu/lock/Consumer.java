package comatguigu.lock;

public class Consumer implements Runnable{

	private Resource resource;
	public Consumer(Resource resource) {
		super();
		this.resource = resource;
	}

	public void run() {
		while(true){
			try {
				resource.con();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
