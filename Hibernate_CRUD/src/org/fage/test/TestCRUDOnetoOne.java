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
		
		//Ŀǰ����cascade����Ϊall�����ӹ�ϵ�����֤������һ���˵Ķ���
		
		Person person = new Person();
		person.setName("���Ƿ�");
		person.setBirthday(new Date());
		IndentityCard card = new IndentityCard();
		card.setNumber(4508);
		card.setAddress("������");
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
		
		
		//���Խ��������һ�����֤����Ǹ���һ��棬���˲�������֤g
		
		
		
	}
	
	
	
	@Test
	public void testDeleteOneWay(){
		//Ŀǰ����cascade����Ϊall�����ӹ�ϵ�����֤������һ���˵Ķ���
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
		//���Խ������ɾ��һ��card������ɾ�����ֻ֤��ɾ�����֤����������ɾ��personɾ������
	}
	
	
	
	
	@Test
	public void testLoadUpdateOneWay(){
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		IndentityCard card = session.load(IndentityCard.class,5);
		card.getPerson().setName("����");
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
