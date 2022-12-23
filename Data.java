public class Data {
    private String name;
    private String cat;
    private int quantity;

    public Data(String name, int quantity, String category) {
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
