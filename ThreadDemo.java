package learningJava;

///------------ LECTURE 5---------------------
/// Thread Priorities and Thread Name
public class ThreadDemo {
	public static void main(String args[]) throws Exception {
		
		Thread t1 = new Thread(() -> {
		for(int i = 0; i < 5; i++) {
				System.out.println("Hi " + Thread.currentThread().getPriority());
				try { Thread.sleep(1000); } catch (Exception e) { System.out.println(e);}
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("Hello " + Thread.currentThread().getId());
				try { Thread.sleep(1000); } catch (Exception e) { System.out.println(e);}
			}
		});

		t1.setName("Hi Thread");
		System.out.println(t1.getName());

		t2.setName("Hello Thread");
		System.out.println(t2.getName());
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		
		t1.start();
		try { Thread.sleep(10); } catch (Exception e) {System.out.println(e);}
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Bye");
	}
}

/// ------------ LECTURE 4 --------------------
/*
 * public class ThreadDemo { public static void main(String args[]) throws
 * Exception { Thread t1 = new Thread(() -> { for(int i = 0; i < 5; ++i) {
 * System.out.println("Hi");
 * 
 * try { Thread.sleep(1000);} catch(Exception e) { System.out.println(e);} } });
 * Thread t2 = new Thread(() -> { for(int i = 0; i < 5; ++i) {
 * System.out.println("Hello");
 * 
 * try { Thread.sleep(1000);} catch(Exception e) { System.out.println(e);} } });
 * t1.start(); try { Thread.sleep(10);} catch(Exception e) {
 * System.out.println(e);} t2.start();
 * 
 * /// this implies to wait the main thread for thread t1 to finish t1.join();
 * 
 * /// this implies to wait the main thread for thread t2 to finish t2.join();
 * 
 * /// When both threads t1 and t2 will finish their jobs then statements ///
 * further will be executed.
 * 
 * /// similarly a function is t1.isAlive() or t2.isAlive() this checks ///
 * weather a thread is in current state of execution or the thread has ///
 * finished its execution.
 * 
 * System.out.println("Bye"); } }
 */


///  ----------- LECTURE 3 -------------
//public class ThreadDemo {
//	public static void main(String args[]) {
//		Thread t1 = new Thread(() -> {
//			for(int i = 0; i < 5; ++i) {
//				System.out.println("Hi");
//				try { Thread.sleep(1000); } catch(Exception e ) {System.out.println(e);}
//			}
//		});
//		Thread t2 = new Thread(() -> {
//			for(int i = 0; i < 5; ++i) {
//				System.out.println("Hello");
//				try { Thread.sleep(1000); } catch(Exception e ) {System.out.println(e);}
//			}
//		});
//		t1.start();
//		try { Thread.sleep(10); } catch(Exception e) {System.out.println(e);}
//		t2.start();
//	}
//}

///  ----------- LECTURE 2 -------------
//
//
//
//class Hi implements Runnable {
//	public void run() {
//		for(int i = 0; i < 5; ++i) {
//			System.out.println("Hi");
//			try { Thread.sleep(10); } catch(Exception e ) {System.out.println(e);}
//		}
//	}
//}
//class Hello implements Runnable {
//	public void run() {
//		for(int i = 0; i < 5; ++i) {
//			System.out.println("Hello");
//			try { Thread.sleep(1000); } catch(Exception e ) {System.out.println(e);}
//		}
//	}
//}
//
//public class ThreadDemo {
//	public static void main(String args[]) {
//		
//		Runnable obj1 = new Hi();
//		Runnable obj2 = new Hello();
//		
//		Thread t1 = new Thread(obj1);
//		Thread t2 = new Thread(obj2);
//		
//		
//		t1.start();
//		try { Thread.sleep(10); } catch(Exception e) {System.out.println(e);}
//		t2.start();
//		
//		
//	}
//}
//
//

///  ----------- LECTURE 1 -------------

///// Here we are extending the Thread class and thus we cannot 
///// use multiple inheritance.
///// in order to use multiple inheritance we must use interfaces.
//
///// Interface used for MultiThreading is Runnable Interface.
///// Runnable interface also requires the run() method.
//class Hi extends Thread {
//	public void run () {
//		for(int i = 0; i < 5; ++i) {
//			System.out.println("Hi");
//			try { Thread.sleep(500); } catch(Exception e) { System.out.println(e);}
//		}
//	}
//}
//
//
///// Here we are extending the Thread class and thus we cannot 
///// use multiple inheritance.
///// in order to use multiple inheritance we must use interfaces.
//
///// Interface used for MultiThreading is Runnable Interface.
///// Runnable interface also requires the run() method.
//class Hello extends Thread{
//	public void run () {
//		for(int i = 0; i < 5; ++i) {
//			System.out.println("Hello");
//			try { Thread.sleep(500); } catch(Exception e) { System.out.println(e);}
//		}
//	}
//}
//
//
//public class ThreadDemo {
//	public static void main(String args[]) {
//		Hi obj1 = new Hi();
//		Hello obj2 = new Hello();
//
//		/// Starting one thread. Thread by default looks for a run() method
//		/// therefore in order to use a thread you must implement a run menthod
//		/// in your thread class
//		obj1.start();	
//	
//		/**
//		 *
//		 * this try catch ensures that both the threads will reach the
//		 * system task schedulers at different time, so that the order of
//		 * execution will be maintained, because this ensures that there is no 
//		 * random selection of threads by the schedulers.
//		 *
//		 */
//		try { Thread.sleep(10);} catch(Exception e) { System.out.println(e); }
//
//		/// Starting one thread. Thread by default looks for a run() method
//		/// therefore in order to use a thread you must implement a run menthod
//		/// in your thread class
//		obj2.start(); 
//	}
//}
