package org.fage.test;

import org.fage.domain.Car;
import org.fage.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.junit.Test;

public class TestSQL {
	
	@Test
	public void testCar(){
//		Car car = new Car();
//		car.setName("法拉利");
		
		/*1.save是执行完直接发sql语句
		 *2.delete是等session关闭了才发送sql语句
		 *3.get是直接发
		 *4.update是等session关闭了才发送sql语句
		 */
		Session session = SessionFactoryUtils.getSessionFctory().getCurrentSession();
		session.beginTransaction();
		Car car = session.load(Car.class, 2);
		car.setName("法拉利");
		System.out.println("123456");
		session.getTransaction().commit();
	}
	
	
	
	
	
}
