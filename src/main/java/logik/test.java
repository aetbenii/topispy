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
        listener_votes_song lvs = new listener_votes_song(l, songs.get(0),1,0 );
        listenerVotesSongDb.voting(lvs);
        ArrayList<Song> songies = songDb.listenerlikedsongs(1,1);
        System.out.println(songies);

    }
}
