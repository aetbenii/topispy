package logik;

import db.SongDb;
import org.hibernate.Session;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {


        //Listener l = new Listener();


        //l.setListener_name("beni");
        //l.setEmail("kevin@email.com");
        //l.setPassword("123");

        HibernateUtil.buildSessionFactory();
        //Get Session
        Session session = HibernateUtil.getSession();
        //start transaction
        session.beginTransaction();
        Listener neger = (Listener) session.get(Listener.class, 1);

        System.out.println(neger.getEmail());



        //Save the Model object
       // session.save(l);
//		session.save(cart);
//		session.save(item1);
//		session.save(item2);

        //session.save(emp);
        //EmployeeTest.readEmployee(session,1);
        //Commit transaction
        session.getTransaction().commit();

        //System.out.println("Employee ID="+emp.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.close();
    }
}
