package src; // To told the java program that this file can be access via "import src.*"

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

import java.util.ArrayList;

import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;

import src.helper.useMouse;

public class Item {
    public Item() {
        Window gui = new Window();
        ArrayList<JComponent> components = new ArrayList<>();
        DatabaseManager db = new DatabaseManager();

        JLabel itemName = new JLabel("Item Name");
        itemName.setBounds(160, 130, 100, 50);
        components.add(itemName);
        
        JTextField itemNameField = new JTextField();
        itemNameField.setBounds(230, 148, 120, 20);
        components.add(itemNameField);
        
        JLabel quantity = new JLabel("Quantity");
        quantity.setBounds(160, 166, 100, 50);
        components.add(quantity);
        
        JTextField quantityField = new JTextField();
        quantityField.setBounds(230, 184, 120, 20);
        components.add(quantityField);

        JLabel category = new JLabel("Category");
        category.setBounds(160, 200, 100, 50);
        components.add(category);

        JComboBox<String> data = new JComboBox<>();
        for(String b : new DatabaseManager().getCat())
            data.addItem(b);
        data.setBounds(230, 218, 120, 20);
        components.add(data);

        JButton next = new JButton("Next");
        next.setBounds(570, 320, 120, 50);
        next.setBackground(Color.CYAN);
        next.addActionListener((e) -> {
            gui.switchJPanel("Listt");
        });
        components.add(next);
        
        JToggleButton toggle = new JToggleButton("Add Category");
        toggle.setBounds(570, 240, 120, 50);
        toggle.setBackground(Color.green);
        toggle.addActionListener((e) -> {
            if(toggle.isSelected()) {
                itemName.setText("Category Name");
                itemName.setLocation(itemName.getLocation().x-20, itemName.getLocation().y);
                quantity.setVisible(false);
                quantityField.setVisible(false);
                category.setVisible(false);
                data.setVisible(false);
                next.setVisible(false);
            }
            else {
                itemName.setText("Item Name");
                itemName.setLocation(itemName.getLocation().x+20, itemName.getLocation().y);
                quantity.setVisible(true);
                quantityField.setVisible(true);
                category.setVisible(true);
                data.setVisible(true);
                next.setVisible(true);
            }
        });
        components.add(toggle);

        JButton back = new JButton("Back");
        back.setBounds(570, 400, 120, 50);
        back.setBackground(Color.orange);
        back.addActionListener((e) -> {
            gui.switchJPanel("main");
            if(toggle.isSelected()) {
                toggle.doClick();
            }
        });
        components.add(back);

        JButton submit = new JButton("Submit");
        submit.setBounds(230, 250, 120, 20);
        submit.addActionListener((e) -> {
            if(!toggle.isSelected()) {
                String name = itemNameField.getText();
                String quan = quantityField.getText();
                int cat = Integer.parseInt(data.getSelectedItem().toString());
                
                // Add object Data here
                db.insertData(new Data(name, quan, cat));
                return;
            }
            
        });
        components.add(submit);

        JPanel panel = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                Image background = new ImageIcon("Image/item4.jpg").getImage();
                g.drawImage(background, 0, 0, null);
            }
        };
        panel.setLayout(null);

        for(JComponent a : components)
            panel.add(a);

        new Sidebar(panel);

        gui.insertJPanel("Item", panel);
    }
}

