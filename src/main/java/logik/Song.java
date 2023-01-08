package logik;

import java.util.Set;

public class Song {

    private int songid;
    private String song_name;
    private String album;
    private Set<Listener> listeners;
    private Set<Artist> artists;
    private Set<Genre> genres;

    public Song(){

    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Set<Listener> getListenerSet() {
        return listeners;
    }

    public void setListenerSet(Set<Listener> listenerSet) {
        this.listeners = listenerSet;
    }

    public Set<Listener> getListeners() {
        return listeners;
    }

    public void setListeners(Set<Listener> listeners) {
        this.listeners = listeners;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String toString(){
        return this.song_name+" - "+this.album;
    }
}
