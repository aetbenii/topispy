package db;

import logik.HibernateUtil;
import logik.Listener;
import org.hibernate.Session;
import org.hibernate.SQLQuery;

public class ListenerDb
{
    public static Listener getListener(String email, String password) throws Error {
        Session session = HibernateUtil.getSession();

        SQLQuery query = session.createSQLQuery("select listenerid from listener where password = :password and email = :email");
        query.setParameter("email", email);
        query.setParameter("password", password);

        Object resultObj = query.uniqueResult();
        if (resultObj != null) {
            return (Listener) session.get(Listener.class, Integer.parseInt(resultObj.toString()));
        } else {
            throw new Error("Email/password is incorrect!");
        }
    }

    public static void createListener(Listener listener) {
        Session session = HibernateUtil.getSession();
        session.save(listener);
        session.getTransaction().commit();
    }

}
