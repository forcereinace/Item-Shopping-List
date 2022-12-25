package src;
import java.io.File;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class DatabaseManager {
    static HashMap<String, ArrayList<Data>> category = new HashMap<>();
    static ArrayList<String> catName = new ArrayList<>();

    public DatabaseManager() 
    {
        if (category.isEmpty()) {
            gatherDataFromFolder();
        }
    };

    public ArrayList<String> getCat()
    {
        return catName;
    }

    public ArrayList<Data> getList()
    {
        ArrayList<Data> all = new ArrayList<>();
        for(String a : catName)
            for(Data b : category.get(a))
                all.add(b);

        return all;
    }

    public HashMap<String, ArrayList<Data>> getListWithCat()
    {
        return category;
    } 

    public void refresh()
    {
        gatherDataFromFolder();
    }

    private void gatherDataFromFolder() 
    {
        File folder = new File("Database/");
        for(File a : folder.listFiles())
        {
            String catType = a.getName();
            ArrayList<Data> cat = new ArrayList<>();
            try
            {
                Scanner reading = new Scanner(a);
                while(reading.hasNextLine())
                {
                    String line = reading.nextLine();
                    String[] data = line.split(":");
                    String name = ""; int quantity;
                    if(data[0].equalsIgnoreCase("name"))
                        name = data[1].replace('_', ' ');
                    if(data[0].equalsIgnoreCase("quantity"))
                    {
                        quantity = Integer.parseInt(data[1]);
                        cat.add(new Data(name, quantity, catType));
                    }
                }
                reading.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            catName.add(catType);
            category.put(catType, cat);
        }
    }

}
