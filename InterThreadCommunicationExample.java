public class InterThreadCommunicationExample {
	public static void main(String[] args) {
		Chat m = new Chat();
		new T1(m);
		new T2(m);
	}
}

class Chat {
	boolean flag = false;

	public synchronized void FromSam(String msg) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
	}

	public synchronized void FromJam(String msg) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(msg);
		flag = false;
		notify();
	}
}

class T1 implements Runnable {
	Chat m;
	String[] s1 = { "Hello Jam", "How are you ?", "I am also doing fine!", "test" };

	public T1(Chat m1) {
		this.m = m1;
		new Thread(this, "Sam").start();
	}

	public void run() {
		for (int i = 0; i < s1.length; i++) {
			m.FromSam(s1[i]);
		}
	}
}

class T2 implements Runnable {
	Chat m;
	String[] s2 = { "HI Sam", "I am good,And U ?", "ha haa", "fshjkdfhskj" };

	public T2(Chat m2) {
		this.m = m2;
		new Thread(this, "Jam").start();
	}

	public void run() {
		for (int i = 0; i < s2.length; i++) {
			m.FromJam(s2[i]);
		}
	}
}