import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.HashMap;
import java.util.ArrayList;

public class Window
{
    static JFrame frame;
    static HashMap<String, JPanel> map = new HashMap<>();
    static ArrayList<String> namelist =  new ArrayList<>();

    public Window(){};
    public Window(String name, int w, int h)
    {
        frame = new JFrame(name);
        frame.setSize(w, h);

        frame.setIconImage(new ImageIcon("Image/icon2.png").getImage());

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JPanel()); // empty window
    }

    public void insertJPanel(String name, JPanel panel)
    {
        if(namelist.contains(name))
            return ;
        map.put(name, panel);
        namelist.add(name);
    }

    public void switchJPanel(String name)
    {
        if(!namelist.contains(name))
            return ;
        frame.getContentPane().removeAll();
        frame.getContentPane().add(map.get(name));
        refresh();
    }

    public void refresh()
    {
        frame.revalidate();
        frame.repaint();
    }
}