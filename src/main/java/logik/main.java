package logik;

import org.hibernate.Session;

public class main {
    public static void main(String[] args) {
        System.out.println("hallo");

        Listener l = new Listener();


        l.setListener_name("damian");
        l.setEmail("damian@email.com");
        l.setPassword("123");

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(l);
//		session.save(cart);
//		session.save(item1);
//		session.save(item2);

        //session.save(emp);
        //EmployeeTest.readEmployee(session,1);
        //Commit transaction
        session.getTransaction().commit();

        //System.out.println("Employee ID="+emp.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
