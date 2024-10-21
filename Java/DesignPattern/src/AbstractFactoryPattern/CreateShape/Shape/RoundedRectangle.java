package AbstractFactoryPattern.CreateShape.Shape;

import AbstractFactoryPattern.CreateShape.Shape.Interface.Shape;

public class RoundedRectangle implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside RoundedRectangle::draw() method.");
   }
}