package logik;

public class artist_song {
    private int artist_songid;
    private Artist artist;
    private Song song;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getArtist_songid() {
        return artist_songid;
    }

    public void setArtist_songid(int artistSongid) {
        this.artist_songid = artistSongid;
    }
}
