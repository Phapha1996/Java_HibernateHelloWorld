package org.fage.test;

import java.util.Date;

import org.fage.domain.IndentityCard;
import org.fage.domain.Person;
import org.fage.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCRUDOnetoOne {
	
	@BeforeClass
	public static void before(){
		
	}
	
	@AfterClass
	public static void after(){
		
	}

	
	@Test
	public void testSaveOneWay(){
		
		//目前单向，cascade设置为all，主从关系，身份证里面有一个人的对象
		
		Person person = new Person();
		person.setName("蔡智法");
		person.setBirthday(new Date());
		IndentityCard card = new IndentityCard();
		card.setNumber(4508);
		card.setAddress("柳州市");
		card.setPerson(person);
		
		//SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		//factory.close();
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		//session.save(person);
		session.save(card);
		session.getTransaction().commit();
		factory.close();
		
		
		//测试结果：保存一个身份证会把那个人一起存，存人不会存身份证g
		
		
		
	}
	
	
	
	@Test
	public void testDeleteOneWay(){
		//目前单向，cascade设置为all，主从关系，身份证里面有一个人的对象
	/*	IndentityCard card = new IndentityCard();
		card.setId(3);*/
		Person person = new Person();
		person.setId(4);
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.delete(person);
		session.getTransaction().commit();
		factory.close();
		//测试结果：能删除一个card，但是删除身份证只会删除身份证，不级联；删除person删除不了
	}
	
	
	
	
	@Test
	public void testLoadUpdateOneWay(){
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		IndentityCard card = session.load(IndentityCard.class,5);
		card.getPerson().setName("梁媛");
		card.setNumber(4500);
		session.getTransaction().commit();
		factory.close();
		
	}
	
	
	@Test
	public void testGetOneWay(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		IndentityCard card = session.get(IndentityCard.class,5);
		session.getTransaction().commit();
		factory.close();
		System.out.println(card.getNumber()+card.getAddress()+card.getPerson().getName());
	}
	
	
	@Test
	public void testGetTwiceWay(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Person p = session.get(Person.class, 5);
		session.getTransaction().commit();
		factory.close();
		System.out.println(p.getName()+p.getCard().getNumber()+p.getCard().getAddress());
		
	}
	
}
