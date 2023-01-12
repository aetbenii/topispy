package gui;

import org.jboss.jandex.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel_Input_Data extends JPanel implements ActionListener {
    ArrayList<JTextField> input = new ArrayList<>();
    ArrayList<JLabel> lb = new ArrayList<>();
    JButton button = new JButton("Highest Votes");

    MainFrame frame;
    public Panel_Input_Data(MainFrame frame){
        this.frame = frame;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        //create_inputs();
        create_lb();
        setLayout(new GridLayout(1 , 3));
        lb.get(0).setText("Songs");

        lb.get(1).setText("Voting");

        lb.get(2).setText("Favourites");


        button.addActionListener(this);
    }

    public void create_lb(){
        for (int i = 0; i < 3; i++) {
            lb.add(new JLabel(" ", SwingConstants.CENTER));
            add(lb.get(i));
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
        //es wird überprüft ob der button 'button' gedrückt wurde
        if(e.getSource() == button){
            if(check_inputs()){
                //hier weiter machen wenn alle felder befüllt sind

            }
            //hier wenn eines leer sein sollte.
            System.out.println("ich bin leer");
            frame.removeAllPane();

        }
    }


}
