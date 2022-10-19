package com.userdata.user.model;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String mobile;
	private int age;
	private boolean deleted;
	
	public User() {
		
	}
	
	public User(int id, String name, String email, String mobile, int age, boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.deleted = deleted;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleated(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
	  return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", age=" + age + ", deleted=" + deleted + "]";
	}
	
	
}
