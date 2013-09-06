package com.alex.spring.jpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Hobby implements Serializable {

	/* Srial for Hobby */
	private static final long serialVersionUID = -5305602348027375188L;

	private String hobbyId;
	private Set<Contact> contacts = new HashSet<Contact>();
	
	public Hobby() {
	}

	/**
	 * @return the hobbyId
	 */
	@Id
	@Column(name = "hobby_id")
	public String getHobbyId() {
		return hobbyId;
	}

	/**
	 * @param hobbyId the hobbyId to set
	 */
	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	
	
	/**
	 * @return the contacts
	 */
	@ManyToMany
	@JoinTable(name = "contact_hobby_detail",
			joinColumns = @JoinColumn(name = "hobby_id"),
			inverseJoinColumns = @JoinColumn(name = "contact_id"))
	public Set<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hobby: [" + hobbyId + "]";
	}
	
}
