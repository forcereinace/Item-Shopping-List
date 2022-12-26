import javax.swing.JPanel;      // JPanel for the JFrame

/*
 * - The files management so that our folders are clear
 * - Only the Main class will be in the root folder
 */
import src.About;
import src.Category;
import src.DatabaseManager;
import src.Item;
import src.Listt;
import src.Sidebar;
import src.Window;

import javax.swing.ImageIcon;   // To read the image from filepath
import javax.swing.JButton;     // For the buttons
import javax.swing.JComponent;  // Able to store components from javax
import javax.swing.JLabel;      // For the labels
import javax.swing.Timer;       // Animation for the text

import java.awt.Image;          // Store image 
import java.awt.Graphics;       // Library to draw the background for Jpanel
import java.awt.Color;          // Change color for the buttons
import java.awt.SystemTray;     // To show the icon in the taskbar (notification)
import java.awt.TrayIcon;       // To show the icon in the taskbar (notification)
import java.awt.Toolkit;        // To show the icon in the taskbar (notification)

/*
 *  - Gather all the components in an ArrayList
 *  - benefits:
 *      - easy to add new components
 *      - easy to manage all instances of components
 */
import java.util.ArrayList;

public class run {
    int ayatc1 = 0, ayatc2 = 0; // c = counter
    run()
    {
        // store all the components
        ArrayList<JComponent> components = new ArrayList<>();
        // JFrame and JPanel manager
        Window win = new Window();

        JButton exit = new JButton("Exit");
        exit.setBounds(582, 408, 100, 50);
        exit.setBackground(Color.red);
        exit.addActionListener((e) ->
        {
            System.exit(0);
        });
        components.add(exit);

        Image home = new ImageIcon("Image/icon2.png").getImage();
        JButton homeButton = new JButton(new ImageIcon(home));
        homeButton.setBounds(422, 23, home.getWidth(homeButton), home.getHeight(homeButton));
        components.add(homeButton);

        String ayat = "WELCOME TO";
        String ayat2 = "ITEM SHOPPING LIST";

        JLabel welcome = new JLabel("");
        welcome.setBounds(479, 195, 300, 50);
        components.add(welcome);
        
        JLabel welcome2 = new JLabel("");
        welcome2.setBounds(458, 228, 300, 50);
        components.add(welcome2);
        
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
        
        Timer timer = new Timer(100, (e) -> {
            if(ayatc1 < ayat.length())
                welcome.setText(welcome.getText() + ayat.charAt(ayatc1));
            if(ayatc2 < ayat2.length())
                welcome2.setText(welcome2.getText() + ayat2.charAt(ayatc2));
        
            ayatc1++;
            ayatc2++;
        });
        timer.start();

        if(SystemTray.isSupported())
        {
            Image icon = new ImageIcon("Image/icon2.png").getImage();
            final TrayIcon trayIcon = new TrayIcon(icon, "Item Shopping List");
            final SystemTray tray = SystemTray.getSystemTray();

            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener((e) -> {
                win.toggleVisible();
            });
            try
            {
                tray.add(trayIcon);
            }
            catch(Exception e)
            {
                System.out.println("TrayIcon could not be added.");
            }
        }
        else
        {
            System.out.println("SystemTray is not supported");
        }
    }
    public static void main(String[] args) {
        /*
         *  - The JFrame (window)'s Constructor creation
         *  - JFrame and JPanel manager
        */ 
        new Window("Item Shopping List", 700, 500); 

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
