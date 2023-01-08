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
    ArrayList<JTextField> input = new ArrayList<>();
    JButton btn = new JButton("Login");
    JFrame ourframe;
    MainFrame frame;
    public Panel_Login(MainFrame frame){
        this.listener = frame.listener = new Listener();
        this.frame = frame;
        JLabel title = new JLabel("LOGIN");
        add(title);
        create_inputs();
        input.get(0).setText("benny@email.com");
        input.get(1).setText("abc");
        add(btn);
        btn.addActionListener(this);

    }

    public void create_inputs(){
        for (int i = 0; i < 2; i++) {
            input.add(new JTextField("",15));
            add(input.get(i));
        }
    }

    public boolean check_inputs(){
        for (int i = 0; i < input.size(); i++) {
            if(input.get(i).getText().length() < 1) return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            if(check_inputs()){
                frame.listener = listenerDb.getListener(input.get(0).getText(), input.get(1).getText());
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
