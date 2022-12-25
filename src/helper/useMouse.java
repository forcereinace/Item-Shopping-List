package src.helper;

import javax.swing.JComponent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class useMouse 
{
    public useMouse(JComponent component)
    {
        component.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e) 
            {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                component.setLocation(x,y);
                System.out.println("x: " + x + " y: " + y);
            }

            @Override
            public void mouseMoved(MouseEvent e) 
            {
            }
        });
    }
}

