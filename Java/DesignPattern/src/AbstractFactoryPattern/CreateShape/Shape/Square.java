package AbstractFactoryPattern.CreateShape.Shape;

import AbstractFactoryPattern.CreateShape.Shape.Interface.Shape;

public class Square implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}