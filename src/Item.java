package src;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Item {
    public Item() {
        Window gui = new Window();
        JButton ok = new JButton();

        JPanel panel = new JPanel();
        panel.setLayout(null);
    
        new Sidebar(panel);

        gui.insertJPanel("Item", panel);
    }
}
