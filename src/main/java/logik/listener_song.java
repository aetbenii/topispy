package logik;

public class listener_song {
    private int listenerSongId;
    private Listener listener;
    private Song song;

    public Listener getListener() {
        return this.listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public Song getSong() {
        return  this.song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getId() {
        return  this.listenerSongId;
    }

    public void setId(int id) {
        this.listenerSongId = id;
    }

    public int getListenerSongId() {
        return listenerSongId;
    }

    public void setListenerSongId(int listenerSongId) {
        this.listenerSongId = listenerSongId;
    }


}




