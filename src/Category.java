package src; // To told the java program that this file can be access via "import src.*"

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.ImageIcon;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.HashMap;

import src.helper.useMouse;

public class Category {
    static int i = 0;
    public Category()
    {
        Window gui = new Window();
        ArrayList<JComponent> componenet = new ArrayList<>();
        DatabaseManager db = new DatabaseManager();
        ArrayList<String> category = db.getCat();

        int posx = 280 , posy = 90;
        
        /*
         * - Right 470, 90
         * - Left 280, 90
         * - y-interval 80
         */

        for(i = 0; i < category.size(); i++)
        {
            if(i % 2 == 0 && i > 1)
            {
                posx = 280;
                posy += 80;
            }
            JButton cat = new JButton(category.get(i));
            cat.setBounds(posx, posy, 120, 50);
            cat.addActionListener(e -> 
            {
                gui.switchJPanel(category.get(i));
            });
            componenet.add(cat);
            posx += 150;
        }

        JPanel panel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(new ImageIcon("Image/cat.jpg").getImage(), 0, 0, null);
            }
        };

        for(JComponent a : componenet)
            panel.add(a);
        new Sidebar(panel);
        gui.insertJPanel("Category", panel);
    }
}