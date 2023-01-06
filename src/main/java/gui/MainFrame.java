package gui;

import logik.HibernateUtil;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public final int WIDTH = 1000;
    public final int HEIGHT = 700;

    HibernateUtil hu = new HibernateUtil();
    Panel_Random_Songs random_songs;
    Panel_Input_Data input_data;
    Panel_Rating rating;
    Panel_Favorites favorites;
    Panel_Login login;

    public MainFrame() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("rateify");

        login = new Panel_Login(this, hu);
        getContentPane().add(login, BorderLayout.CENTER);
        pack();


        setVisible(true);
    }

    public void showOtherPane(){
        input_data = new Panel_Input_Data(this);
        getContentPane().add(input_data, BorderLayout.NORTH);
        random_songs = new Panel_Random_Songs(this, hu);
        getContentPane().add(random_songs, BorderLayout.WEST);
        rating = new Panel_Rating(this);
        getContentPane().add(rating, BorderLayout.CENTER);
        favorites = new Panel_Favorites(this);
        getContentPane().add(favorites, BorderLayout.EAST);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.pack();
    }

    public void removeAllPane(){
        getContentPane().removeAll();
        getContentPane().add(input_data, BorderLayout.NORTH);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.repaint();
    }



    public static void main(String[] args) {
        new MainFrame();
    }

}
