package testSimple;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import test.session.HibernateSessionFactory;
import domain.Account;

public class TestHibernate {

	@Test
	public void add(){
		Account account = new Account();
		account.setName("bbb");
		account.setSalary(123456);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction t = null;
		try{
			t = session.beginTransaction();
			session.save(account);
			t.commit();
			System.out.println("³É¹¦£¡");
		}catch(Exception e){
			System.out.println("Ê§°Ü£¡£¡");
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
}
