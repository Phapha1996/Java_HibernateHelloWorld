package org.fage.test;

import org.fage.domain.Car;
import org.fage.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.junit.Test;

public class TestSQL {
	
	@Test
	public void testCar(){
//		Car car = new Car();
//		car.setName("������");
		
		/*1.save��ִ����ֱ�ӷ�sql���
		 *2.delete�ǵ�session�ر��˲ŷ���sql���
		 *3.get��ֱ�ӷ�
		 *4.update�ǵ�session�ر��˲ŷ���sql���
		 */
		Session session = SessionFactoryUtils.getSessionFctory().getCurrentSession();
		session.beginTransaction();
		Car car = session.load(Car.class, 2);
		car.setName("������");
		System.out.println("123456");
		session.getTransaction().commit();
	}
	
	
	
	
	
}
