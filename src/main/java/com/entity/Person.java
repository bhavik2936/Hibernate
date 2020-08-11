package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Person {

	@Id
	@GeneratedValue
	private int personId;
	private String personName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Person_Hobby", joinColumns = {
			@JoinColumn(columnDefinition = "personId") }, inverseJoinColumns = {
					@JoinColumn(columnDefinition = "hobbyId") })
	private Set<Hobby> hobbies = new HashSet<Hobby>();

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
}
