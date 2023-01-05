package gui;

import logik.HibernateUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel_Random_Songs extends JPanel implements ActionListener {

    logik.Song song;
    JButton btn;
    JList list;
    JPanel info;
    ArrayList<JLabel> info_song;

    public Panel_Random_Songs(MainFrame frame, HibernateUtil hu){
        //setBackground(Color.RED);
        setPreferredSize(new Dimension(frame.WIDTH/3, frame.HEIGHT));
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        ArrayList<String> songs = new ArrayList<>();
        songs.add("muug");
        for (int i = 0; i < 100; i++) {
            songs.add("fisch");
        }



        list = new JList(songs.toArray());

        JScrollPane sp = new JScrollPane();
        sp.setPreferredSize(new Dimension(100, 450));
        sp.setViewportView(list);

        btn = new JButton("Check");
        btn.setPreferredSize(new Dimension(100, 25));
        btn.addActionListener(this);

        info = new JPanel();
        info.setPreferredSize(new Dimension(100, 225));
        info.setLayout(new GridLayout(2,1,20,20));
        info_song = new ArrayList<>();
        info_song.add(new JLabel("Song Name: "));
        info_song.add(new JLabel("Song Album: "));
        info.add(info_song.get(0));
        info.add(info_song.get(1));




        add(sp, BorderLayout.NORTH);
        add(btn, BorderLayout.CENTER);
        add(info, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            int index = list.getSelectedIndex();
            if(index >= 0){
                System.out.println("index selected: " + index);
                info_song.get(0).setText("Song Name: " + index);
                Panel_Rating.test.setText(" "+index);
            }
            String s = (String) list.getSelectedValue();
            if(s != null){
                System.out.println("Value Selected: " + s);
                info_song.get(1).setText("Song Album: " + s);
            }
        }
    }

    //Lieder die geupvotet werden sollen in der Liste der Favorites
}
