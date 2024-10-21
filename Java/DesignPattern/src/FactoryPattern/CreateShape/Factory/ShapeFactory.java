package FactoryPattern.CreateShape.Factory;

import FactoryPattern.CreateShape.Shape.Circle;
import FactoryPattern.CreateShape.Shape.Rectangle;
import FactoryPattern.CreateShape.Shape.Square;
import FactoryPattern.CreateShape.Shape.Interface.Shape;

public class ShapeFactory {
	
    //use getShape method to get object of type shape 
    public Shape getShape(String shapeType){
        if(shapeType == null){ return null; }		

        if(shapeType.equalsIgnoreCase("CIRCLE")){ return new Circle(); }  
        else if(shapeType.equalsIgnoreCase("RECTANGLE")){ return new Rectangle(); } 
        else if(shapeType.equalsIgnoreCase("SQUARE")){ return new Square(); }
    
        return null;
    }
}
