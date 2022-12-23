package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public final int WIDTH = 1000;
    public final int HEIGHT = 700;
    Random_Songs random_songs;
    Input_Data input_data;
    public MainFrame() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("rateify");

        random_songs = new Random_Songs();
        getContentPane().add(random_songs, BorderLayout.CENTER);
        input_data = new Input_Data();
        getContentPane().add(input_data, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
