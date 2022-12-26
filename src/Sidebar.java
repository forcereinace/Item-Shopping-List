package src; // To told the java program that this file can be access via "import src.*"

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JButton;

import java.util.ArrayList;

public class Sidebar {
    // only for the burger button first initialization
    static boolean closeB = false;
    public Sidebar(JPanel panel)
    {
        // store all the components
        ArrayList<JComponent> components = new ArrayList<>();
        // JFrame and JPanel manager
        Window win = new Window();
        
        JButton item = new JButton("Item");
        item.setBounds(0, 0, 100, 50);
        item.addActionListener((e) ->
        {
            win.switchJPanel("Item");
        });
        components.add(item);
        
        JButton list = new JButton("List");
        list.setBounds(0, 50, 100, 50);
        list.addActionListener((e) ->
        {
            win.switchJPanel("List");
        });
        components.add(list);

        JButton cat = new JButton("Cat");
        cat.setBounds(0, 100, 100, 50);
        cat.addActionListener((e) ->
        {
            win.switchJPanel("List");
        });
        components.add(cat);

        JButton about = new JButton("About");
        about.setBounds(0, 400, 100, 50);
        about.addActionListener((e) ->
        {
            win.switchJPanel("About");
        });
        components.add(about);

        JButton close = new JButton();
        if(!closeB)
        {
            close.setText("-->");
            close.setBounds(100, 0, 70, 50);
        }
        close.addActionListener((e) ->
        {
            // Change the state of the button
            if(item.isVisible())
            {
                close.setBounds(0, 0, 70, 50);
                close.setText("<--");
                closeB = !closeB;
                item.setVisible(false);
                list.setVisible(false);
                cat.setVisible(false);
            }
            else
            {
                close.setBounds(100, 0, 70, 50);
                close.setText("-->");
                closeB = !closeB;
                item.setVisible(true);
                list.setVisible(true);
                cat.setVisible(true);
            }
            win.refresh();
        });
        components.add(close);

        for(JComponent a : components)
            panel.add(a);
        panel.setLayout(null);
        panel.setBounds(0, 0, 200, 500);

    }
}
