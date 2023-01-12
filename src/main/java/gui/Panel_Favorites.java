package gui;

import logik.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_Favorites extends JPanel {

    static MainFrame frame;
    public static JList list;
    public static ArrayList<Song> songs;
    public static DefaultListModel model = new DefaultListModel();
    public JLabel ratefy = new JLabel("Ratefy© ", SwingConstants.RIGHT);

    public Panel_Favorites(MainFrame frame){
        this.frame = frame;
        //setBackground(Color.yellow);
        setPreferredSize(new Dimension(frame.WIDTH/3, frame.HEIGHT));
        setLayout(new BorderLayout());
        //setBackground(Color.white);

        createList();

        JScrollPane sp = new JScrollPane();
        sp.setViewportView(list);

        ratefy.setFont(new Font("", Font.BOLD, 26));
        ratefy.setForeground(new Color(29, 185, 84));
        add(ratefy, BorderLayout.SOUTH);
        //ratefy.setBackground(Color.white);
        add(sp, BorderLayout.CENTER);
    }

    public static void createList(){
        try{
            songs = frame.songDb.listenerlikedsongs(frame.listener.getListenerid(), 1);
            for (int i = 0; i < songs.size(); i++) {
                model.addElement(songs.get(i).getSong_name()+" - "+songs.get(i).getAlbum());
            }

        }catch (Throwable ex){
            System.out.println("fehler");
        }
        if(model != null){
            list = new JList(model);
        }
    }

    public static void addSongToList(Song song){
        model.addElement(song.getSong_name()+" - "+song.getAlbum());
        list.setModel(model);
    }
}
