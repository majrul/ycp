package com.cdac.basics.interfaces;

interface Printer {
	void print(String document);
}

class DotMatrixPrinter implements Printer {
	@Override
	public void print(String document) {
		System.out.println(document + " printed..");
	}
}

public class ExampleOnInnerClassesandLambdas {

	//inner class
	class InkjetPrinter implements Printer {
		@Override
		public void print(String document) {
			System.out.println(document + " printed..");
		}
	}
	
	public static void main(String[] args) {
		//inner class
		class LaserPrinter implements Printer {
			@Override
			public void print(String document) {
				System.out.println(document + " printed..");
			}
		}
		Printer p = new LaserPrinter();
		p.print("abc.txt");
		
		//anonymous inner class
		Printer sp = new Printer() {
			@Override
			public void print(String document) {
				System.out.println(document + " printed..");
			}
		};
		sp.print("abc.txt");
		
		//lambda expressions
		//lambda expressions are nothing but anonymous inner classes
		//in other words
		//also we can say lambda expressions are anonymous functions
		
		/*Printer pr = (String document) ->  {
			System.out.println(document + " printed..");
		};
		pr.print("abc.txt");*/
		
		/*Printer pr = (document) ->  {
			System.out.println(document + " printed..");
		};
		pr.print("abc.txt");*/
		
		/*Printer pr = (d) ->  {
			System.out.println(d + " printed..");
		};
		pr.print("abc.txt");*/
		
		Printer pr = doc -> System.out.println(doc + " printed..");
		pr.print("abc.txt");
	}

}
