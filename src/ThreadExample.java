import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadExample implements Runnable {

	String str;
	static Class cs = ThreadExample.class;

	@Override
	public void run() {
		// disp1();
		synchronized (this) {
			for (int i = 0; i < 10; i++) {

				try {
					System.out.print(": " + Thread.currentThread().getName());
					notifyAll();
					wait();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String arge[]) throws ClassNotFoundException {
		// cs = Class.forName("ThreadExample");
		ThreadExample th1 = new ThreadExample();
		ThreadExample th2 = new ThreadExample();

		Thread t1 = new Thread(th1);
		Thread t2 = new Thread(th1);

		t1.setName("ping");
		t2.setName("pong");
		t1.start();
		t2.start();

	}
}
