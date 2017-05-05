package org.fage.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.fage.domain.Department;
import org.fage.domain.Employee;
import org.fage.utils.SessionFactoryUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;



public class TestCRUD_OnetoMany {
	
	
	@Test
	public void testAdd1(){
		
		/*Employee e1 = new Employee();
		e1.setName("���Ƿ�");
		e1.setComdate(new Date());
		
		Department d = new Department();
		d.setName("���������");
		e1.setDepartment(d)
		e2.setDepartment(d);*/
		Employee e2 = new Employee();
		e2.setName("����");
		e2.setComdate(new Date());
		Department d = new Department();
		d.setName("���������");
		e2.setDepartment(d);
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
//		session.save(e1);
		
		session.save(e2);
		session.getTransaction().commit();;
		session.close();
		factory.close();
	}
	
	
	@Test
	public void testAdd2(){
		
		Employee e1 = new Employee();
		e1.setName("���Ƿ�");
		e1.setComdate(new Date());
		Employee e2 = new Employee();
		e2.setName("����");
		e2.setComdate(new Date());
		Department d = new Department();
		d.setName("���������");
		e1.setDepartment(d);
		e2.setDepartment(d);
		
		Set<Employee> set = new HashSet<Employee>();
		set.add(e1);
		set.add(e2);
		d.setEmployees(set);
		
		
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();;
		session.close();
		factory.close();
	}
	
	@Test
	public void testLoad1(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employee e = session.load(Employee.class, 26);
		System.out.println(e.getName()+e.getDepartment().getName());
		session.getTransaction().commit();;
		session.close();
		factory.close();
	}
	
	@Test
	public void testLoad2(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Department d = session.load(Department.class, 18);
		System.out.println(d.getName()+d.getEmployees().size()+"����");
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	@Test
	public void testDelete1(){
		//��ֻ��ɾ��һ��Employee��Hibernateȫ��������ɾ����- -,�����Ƚ���˼���
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employee e = session.load(Employee.class, 28);
		e.setDepartment(null);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	@Test
	public void testDelete2(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Department d = session.load(Department.class, 19);
		session.delete(d);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	@Test
	public void update(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Department d = session.load(Department.class, 21);
		Employee e = session.load(Employee.class, 30);
		e.setDepartment(d);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	
/*	@Test
	public void updateHQL(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		factory.close();
	}*/
	
	@Test
	public void testGet(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Department d = session.get(Department.class, 20);
		/*System.out.println(d.getEmployees());*/
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	
	@Test
	public void testQuery(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		Query q = session.createQuery("");
		session.beginTransaction();
		
		
		
	}
	
	
}
