package webcalendar.common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 * Handles SessionFactory instantiation and configuration
 *
 */
public class HibernateUtils {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		if (sessionFactory==null){
			sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		}			
		
		return sessionFactory;
	}
	
}
