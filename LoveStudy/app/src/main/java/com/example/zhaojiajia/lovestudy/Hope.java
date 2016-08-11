package com.example.zhaojiajia.lovestudy;

public class Hope {
	private int id;
	private String userName;
	private String sex;
	private int age;
	private String message;
	private String userImg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public Hope(int id, String userName, String sex, int age, String message, String userImg) {
		super();
		this.id = id;
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.message = message;
		this.userImg = userImg;
	}

	public Hope() {
		super();
	}

}