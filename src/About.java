package src;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.Timer;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import src.helper.useMouse;

public class About {

    private JPanel panel;
    int abtI1 =0;

    public About()
    {
        Window gui = new Window();
        ArrayList<JComponent> components = new ArrayList<>();

        //PICTURE
        Image mirul = new ImageIcon("Image/test.png").getImage();
        JButton mButton = new JButton(new ImageIcon(mirul));
        mButton.setBounds(50, 40, mirul.getWidth(mButton), mirul.getHeight(mButton));
        components.add(mButton);

        Image ace = new ImageIcon("Image/ace.png").getImage();
        JButton aButton = new JButton(new ImageIcon(ace));
        aButton.setBounds(200, 40, ace.getWidth(aButton), ace.getHeight(aButton));
        components.add(aButton);

        Image rad = new ImageIcon("Image/rad.png").getImage();
        JButton rButton = new JButton(new ImageIcon(rad));
        rButton.setBounds(350, 40, rad.getWidth(rButton), rad.getHeight(rButton));
        components.add(rButton);

        Image haz = new ImageIcon("Image/haz.png").getImage();
        JButton hButton = new JButton(new ImageIcon(haz));
        hButton.setBounds(500, 40, haz.getWidth(hButton), haz.getHeight(hButton));
        components.add(hButton);

        //TEXT
        JLabel welcome = new JLabel("Welcome to CS110 Final Year Project");
        welcome.setBounds(195, 180, 5000, 100);
        welcome.setFont(new Font("Calibri", Font.BOLD, 20));
        welcome.setForeground(Color.BLACK);
        components.add(welcome);

        JLabel intro = new JLabel("TEAM LEADER");
        intro.setBounds(65, 200, 1000, 100);
        intro.setFont(new Font("Calibri", Font.BOLD, 20));
        intro.setForeground(Color.RED);
        components.add(intro);

        JLabel intro2 = new JLabel("GUI DESIGNER");
        intro2.setBounds(215, 200, 1000, 100);
        intro2.setFont(new Font("Calibri", Font.BOLD, 20));
        intro2.setForeground(Color.RED);
        components.add(intro2);

        JLabel intro3 = new JLabel("GUI DESIGNER");
        intro3.setBounds(365, 200, 1000, 100);
        intro3.setFont(new Font("Calibri", Font.BOLD, 20));
        intro3.setForeground(Color.RED);
        components.add(intro3);

        JLabel intro4 = new JLabel("GUI DESIGNER");
        intro4.setBounds(515, 200, 1000, 100);
        intro4.setFont(new Font("Calibri", Font.BOLD, 20));
        intro4.setForeground(Color.RED);
        components.add(intro4);

        //NAME
        JLabel name = new JLabel("AMIRUL");
        name.setBounds(65, 240, 1000, 50);
        name.setFont(new Font("Calibri", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        components.add(name);

        JLabel name2 = new JLabel("GRACE");
        name2.setBounds(215, 240, 1000, 50);
        name2.setFont(new Font("Calibri", Font.BOLD, 20));
        name2.setForeground(Color.BLACK);
        components.add(name2);

        JLabel name3 = new JLabel("RADHIAH");
        name3.setBounds(365, 240, 1000, 50);
        name3.setFont(new Font("Calibri", Font.BOLD, 20));
        name3.setForeground(Color.BLACK);
        components.add(name3);

        JLabel name4 = new JLabel("HAZRULLAH");
        name4.setBounds(515, 240, 1000, 50);
        name4.setFont(new Font("Calibri", Font.BOLD, 20));
        name4.setForeground(Color.BLACK);
        components.add(name4);

        //ABOUT INTRODUCTION
        String abtI = " **This software is to list any possible grocery to buy as a check list** ";
        JLabel introduction = new JLabel("");
        introduction.setBounds(50, 300, 5000, 100);
        introduction.setFont(new Font("Calibri", Font.BOLD, 20));
        introduction.setForeground(Color.BLUE);
        components.add(introduction);


        JLabel c = new JLabel("**Copyrighted 2022**");
        c.setBounds(255, 400, 5000, 100);
        c.setFont(new Font("Calibri", Font.BOLD, 15));
        c.setForeground(Color.red);
        components.add(c);


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
