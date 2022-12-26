package src; // To told the java program that this file can be access via "import src.*"

public class Data {
    private String name;
    private String cat;
    private int quantity;

    public Data(String name, String category, int quantity) {
        this.name = name;
        this.quantity = quantity;
        cat = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCat(String newCat)
    {
        cat = newCat;
    }

    public String getCat()
    {
        return cat;
    }

}
