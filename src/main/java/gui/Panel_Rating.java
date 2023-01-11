package gui;

import db.ListenerDb;
import db.ListenerVotesSongDb;
import logik.Listener;
import logik.listener_votes_song;
import org.jboss.jandex.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.HttpResponse;

public class Panel_Rating extends JPanel implements ActionListener {

    db.ListenerDb listenerDb = new ListenerDb();
    MainFrame frame;
    public db.ListenerVotesSongDb listenerVotesSongDb;
    public logik.listener_votes_song lvs;
    static public JLabel test;
    public JButton upvote;
    public JButton downvote;
    public Panel_Rating(MainFrame frame){
        this.frame = frame;
        setBackground(Color.white);
        setPreferredSize(new Dimension(frame.WIDTH/3, frame.HEIGHT));
        setLayout(new GridLayout(3,3,20,20));
        test = new JLabel(Panel_Random_Songs.songs.get(0) + " ", SwingConstants.CENTER);
        listenerVotesSongDb = new ListenerVotesSongDb();

        //Button für Upvoten
        upvote = new JButton("Upvote");
        upvote.setBackground(new Color(191, 128, 255));
        upvote.addActionListener(this);

        //Button für Downvoten
        downvote = new JButton("Downvote");
        downvote.setBackground(new Color(191, 128, 255));
        downvote.addActionListener(this);

        //Alle Elemente zum JPanel hinufügen
        add(upvote);
        add(test);
        add(downvote);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upvote){
            if(frame.listener != null){
                Listener l = listenerDb.getListener(frame.listener.getEmail(), frame.listener.getPassword());
                lvs = new listener_votes_song(l, Panel_Random_Songs.songs.get(Panel_Random_Songs.index) , 1, 0);
                //Panel_Favorites.songs.add(Panel_Random_Songs.songs.get(Panel_Random_Songs.index));
                Panel_Favorites.addSongToList(Panel_Random_Songs.songs.get(Panel_Random_Songs.index));
                listenerVotesSongDb.voting(lvs);
                upvote.setEnabled(false);
                downvote.setEnabled(false);
            }
        }
        if(e.getSource() == downvote){
            if(frame.listener != null){
                Listener l = listenerDb.getListener(frame.listener.getEmail(), frame.listener.getPassword());
                lvs = new listener_votes_song(l, Panel_Random_Songs.songs.get(Panel_Random_Songs.index), 0, 1);
                listenerVotesSongDb.voting(lvs);
                downvote.setEnabled(false);
                upvote.setEnabled(false);
            }
        }
    }
}
