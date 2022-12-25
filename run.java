import javax.swing.JPanel;      // JPanel for the JFrame

import src.About;
import src.Category;
import src.DatabaseManager;
import src.Item;
import src.Listt;
import src.Sidebar;
import src.Window;

import javax.swing.ImageIcon;   // To set the background image
import javax.swing.JButton;     // For the buttons
import javax.swing.JComponent;  // Able to store components from javax

import java.awt.Image;          // Store image 
import java.awt.Graphics;       // Library to draw the background for Jpanel
import java.awt.Color;          // Change color for the buttons

/*
 *  - Gather all the components in an ArrayList
 *  - benefits:
 *      - easy to add new components
 *      - easy to manage all instances of components
 */
import java.util.ArrayList;

public class run {
    run()
    {
        // store all the components
        ArrayList<JComponent> components = new ArrayList<>();
        // JFrame and JPanel manager
        Window win = new Window();

        JButton exit = new JButton("Exit");
        exit.setBounds(370, 400, 100, 50);
        exit.setBackground(Color.red);
        exit.addActionListener((e) ->
        {
            System.exit(0);
        });
        components.add(exit);

        JPanel panel = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                Image background = new ImageIcon("Image/back2.jpg").getImage();
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };
        for(JComponent a : components)
            panel.add(a);
        panel.setLayout(null);

        new Sidebar(panel);

        win.insertJPanel("main", panel);
        win.switchJPanel("main");
        
    }
    public static void main(String[] args) {
        /*
         *  - The JFrame (window)'s Constructor creation
         *  - JFrame and JPanel manager
        */ 
        new Window("Item Shopping List", 500, 500); 

        /*
         *  - Since our ways to manage the JFrame and JPanel are static
         *  - we can call them directly without creating an instance
         *  - the call will creat Jpanel from default constructor
         *  - the Jpanel will be insert into the manager (Window.java)
         */
        new run();
        new Item();   
        new Listt();
        new About();
        new Category();
        new DatabaseManager();
    }
}
