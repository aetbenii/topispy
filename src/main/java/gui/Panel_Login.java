package gui;

import logik.HibernateUtil;
import logik.Listener;
import org.jboss.jandex.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Panel_Login extends JPanel implements ActionListener {

    Listener listener;
    db.ListenerDb listenerDb;

    public JTextField email;
    public JPasswordField pw;
    JButton btn = new JButton("Login");
    JFrame ourframe;
    MainFrame frame;
    public Panel_Login(MainFrame frame){
        this.listener = frame.listener = new Listener();
        this.frame = frame;
        JLabel title = new JLabel("LOGIN");

        add(title);
        create_inputs();
        email.setText("kevin@email.com");
        pw.setText("1234");

        btn.addActionListener(this);
        btn.setBackground(Color.lightGray);

        //Elemente zum JPanel hinzufügen.

        add(btn);
    }

    public void create_inputs(){
        email = new JTextField("", 20);
        pw = new JPasswordField("", 20);
        add(email);
        add(pw);
    }

    public boolean check_inputs(){
        if(email.getText().length()<1 && pw.getText().length() < 1) return false;
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){

            if(check_inputs()){
                frame.listener = listenerDb.getListener(email.getText(), String.valueOf(pw.getPassword()));
                if(frame.listener != null){
                    frame.getContentPane().remove(this);
                    frame.showOtherPane();
                    //frame.likedsongs = frame.songDb.listenerlikedsongs(listener.getListenerid(), 1);
                }
            }else{
                // wenn falsch
                System.out.println("passwort falsch");
            }
        }
    }
}
