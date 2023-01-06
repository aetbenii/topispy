package logik;

public class listener_votes_song {
    private int listenerVotesSongId;
    private Listener listener;
    private Song song;
    private int upvote, downvote;


    public int getListenerVotesSongId() {
        return listenerVotesSongId;
    }

    public void setListenerVotesSongId(int listenerVotesSongId) {
        this.listenerVotesSongId = listenerVotesSongId;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public void upvote() {
        this.upvote++;
    }

    public void downvote() {
        this.downvote++;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }
}
