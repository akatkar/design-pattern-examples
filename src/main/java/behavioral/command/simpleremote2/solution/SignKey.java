package behavioral.command.simpleremote2.solution;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Ali Katkar
 */
public class SignKey extends JButton implements Command {
    
    private SimpleRemoteControl parent;
    
    public SignKey(String text, SimpleRemoteControl parent) {
        super(text);
        this.addActionListener(parent);   
        this.parent = parent;
    }

    @Override
    public void execute() {
        parent.pressedSign(this.getText());
    }   
}
