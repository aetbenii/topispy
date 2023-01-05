package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_Favorites extends JPanel {

    logik.Song song;
    JList list;
    public Panel_Favorites(MainFrame frame){
        //setBackground(Color.yellow);
        setPreferredSize(new Dimension(frame.WIDTH/3, frame.HEIGHT));
        setLayout(new BorderLayout());
        ArrayList<String> songs = new ArrayList<>();
        songs.add("muug");

        list = new JList(songs.toArray());
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(list);

        add(sp, BorderLayout.CENTER);
    }

    public void reload(){
        this.repaint();
    }
}
