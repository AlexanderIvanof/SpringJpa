package com.alex.spring.jpa.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("info")
@Repository
@Transactional
@SuppressWarnings({"rawtypes", "unchecked"})
public class ContactInformationService {
	
	private Log log = LogFactory.getLog(ContactServiceImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	public void displayContactsWithWorkNumber(){
		List list = em.createQuery("select c.firstName, c.lastName, t.telNumber " +
				"from Contact c left join c.contactTelDetail t " +
				"where t.telType = 'Work'").getResultList();
		int count = 0;
		for(Iterator<Object[]> i = list.iterator(); i.hasNext();){
			Object[] values = (Object[])i.next();
			String str = ++count + ": " + values[0] + ", " + values[1] + " work tel. " + values[2]; 
			log.info(str);
		}
	}
}
