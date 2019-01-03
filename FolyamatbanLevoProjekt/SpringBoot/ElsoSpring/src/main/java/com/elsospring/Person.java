package com.elsospring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "person") // itt adjuk meg az app.prop-ben lévő dolgot, amire figyelnie kell
@Component
public class Person {
	
	
	
	private int age;
	private String firstName;
	private String lastName;
	private String telephoneNumber;

	public Person() {

	}

	public Person(int age, String firstName, String lastName, String telephoneNumber) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + ", telephoneNumber="
				+ telephoneNumber + "]";
	}
	
	

}
