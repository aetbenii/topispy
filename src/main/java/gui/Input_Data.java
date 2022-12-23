package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Input_Data extends JPanel implements ActionListener {

    ArrayList<JTextField> input = new ArrayList<>();
    JButton button = new JButton("input");

    public Input_Data(){
        create_inputs();
        add(button);
        button.addActionListener(this);
    }

    public void create_inputs(){
        for (int i = 0; i < 4; i++) {
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
        //es wird überprüft ob der button 'button' gedrückt wurde
        if(e.getSource() == button){
            if(check_inputs()){
                //hier weiter machen wenn alle felder befüllt sind
                
            }
            //hier wenn eines leer sein sollte.

        }
    }


}