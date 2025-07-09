package designPattern.decorator;

public class Store {

    public static void main(String[] args) {
        BasePizza pizza = new Mushroom(new ExtraCheez(new Margherita()));
        System.out.println("Total Cost: " + pizza.cost());
    }
}
