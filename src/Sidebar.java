package src; // To told the java program that this file can be access via "import src.*"

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.Color;

import java.util.ArrayList;

public class Sidebar {
    // only for the burger button first initialization
    static boolean closeB = false;
    public Sidebar(JPanel panel)
    {
        // store all the components
        ArrayList<JComponent> components = new ArrayList<>();
        ArrayList<JButton> side = new ArrayList<>();
        // JFrame and JPanel manager
        Window win = new Window();

        coord co = new coord(0, 0, 100, 51);

        JButton item = new JButton("Item");
        item.setBounds(0, co.getY(), 100, co.height);
        item.addActionListener((e) ->
        {
            win.switchJPanel("Item");
        });
        item.addMouseListener(new mousss(item, Color.green));
        side.add(item);
        
        JButton list = new JButton("List");
        list.setBounds(0, co.getY(), 100, co.height);
        list.addActionListener((e) ->
        {
            win.switchJPanel("List");
        });
        list.addMouseListener(new mousss(list, Color.green));
        side.add(list);

        JButton cat = new JButton("Categories");
        cat.setBounds(0, co.getY(), 100, co.height);
        cat.addActionListener((e) ->
        {
            win.switchJPanel("Category");
        });
        cat.addMouseListener(new mousss(cat, Color.green));
        side.add(cat);

        JButton home = new JButton("Main Menu");
        home.setBounds(0, co.getY(), 100, co.height);
        home.addActionListener((e) ->
        {
            win.switchJPanel("main");
        });
        home.addMouseListener(new mousss(home, Color.green));
        side.add(home);

        JButton about = new JButton("About");
        about.setBounds(0, 400, 100, 50);
        about.addActionListener((e) ->
        {
            win.switchJPanel("About");
        });
        about.addMouseListener(new mousss(about, Color.pink));
        side.add(about);

        JButton close = new JButton();
        close.setBorder(null);
        close.setRolloverEnabled(false);
        close.setFocusPainted(false);
        close.addMouseListener(new mousss(close, Color.blue));
        if(!closeB)
        {
            close.setText("-->");
            close.setBounds(100, 0, 70, 30);
        }
        close.addActionListener((e) ->
        {
            // Change the state of the button
            if(item.isVisible())
            {
                close.setBounds(0, 0, 70, 30);
                close.setText("<--");
                closeB = !closeB;
                for(JComponent a : side)
                    a.setVisible(false);
            }
            else
            {
                close.setBounds(100, 0, 70, 30);
                close.setText("-->");
                closeB = !closeB;
                for(JComponent a : side)
                    a.setVisible(true);
            }
            win.refresh();
        });
        components.add(close);

        for(JButton a : side)
        {
            a.setBorder(null);
            a.setFocusPainted(false);
            a.setRolloverEnabled(false);
        }

        for(JComponent a : components)
            panel.add(a);
        for(JComponent a : side)
            panel.add(a);
        panel.setLayout(null);
        panel.setBounds(0, 0, 200, 500);

    }
}

// https://stackoverflow.com/a/15404073/10613167
/*
 * - Based on the above solution
 * - We can use the concept to create the class
 * - That will receive the JButton instance 
 * - And make the class to be the child for MouseAdapter class
 * 
 */

class mousss extends MouseAdapter
{
    JButton button = null;
    Color c = null, original = null;
    static Window win = new Window();
    mousss(JButton button, Color c)
    {
        this.button = button;
        original = button.getBackground();
        this.c = c;
    }
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        button.setBackground(c);
        win.refresh();
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        win.refresh();
        button.setBackground(original);
    }    
} 

class coord
{
    public int x, y;
    public int width, height;
    
    private int interval = 0;
    coord(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.interval = height;
    }
    public int getY() {
        int old = y;
        y += interval;
        return old;
    }
}