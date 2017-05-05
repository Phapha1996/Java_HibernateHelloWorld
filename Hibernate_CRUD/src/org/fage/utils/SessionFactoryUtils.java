package org.fage.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
	private static SessionFactory factory;
	
	static{
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		factory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
		
		/**hibernate5.0
		
		factory = new Configuration().buildSessionFactory();*/
		/*Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       
       *hibernate4.0
       */
	}
	
	
	public static SessionFactory getSessionFctory(){
		return factory;
	}
	
	
	public static void close(){
		factory.close();
	}
	
}
