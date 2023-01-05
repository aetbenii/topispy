package gui;

import org.jboss.jandex.Main;

import javax.swing.*;
import java.awt.*;
import java.net.http.HttpResponse;

public class Panel_Rating extends JPanel {
    static public JLabel test;
    public Panel_Rating(MainFrame frame){
        setBackground(Color.gray);
        setPreferredSize(new Dimension(frame.WIDTH/3, frame.HEIGHT));
        setLayout(new BorderLayout());
        test = new JLabel("TEST");
        add(test, BorderLayout.CENTER);
    }
}
