package AbstractFactoryPattern.CreateShape.Factory.Generator;

import AbstractFactoryPattern.CreateShape.Factory.AbstractFactory;
import AbstractFactoryPattern.CreateShape.Factory.RoundedShapeFactory;
import AbstractFactoryPattern.CreateShape.Factory.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded){   
        if(rounded){
            return new RoundedShapeFactory();         
        }else{
            return new ShapeFactory();
        }
    }
}