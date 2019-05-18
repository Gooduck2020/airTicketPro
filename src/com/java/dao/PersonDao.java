package com.java.dao;

import java.util.List;

import com.java.domian.Person;

public interface PersonDao {

	public List<Person> searchPerson();

	public void addPerson(Person person);

	public void commtiPerson(Person person);

}
