package AbstractFactoryPattern.CreateShape.Shape;

import AbstractFactoryPattern.CreateShape.Shape.Interface.Shape;

public class Rectangle implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}