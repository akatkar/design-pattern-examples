package behavioral.command.simpleremote2;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ali Katkar
 */
public class KeyPad extends JPanel{
    
    private final ActionListener actionListener;
    
    public KeyPad(ActionListener actionListener){
        this.actionListener = actionListener;
        initComponents();
    }
    
    private final String[][] keyMap = {
        {"7","8","9"},
        {"4","5","6"},
        {"1","2","3"},
        {"*","0","#"}
    };
    
    private void initComponents(){
        this.setLayout(new GridLayout(keyMap.length,keyMap.length));
        
        for(String[] line : keyMap){
            for(String caption: line){
                JButton btn = new JButton(caption);
                btn.addActionListener(actionListener);
                this.add(btn);
            }
        }
    }   
}