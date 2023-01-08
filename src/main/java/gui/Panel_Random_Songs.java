package gui;

import db.SongDb;
import logik.HibernateUtil;
import logik.Song;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

public class Panel_Random_Songs extends JPanel implements ActionListener {
    db.SongDb songDb;
    MainFrame frame;
    JButton btn;
    JList list;
    JPanel info;
    ArrayList<JLabel> info_song;
    public static String[] songinfo;
    public ArrayList<Song> songs;
    public static int index;

    public Panel_Random_Songs(MainFrame frame){
        //setBackground(Color.RED);
        this.songDb = frame.songDb = new SongDb();
        this.frame = frame;
        this.songs = frame.songs;
        setPreferredSize(new Dimension(frame.WIDTH/3, frame.HEIGHT));
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        //Songs in Liste

        createList();



        JScrollPane sp = new JScrollPane();
        sp.setPreferredSize(new Dimension(100, 450));
        sp.setViewportView(list);

        btn = new JButton("Check");
        btn.setPreferredSize(new Dimension(100, 25));
        btn.addActionListener(this);
        btn.setBackground(Color.lightGray);

        info = new JPanel();
        info.setPreferredSize(new Dimension(100, 225));
        info.setLayout(new GridLayout(2,1,20,20));
        info.setBackground(Color.white);
        info_song = new ArrayList<>();
        info_song.add(new JLabel("Song Name: "));
        info_song.add(new JLabel("Song Album: "));
        info.add(info_song.get(0));
        info.add(info_song.get(1));

        //In der Liste das ranking anzeigen lassen.


        add(sp, BorderLayout.NORTH);
        add(btn, BorderLayout.CENTER);
        add(info, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            index = list.getSelectedIndex();
            songinfo = songs.get(index).toString().split("-");
            System.out.println(songinfo[1]);

            if(index >= 0){
                info_song.get(0).setText("Song Name: " + songinfo[0]);
                info_song.get(1).setText("Song Album: " + songinfo[1]);
                Panel_Rating.test.setText(" "+songinfo[0]);
            }
        }
    }

    //Lieder die geupvotet werden sollen in der Liste der Favorites
    //create list for all songs
    public void createList(){
        try{
            songs = songDb.notLikedSongs(frame.listener.getListenerid());
        }catch (Throwable ex){
            System.out.println("fehler");
        }
        if(songs != null){
            list = new JList(songs.toArray());
        }
    }
}
