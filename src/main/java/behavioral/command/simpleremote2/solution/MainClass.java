package behavioral.command.simpleremote2.solution;

import java.awt.EventQueue;

/**
 *
 * @author Ali Katkar
 */
public class MainClass {
     public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleRemoteControl control = new SimpleRemoteControl();
            control.setVisible(true);
        });
    }
}
