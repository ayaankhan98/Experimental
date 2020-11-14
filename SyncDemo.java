package learningJava;
class Counter {
	int count;
	
	Counter() {
		this.count = 0;
	}
	
	/// The synchronized keyword will ensure that this method will
	/// be executed by only one thread at a time
	public synchronized void increment() {
		this.count++;  // count = count + 1;
	}
}
public class SyncDemo {
	public static void main(String args[]) throws Exception {
		Counter c = new Counter();
		Thread t1 = new Thread(new Runnable () {
			public void run() {
				for(int i = 0; i < 1000; ++i) {
					c.increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable () {
			public void run() {
				for(int i = 0; i < 1000; ++i) {
					c.increment();
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("count: " + c.count);
	}
}