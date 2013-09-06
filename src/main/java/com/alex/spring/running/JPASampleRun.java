package com.alex.spring.running;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.jpa.entity.Contact;
import com.alex.spring.jpa.service.ContactService;

public class JPASampleRun {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jpa/app-context.xml");
		ctx.refresh();
		
		ContactService service = ctx.getBean("jpaContactService", ContactService.class);
		
		List<Contact> list = service.findAll();
		
	}

}
