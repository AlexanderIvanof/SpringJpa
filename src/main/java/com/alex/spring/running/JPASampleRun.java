package com.alex.spring.running;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.jpa.entity.*;
import com.alex.spring.jpa.service.ContactInformationService;
import com.alex.spring.jpa.service.ContactService;

public class JPASampleRun {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jpa/app-context.xml");
		ctx.refresh();
		
		ContactService service = ctx.getBean("jpaContactService", ContactService.class);
		
		callDelete(service);
		
		List<Contact> list = service.findAllWithDetail();
//		Contact contact = service.findbyId(4l);
//		
		for (Contact contact : list) {
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
		}
		
//		ContactInformationService serv = ctx.getBean("info", ContactInformationService.class);
//		serv.displayContactsWithWorkNumber();
	}
	
	@SuppressWarnings("unused")
	private static void callInsert(ContactService contactSrv){
		Contact rid = new Contact();
		rid.setFirstName("Martyn");
		rid.setLastName("Fuller");
		rid.setBirthDate(new Date(new GregorianCalendar(1977, 11, 25).getTimeInMillis()));
		
		ContactTelDetail telDet = new ContactTelDetail("Home", "(04343)23-44-22");
		ContactTelDetail telDet2 = new ContactTelDetail("Work", "(044)999-32-79");
		
		rid.addContactTelDetail(telDet);
		rid.addContactTelDetail(telDet2);
		
		contactSrv.save(rid);
	}
	
	@SuppressWarnings("unused")
	private static void callUpdate(ContactService contactSrv){
		Contact tom = new Contact();
		tom.setId(7l);
		tom.setFirstName("Tina");
		tom.setLastName("Turner");
		tom.setBirthDate(new Date(new GregorianCalendar(1960, 10, 10).getTimeInMillis()));
		
		contactSrv.save(tom);
	}
	
	@SuppressWarnings("unused")
	private static void callDelete(ContactService contactSrv){
		Contact rid = contactSrv.findbyId(8l);
		contactSrv.delete(rid);
	}

}
