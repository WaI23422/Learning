package AbstractFactoryPattern.CreateShape.Factory;

import AbstractFactoryPattern.CreateShape.Shape.Interface.Shape;

public abstract class AbstractFactory {
    abstract Shape getShape(String shapeType) ;
}