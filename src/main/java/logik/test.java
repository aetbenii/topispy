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
        ArrayList<Song> songs = songDb.getAll();
//        System.out.println(songs.get(0).toString());
//
       db.ListenerDb listenerDb = new ListenerDb();
       Listener l;
       l = listenerDb.getListener("benny@email.com", "abc");
//        System.out.println(l.toString());
//
        db.ListenerVotesSongDb listenerVotesSongDb = new ListenerVotesSongDb();
//
        ArrayList<Song> songies = songDb.listenerlikedsongs(7,1);
        System.out.println(songies);

    }
}
