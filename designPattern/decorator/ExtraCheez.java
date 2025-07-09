package designPattern.decorator;

public class ExtraCheez extends ToppingDecorator{

    BasePizza basePizza;

    public ExtraCheez(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return this.basePizza.cost()+10;
    }
}