package com.test.spring.lang.impl;

import com.test.spring.lang.Language;

public class Vietnamese implements Language {

	public String getGreeting() {
		return "Xin Chao";
	}

	public String getBye() {
		return "Tam Biet";
	}

}