package AbstractFactoryPattern.CreateShape.Factory;

import AbstractFactoryPattern.CreateShape.Shape.Rectangle;
import AbstractFactoryPattern.CreateShape.Shape.Square;
import AbstractFactoryPattern.CreateShape.Shape.Interface.Shape;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){    
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();         
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }	 
        return null;
    }
    }