package db;

import logik.HibernateUtil;
import logik.listener_votes_song;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ListenerVotesSongDb {

    public static listener_votes_song getByListener(int listenerId, int songId) throws Error {
        Session session = HibernateUtil.getSession();

        SQLQuery query = session.createSQLQuery("select listener_votes_songid from listener_votes_song where listenerid = :lsid and songid = :sid");
        query.setParameter("lsid", listenerId);
        query.setParameter("sid", songId);

        Object resultObj = query.uniqueResult();
        if (resultObj != null) {
            return (listener_votes_song) session.get(listener_votes_song.class, Integer.parseInt(resultObj.toString()));
        } else {
            throw new Error("Email/password is incorrect!");
        }
    }

    public static void voting(listener_votes_song lvs){
        Session session = HibernateUtil.getSession();
        session.save(lvs);
        session.getTransaction().commit();
    }
}
