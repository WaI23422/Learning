package AbstractFactoryPattern.CreateShape.Factory;

import AbstractFactoryPattern.CreateShape.Shape.RoundedRectangle;
import AbstractFactoryPattern.CreateShape.Shape.RoundedSquare;
import AbstractFactoryPattern.CreateShape.Shape.Interface.Shape;

public class RoundedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){    
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();         
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }	 
        return null;
    }
}
