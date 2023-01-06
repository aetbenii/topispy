package gui;

import org.jboss.jandex.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.HttpResponse;

public class Panel_Rating extends JPanel implements ActionListener {
    static public JLabel test;
    public JButton upvote;
    public JButton downvote;
    public Panel_Rating(MainFrame frame){
        setBackground(Color.white);
        setPreferredSize(new Dimension(frame.WIDTH/3, frame.HEIGHT));
        setLayout(new GridLayout(3,3,20,20));
        test = new JLabel("TEST", SwingConstants.CENTER);


        upvote = new JButton("Upvote");
        upvote.setBackground(Color.lightGray);
        upvote.addActionListener(this);
        downvote = new JButton("Downvote");
        downvote.setBackground(Color.lightGray);
        downvote.addActionListener(this);

        add(upvote);
        add(test);
        add(downvote);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upvote){
            System.out.println("up");
        }
        if(e.getSource() == downvote){
            System.out.println("down");
        }
    }
}
