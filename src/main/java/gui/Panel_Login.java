package gui;

import logik.HibernateUtil;
import org.jboss.jandex.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel_Login extends JPanel implements ActionListener {

    ArrayList<JTextField> input = new ArrayList<>();
    JButton btn = new JButton("Login");
    JFrame ourframe;
    MainFrame frame;
    public Panel_Login(MainFrame frame, HibernateUtil hu){
        this.frame = frame;
        JLabel title = new JLabel("LOGIN");
        add(title);
        create_inputs();
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
                //wenn true

            }else{
                // wenn falsch
                frame.getContentPane().remove(this);
                frame.showOtherPane();
                System.out.println("leer");
            }
        }
    }
}
