package behavioral.command.simpleremote2.solution;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ali Katkar
 */
public class KeyPad extends JPanel{
    
    private final SimpleRemoteControl parent;
    
    public KeyPad(SimpleRemoteControl parent){
        this.parent = parent;
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
                if("*".equals(caption) || "#".equals(caption))
                    this.add(new SignKey(caption, parent));
                else this.add(new DigitKey(caption, parent));
            }
        }
    }   
}