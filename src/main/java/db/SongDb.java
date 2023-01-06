package db;

import logik.HibernateUtil;
import logik.Song;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class SongDb {

    public static ArrayList<Song> getAll() {
        Session session = HibernateUtil.getSession();
        SQLQuery query = session.createSQLQuery("select songid from song");
        List<Object> results = query.list();
        ArrayList<Song> songs = new ArrayList<>();

        if (results != null) {
            for (Object id : results) {
                songs.add((Song) session.get(Song.class, Integer.parseInt(id.toString())));
            }

            return songs;
        } else {
            throw new Error("Error songs :(");
        }
    }
}
