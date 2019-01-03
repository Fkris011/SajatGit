package com.elsospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@EnableConfigurationProperties
@SpringBootApplication
public class ElsoSpringApplication {
	
	

	public static void main(String[] args) {
		ApplicationContext ct = SpringApplication.run(ElsoSpringApplication.class, args);
		System.out.println(ct.getBean("person"));
//
//		String[] beanArray = ct.getBeanDefinitionNames();
//
//		Arrays.sort(beanArray);
//
//		for (String name : beanArray) {
//			System.out.println(name);
//		} 
	}

}
