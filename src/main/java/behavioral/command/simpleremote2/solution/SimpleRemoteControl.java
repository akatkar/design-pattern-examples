package behavioral.command.simpleremote2.solution;

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
        Command command = (Command) e.getSource();
        command.execute();       
    }

    public void pressedNumber(int i) {
        System.out.println("pressed:" + i);
    }

    public void pressedSign(String i) {
        System.out.println("pressed:" + i);
    }
}
