package com.itcy.postgresql.model;

import lombok.Data;

@Data
public class User {
	public User(String name, String age, int height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	private String name;
	private String age;
	private int height;
	// setter、getter方法我就不写了
}

