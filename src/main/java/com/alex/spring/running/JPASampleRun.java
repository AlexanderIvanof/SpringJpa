package com.alex.spring.running;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.jpa.entity.*;
import com.alex.spring.jpa.service.ContactService;

public class JPASampleRun {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jpa/app-context.xml");
		ctx.refresh();
		
		ContactService service = ctx.getBean("jpaContactService", ContactService.class);
		
//		List<Contact> list = service.findAllWithDetail();
		Contact contact = service.findbyId(4l);
		
//		for (Contact contact : list) {
			System.out.println(contact);
			if(contact.getContactTelDetail() != null){
				for(ContactTelDetail det : contact.getContactTelDetail()){
					System.out.println(">>>>" + det);
				}
			}
			
			if(contact.getHobbies() != null){
				for(Hobby hb : contact.getHobbies()){
					System.out.println(">>>>>>>" + hb);
				}
			}
//		}
	}

}
