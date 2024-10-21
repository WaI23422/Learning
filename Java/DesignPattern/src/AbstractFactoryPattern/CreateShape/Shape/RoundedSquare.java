package AbstractFactoryPattern.CreateShape.Shape;

import AbstractFactoryPattern.CreateShape.Shape.Interface.Shape;

public class RoundedSquare implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside RoundedSquare::draw() method.");
   }
}