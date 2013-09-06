package com.alex.spring.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.spring.jpa.entity.Contact;

@Service("jpaContactService")// like @Component
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	private Log log = LogFactory.getLog(ContactServiceImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllWithDetail() {
		return em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findbyId(Long id) {
		TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Contact save(Contact contact) {
		return null;
	}

	@Override
	public void delete(Contact contact) {

	}

}
