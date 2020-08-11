package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Hobby {

	@Id
	@GeneratedValue
	private int hobbyId;
	private String hobbyName;

	@ManyToMany(mappedBy = "hobbies")
	private Set<Person> persons = new HashSet<Person>();

	public int getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
}
