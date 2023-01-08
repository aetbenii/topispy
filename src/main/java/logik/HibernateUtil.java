package logik;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class HibernateUtil {

    //XML based configuration
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void buildSessionFactory() {
        try {
            // main.Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("config.xml");
            System.out.println("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void close(){
        sessionFactory.close();
    }

    public static Session getSession() throws Error  {
      if(session != null) {
          return session;
      } throw new Error("Session invalid!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

}

