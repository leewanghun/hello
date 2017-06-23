package com.test.spring.lang.impl;

import com.test.spring.lang.Language;

public class English implements Language {

	public String getGreeting() {
		return "Hello";
	}

	public String getBye() {
		return "Bye bye";
	}

}