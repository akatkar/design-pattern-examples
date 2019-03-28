package behavioral.command.simpleremote2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleRemoteControl extends JFrame implements ActionListener {

    public SimpleRemoteControl() {
        super("Remote Control");
        initComponents();
        setSize(230, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new KeyPad(this));
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton) e.getSource();
        switch (src.getText()) {
            case "0":
                pressedNumber(0);
                break;
            case "1":
                pressedNumber(1);
                break;
            case "2":
                pressedNumber(2);
                break;
            case "3":
                pressedNumber(3);
                break;
            case "4":
                pressedNumber(4);
                break;
            case "5":
                pressedNumber(5);
                break;
            case "6":
                pressedNumber(6);
                break;
            case "7":
                pressedNumber(7);
                break;
            case "8":
                pressedNumber(8);
                break;
            case "9":
                pressedNumber(9);
                break;
            case "*" :
                pressedSign("*");
                break;
            case "#" :
                pressedSign("#");
                break;                
        }
    }

    private void pressedNumber(int i) {
        System.out.println("pressed:" + i);
    }

    public void pressedSign(String i) {
        System.out.println("pressed:" + i);
    }
}
