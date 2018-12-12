package com.cdac.threading;

/*
 * In this example, primarily we revised the concept of
 * inner classses along with anonymous inner classes and lambda
 */
public class Example2 {

	public static void main(String[] args) {
		//regular inner class implementing Runnable interface
		class Task1 implements Runnable {

			@Override
			public void run() {
				for(int i=0;i<100000000;i++)
					System.out.println("i is : " +i);
			}
		}

		class Task2 implements Runnable {

			@Override
			public void run() {
				for(int j=0;j<100000000;j++)
					System.out.println("j is : " +j);
			}		
		}
		
		//anonymous inner class implementing Runnable interface
		Runnable task3 = new Runnable() {
			
			@Override
			public void run() {
				for(int k=0;k<100000000;k++)
					System.out.println("k is : " +k);
			}
		};
		
		//lambda style implementation of Runnable interface
		Runnable task4 = () -> {
			for(int l=0;l<100000000;l++)
				System.out.println("l is : " +l);
		};
		
		Thread th4 = new Thread(task4);
		th4.start();
		
		Thread th3 = new Thread(task3);
		th3.start();
		
		Task1 task1 = new Task1();
		Thread th1 = new Thread(task1);
		
		Task2 task2 = new Task2();
		Thread th2 = new Thread(task2);
		
		th1.start();
		th2.start();
	

	}
}
