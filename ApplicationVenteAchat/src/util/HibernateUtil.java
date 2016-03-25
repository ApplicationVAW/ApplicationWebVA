package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	//objet de session hibernate
	public static SessionFactory sessionFactory ;
	
	static {
	try{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	catch(Throwable t){
		t.printStackTrace();
		System.out.println("erreur fil instanciation mta3 sessionFactory");
	}
	
	}
	
	// getters de sessionFactory
	
	public static SessionFactory getSession(){
		return sessionFactory ;
	}
}
