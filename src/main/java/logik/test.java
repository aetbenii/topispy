package logik;

import db.ListenerDb;
import db.ListenerVotesSongDb;
import db.SongDb;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();
        hu.buildSessionFactory();

       db.SongDb songDb = new SongDb();
       //ArrayList<Artist> songs = songDb.getAll();
       //System.out.println(songs.get(0));

    }
}
