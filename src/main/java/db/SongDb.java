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

    public static ArrayList<Song> listenerlikedsongs(int listenerid, int upvote){
        Session session = HibernateUtil.getSession();
        SQLQuery query = session.createSQLQuery("SELECT song.songid FROM listener_votes_song JOIN song ON song.songid = listener_votes_song.songid JOIN listener ON listener.listenerid = listener_votes_song.listenerid WHERE listener.listenerid = :listenerid and listener_votes_song.upvote = :upvote\n");
        query.setParameter("listenerid", listenerid);
        query.setParameter("upvote", upvote);
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

    public static ArrayList<Song> notLikedSongs(int listenerid){
        Session session = HibernateUtil.getSession();
        SQLQuery query = session.createSQLQuery("SELECT song.songid FROM song WHERE song.songid NOT IN (SELECT listener_votes_song.songid FROM listener_votes_song WHERE listener_votes_song.listenerid = :listenerid)");
        query.setParameter("listenerid", listenerid);
        List<Object> results = query.list();
        ArrayList<Song> songs = new ArrayList<>();

        if(results != null){
            for (Object id: results) {
                songs.add((Song) session.get(Song.class, Integer.parseInt(id.toString())));
            }
            return songs;
        } else {
            throw new Error("Error songs:(");
        }

    }
}
