package com.alex.spring.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@NamedQueries({
	@NamedQuery(name = "Contact.findAll",
			query= "select t from Contact t"),
	@NamedQuery(name = "Contact.findById",
			query = "select distinct c from Contact c left join fetch c.contactTelDetail t"
	+ " left join fetch c.hobbies h where c.id = :id"),
	@NamedQuery(name = "Contact.findAllWithDetail",
				query = "select distinct c from Contact c left join fetch c.contactTelDetail t"
		+ " left join fetch c.hobbies h")

})
public class Contact implements Serializable {

	/* Serial for */
	private static final long serialVersionUID = 7919352528771979752L;

	private Long id = -1l;
	private int version;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Set<ContactTelDetail> contactTelDetail = new HashSet<ContactTelDetail>(
			3);
	private Set<Hobby> hobbies = new HashSet<Hobby>();

	public Contact() {
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
	 * @param version
	 *            the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthDate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the contactTelDetail
	 */
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<ContactTelDetail> getContactTelDetail() {
		return contactTelDetail;
	}

	/**
	 * @param contactTelDetail
	 *            the contactTelDetail to set
	 */
	public void setContactTelDetail(Set<ContactTelDetail> contactTelDetail) {
		this.contactTelDetail = contactTelDetail;
	}

	public void addContactTelDetail(ContactTelDetail contactTelDetail) {
		contactTelDetail.setContact(this);
		this.contactTelDetail.add(contactTelDetail);
	}

	public void removeContactTelDetail(ContactTelDetail contactTelDetail) {
		this.contactTelDetail.remove(contactTelDetail);
	}

	/**
	 * @return the hobbies
	 */
	@ManyToMany
	@JoinTable(name = "contact_hobby_detail", joinColumns = @JoinColumn(name = "contact_id"), inverseJoinColumns = @JoinColumn(name = "hobby_id"))
	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies
	 *            the hobbies to set
	 */
	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthDate=" + birthDate + "]";
	}

}
