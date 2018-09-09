package comatguigu.lock;

public class Product implements Runnable{

	private Resource resource;
	public Product(Resource resource) {
		super();
		this.resource = resource;
	}

	public void run() {
		while(true){
			try {
				resource.set("面包");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}


