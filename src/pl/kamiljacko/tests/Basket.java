package pl.kamiljacko.tests;


import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<String, Double> orderedItems;

    public Basket() {
        this.orderedItems = new HashMap();
    }

    public boolean addItems(Item... item) {
        for (int i = 0; i < item.length; i++) {
            if (orderedItems.containsKey(item[i].getName())) {
                System.out.println("There is " + item[i].getName() + " already in the basket");
                return false;
            } else {
                orderedItems.put(item[i].getName(), item[i].getPrice());
            }
        }
        return true;
    }

    public String deleteItems(Item... item) {
        for (int i = 0; i < item.length; i++) {
            if (!orderedItems.containsKey(item[i].getName())) {
                return "there is no " + item[i].getName() + " in the basket";
            } else {
                orderedItems.remove(item[i].getName());
            }
        }
        return "ok";
    }

    public void showBasket() {
        orderedItems.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    public double summaryPrice() {
        double price = 0.0;
        for (Map.Entry<String, Double> entry : orderedItems.entrySet()) {
            price += entry.getValue();
        }
        return price;
    }

}
