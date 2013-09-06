package com.alex.spring.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable {

	/* Serial version */
	private static final long serialVersionUID = 3157166092667882644L;

	private Long id;
	private int version;
	private String telType;
	private String telNumber;
	private Contact contact;

	public ContactTelDetail() {
	}
	
	public ContactTelDetail(String telType, String telNumber) {
		super();
		this.telType = telType;
		this.telNumber = telNumber;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	@Version
	@Column(name = "version")
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the telType
	 */
	@Column(name = "tel_type")
	public String getTelType() {
		return telType;
	}

	/**
	 * @param telType the telType to set
	 */
	public void setTelType(String telType) {
		this.telType = telType;
	}

	/**
	 * @return the telNumber
	 */
	@Column(name = "tel_number")
	public String getTelNumber() {
		return telNumber;
	}

	/**
	 * @param telNumber the telNumber to set
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	/**
	 * @return the contact
	 */
	@ManyToOne
	@JoinColumn(name = "contact_id")
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact Tel Detail [id=" + id + ", telType: " + telType
				+ ", telNumber: " + telNumber + "] " + contact;
	}
	
	
}
