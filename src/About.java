package src;
import javax.swing.JPanel;          // JPanel for the JFrame
import javax.swing.ImageIcon;       // for image png
import javax.swing.JButton;         // For the buttons
import javax.swing.JLabel;          // For the labels
import javax.swing.JComponent;      // Able to store components from javax
import javax.swing.Timer;           // Animation for the text

import java.util.ArrayList;         //Gather all the components in an ArrayList

import java.awt.Color;              // Store image 
import java.awt.Font;               // Change fonts
import java.awt.Graphics;           // Library to draw the background for Jpanel
import java.awt.Image;              // Store image 
/* 
 *   -CODING STARTS
 *      INCLUDE - PICTURE, MAIN TEXT, POSITION, ABOUT, BUTTON, NAME, ANIMATION
*/
public class About {

    private JPanel panel;
    int abtI1 =0; //counter

    public About()
    {
        Window gui = new Window();
        ArrayList<JComponent> components = new ArrayList<>();
        /*
         * PICTURES
         */
        //PICTURE mirul
        Image mirul = new ImageIcon("Image/test.png").getImage();
        JButton mButton = new JButton(new ImageIcon(mirul));
        mButton.setBounds(50, 40, mirul.getWidth(mButton), mirul.getHeight(mButton));
        components.add(mButton);
        //PICTURE ace
        Image ace = new ImageIcon("Image/ace.png").getImage();
        JButton aButton = new JButton(new ImageIcon(ace));
        aButton.setBounds(200, 40, ace.getWidth(aButton), ace.getHeight(aButton));
        components.add(aButton);
        //PICTURE rad    
        Image rad = new ImageIcon("Image/rad.png").getImage();
        JButton rButton = new JButton(new ImageIcon(rad));
        rButton.setBounds(350, 40, rad.getWidth(rButton), rad.getHeight(rButton));
        components.add(rButton);
        //PICTURE haz
        Image haz = new ImageIcon("Image/haz.png").getImage();
        JButton hButton = new JButton(new ImageIcon(haz));
        hButton.setBounds(500, 40, haz.getWidth(hButton), haz.getHeight(hButton));
        components.add(hButton);
        /*
         * TEXTS
         */
        //MAIN TEXT 
        JLabel welcome = new JLabel("Welcome to CS110 Final Year Project");
        welcome.setBounds(195, 180, 5000, 100);
        welcome.setFont(new Font("Calibri", Font.BOLD, 20));
        welcome.setForeground(Color.BLACK);
        components.add(welcome);
        /*
         * POSITIONS
         */
        //POSITION
        JLabel intro = new JLabel("TEAM LEADER");
        intro.setBounds(65, 200, 1000, 100);
        intro.setFont(new Font("Calibri", Font.BOLD, 20));
        intro.setForeground(Color.RED);
        components.add(intro);
        //POSITION
        JLabel intro2 = new JLabel("GUI DESIGNER");
        intro2.setBounds(215, 200, 1000, 100);
        intro2.setFont(new Font("Calibri", Font.BOLD, 20));
        intro2.setForeground(Color.RED);
        components.add(intro2);
        //POSITION
        JLabel intro3 = new JLabel("GUI DESIGNER");
        intro3.setBounds(365, 200, 1000, 100);
        intro3.setFont(new Font("Calibri", Font.BOLD, 20));
        intro3.setForeground(Color.RED);
        components.add(intro3);
        //POSITION
        JLabel intro4 = new JLabel("GUI DESIGNER");
        intro4.setBounds(515, 200, 1000, 100);
        intro4.setFont(new Font("Calibri", Font.BOLD, 20));
        intro4.setForeground(Color.RED);
        components.add(intro4);
        /*
         * NAMES
         */
        //NAME
        JLabel name = new JLabel("AMIRUL");
        name.setBounds(65, 240, 1000, 50);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        components.add(name);
        //NAME
        JLabel name2 = new JLabel("GRACE");
        name2.setBounds(215, 240, 1000, 50);
        name2.setFont(new Font("Calibri", Font.BOLD, 20));
        name2.setForeground(Color.BLACK);
        components.add(name2);
        //NAME
        JLabel name3 = new JLabel("RADHIAH");
        name3.setBounds(365, 240, 1000, 50);
        name3.setFont(new Font("Calibri", Font.BOLD, 20));
        name3.setForeground(Color.BLACK);
        components.add(name3);
        //NAME
        JLabel name4 = new JLabel("HAZRULLAH");
        name4.setBounds(515, 240, 1000, 50);
        name4.setFont(new Font("Calibri", Font.BOLD, 20));
        name4.setForeground(Color.BLACK);
        components.add(name4);
        /*
         * ABOUT
         */
        //ABOUT INTRODUCTION
        String abtI = " **This software is to list any possible grocery to buy as a check list** ";
        JLabel introduction = new JLabel("");
        introduction.setBounds(50, 300, 5000, 100);
        introduction.setFont(new Font("Calibri", Font.BOLD, 20));
        introduction.setForeground(Color.BLUE);
        components.add(introduction);

        //COPYRIGHTED
        JLabel c = new JLabel("**Copyrighted 2022**");
        c.setBounds(255, 400, 5000, 100);
        c.setFont(new Font("Calibri", Font.BOLD, 15));
        c.setForeground(Color.red);
        components.add(c);
        /*
         * BUTTON BACK
         */
        //Button
        JButton back = new JButton("Back");
        back.setBounds(570, 400, 120, 50);
        back.setBackground(Color.PINK);
        back.addActionListener((e) -> {
            gui.switchJPanel("main");
        });
        components.add(back);

        panel = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                Image background = new ImageIcon("Image/abt.jpg").getImage();
                g.drawImage(background, 0, 0, null);
            }
        };
        panel.setLayout(null);

        for(JComponent a : components)
            panel.add(a);
        /*
         * TEXT ANIMATION
         */
         //ANIMATION
         Timer timer = new Timer(100, (e) -> {
            if(abtI1 < abtI.length())
                introduction.setText(introduction.getText() + abtI.charAt(abtI1));

                abtI1++;
        });
        timer.start();    
    
        gui.insertJPanel("About", panel);

    }
}
