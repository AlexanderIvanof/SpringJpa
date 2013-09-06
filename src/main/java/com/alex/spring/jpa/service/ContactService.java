package com.alex.spring.jpa.service;

import java.util.List;

import com.alex.spring.jpa.entity.Contact;

public interface ContactService {

	public List<Contact> findAll();

	public List<Contact> findAllWithDetail();

	public Contact findbyId(Long id);

	public Contact save(Contact contact);

	public void delete(Contact contact);
}
