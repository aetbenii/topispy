package logik;

public class genre_song {
    private int genreSongId;
    private Genre genre;
    private Song song;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getGenreSongId() {
        return genreSongId;
    }

    public void setGenreSongId(int genreSongId) {
        this.genreSongId = genreSongId;
    }
}
