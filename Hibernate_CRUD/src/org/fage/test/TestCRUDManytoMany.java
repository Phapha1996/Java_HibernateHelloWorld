package org.fage.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.fage.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class TestCRUDManytoMany {
	@Test
	public void testadd(){
		Role role = new Role();
		role.setName("产品经理");
		
		Privilege p1 = new Privilege();
		p1.setName("删除商品");
		p1.setMakeTime(new Date());
		
		Privilege p2 = new Privilege();
		p2.setMakeTime(new Date());
		p2.setName("修改商品");
		
		Set<Privilege> privileges = new HashSet<Privilege>();
		privileges.add(p1);
		privileges.add(p2);
		role.setPrivileges(privileges);
		/*R_P r_p = new R_P();
		r_p.setRole(role);
		r_p.setPrivilege(p1);*/
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.save(role);
//		session.save(r_p);
		
		session.getTransaction().commit();
		factory.close();

	
	}
	
	
	
	@Test
	public void testGet(){
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Role role = session.get(Role.class, 4);
		session.close();
		factory.close();
		
		System.out.println(role.getName()+"----拥有权限数"+role.getPrivileges().size());

	}
	
	@Test
	public void testLoadUpdate(){
		Privilege p2 = new Privilege();
		p2.setMakeTime(new Date());
		p2.setName("修改商品");
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Role role = session.load(Role.class, 3);
		role.getPrivileges().add(p2);
		session.getTransaction().commit();
		factory.close();
		
	}
	
	
	
	@Test
	public void testSave2(){
		Role role = new Role();
		role.setName("销售经理");
		
		Privilege p1 = new Privilege();
		p1.setName("查询商品");
		p1.setMakeTime(new Date());
		
		Set<Privilege> privileges = new HashSet<Privilege>();
		privileges.add(p1);
		role.setPrivileges(privileges);
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(role);
		session.getTransaction().commit();
		factory.close();
	}
	
	
	
	@Test
	public void testSave3(){
		Privilege p1 = new Privilege();
		p1.setName("购买商品");
		p1.setMakeTime(new Date());
		
		
		SessionFactory factory = SessionFactoryUtils.getSessionFctory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Role role = session.load(Role.class, 1);
		role.getPrivileges().add(p1);
		session.getTransaction().commit();
		factory.close();
	}
	
	
}
