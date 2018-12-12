package com.cdac.threading;

/*
 * 1) First we saw how to create Threads in Java and assign task to them
 * using Runnable interface.
 * 2) Then we saw how we can set the priority for Threads
 * 3) Then we saw how to use sleep method
 * 4) Then we saw how to use yield method
 * 
 */
public class Example1 {

	class Task1 implements Runnable {

		@Override
		public void run() {
			for(int i=0;i<100000000;i++) {
				System.out.println("i is : " +i);
				//try { Thread.sleep(1); } catch(InterruptedException e) { }
				//Thread.yield();
			}
		}
	}

	class Task2 implements Runnable {

		@Override
		public void run() {
			for(int j=0;j<100000000;j++) {
				System.out.println("j is : " +j);
				//try { Thread.sleep(1); } catch(InterruptedException e) { }
				//Thread.yield();
			}
		}		
	}
	
	void launch() {
		Task1 task1 = new Task1();
		Thread th1 = new Thread(task1);
		//th1.setPriority(1); //between 1 & 10, 5 is normal
		//th1.setPriority(Thread.MIN_PRIORITY);
		
		Task2 task2 = new Task2();
		Thread th2 = new Thread(task2);
		//th2.setPriority(10);
		
		th1.start();
		th2.start();
	}

	public static void main(String[] args) {
		new Example1().launch();
	}
}
