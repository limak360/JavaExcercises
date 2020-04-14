package pl.kamiljacko.tests;

public class Main {
    public static void main(String[] args) {

        Basket groceryBasket = new Basket();
        Item pineapple = new Item("pineapple", 3.89);
        Item potato = new Item("potato", 2.5);
        Item carrot = new Item("carrot", 2.66);
        Item vinegar = new Item("vinegar", 4.55);


        groceryBasket.addItems(pineapple, potato, carrot, vinegar);
        groceryBasket.showBasket();

        System.out.println("basket value : " + groceryBasket.summaryPrice());

        groceryBasket.deleteItems(potato);
        groceryBasket.showBasket();

        System.out.println("basket value : " + groceryBasket.summaryPrice());

        groceryBasket.deleteItems(potato, vinegar);
        groceryBasket.showBasket();

        System.out.println("basket value : " + groceryBasket.summaryPrice());
    }
}
