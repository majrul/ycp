package com.cdac.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.HelloWorld;

public class TestIoC {

	public static void main(String[] args) {
		//Loading the IoC container of Spring
		ApplicationContext context =
			    new ClassPathXmlApplicationContext("app-config.xml");
		
		HelloWorld h = (HelloWorld) context.getBean("hw"); //id
		System.out.println(h.sayHello("Majrul"));
	}
}
