package com.java.domian;

public class Person {
	private Integer person_id;
	private User person_user = new User();
	private String person_name;
	private String person_num;
	public Person() {
		
	}
	public Person(Integer person_id, User person_user, String person_name, String person_num) {
		this.person_id = person_id;
		this.person_user = person_user;
		this.person_name = person_name;
		this.person_num = person_num;
	}

	public Integer getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}

	public User getPerson_user() {
		return person_user;
	}

	public void setPerson_user(User person_user) {
		this.person_user = person_user;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getPerson_num() {
		return person_num;
	}

	public void setPerson_num(String person_num) {
		this.person_num = person_num;
	}
	
}
