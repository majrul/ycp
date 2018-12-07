package com.cdac.basics;

public class Stringham {

	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = "Java";
		
		String s3 = new String("Java");
		String s4 = new String("Java");
		
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		
		String s5 = "JAVA";
		//String s6 = s1.toUpperCase();
		String s6 = s1.toUpperCase().intern();
		System.out.println(s5 == s6);
		
		//int i = "999999999"; //4b
		
		//major concern with String is String concatenation
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String newStr = "";
		
		long ns1 = System.nanoTime();
		for(int i=0;i<str.length();i++)
			for(int j=0;j<=i;j++)
				newStr = newStr + str.charAt(j);
		long ns2 = System.nanoTime();
		
		System.out.println(newStr);
		System.out.println("Approx time : " + (ns2-ns1) + " ns");
		
		StringBuffer sb = new StringBuffer();
		ns1 = System.nanoTime();
		for(int i=0;i<str.length();i++)
			for(int j=0;j<=i;j++)
				sb.append(str.charAt(j));
		ns2 = System.nanoTime();
		
		System.out.println(sb);
		System.out.println("Approx time : " + (ns2-ns1) + " ns");

		StringBuilder sb2 = new StringBuilder();
		ns1 = System.nanoTime();
		for(int i=0;i<str.length();i++)
			for(int j=0;j<=i;j++)
				sb2.append(str.charAt(j));
		ns2 = System.nanoTime();
		
		System.out.println(sb2);
		System.out.println("Approx time : " + (ns2-ns1) + " ns");

	}
}






