package pl.kamiljacko.tests;

public class Item {
    private double price;
    private String name;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}
