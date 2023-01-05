package logik;

import java.util.HashSet;
import java.util.Set;

public class Listener {
    private int listenerid;
    private String listener_name;
    private String email;
    private String password;
    private Set<Song> songSet = new HashSet<>();

    public Listener() {
    }

    public int getListenerid() {
        return listenerid;
    }

    public void setListenerid(int listenerid) {
        this.listenerid = listenerid;
    }

    public String getListener_name() {
        return listener_name;
    }

    public void setListener_name(String listener_name) {
        this.listener_name = listener_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Song> getSongSet() {
        return songSet;
    }

    public void setSongSet(Set<Song> songSet) {
        this.songSet = songSet;
    }
}
