package designPattern.factory;

import designPattern.factory.Shape;
import designPattern.factory.Factory;

public class Main {

    public static void main(String[] args) {
        Factory shapeFactory = new Factory();
        Shape shapeCircle = shapeFactory.getShape("CIRCLE");
        shapeCircle.draw();
    }
}